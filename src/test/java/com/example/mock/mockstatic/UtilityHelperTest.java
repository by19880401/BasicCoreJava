package com.example.mock.mockstatic;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 如果想要对某个类的静态方法进行mock，则必须在PrepareForTest后面加上相应的类名, 比如此例的Utility.class
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Utility.class)
public class UtilityHelperTest {

    private UtilityHelper utilityHelper;
    private List<Integer> dataList;

    @Before
    public void setup() {
        /**
         * 在对该静态类的某个方法进行mock之前，还必须先对该整个静态类进行mock
         */
        PowerMockito.mockStatic(Utility.class);

        dataList = new ArrayList<>();
        dataList.add(1);
        dataList.add(2);
        dataList.add(3);

        utilityHelper = new UtilityHelper();

    }

    @Test
    public void testSum01() {
        /**
         * 在testSum_1方法中，我们对listIsNullOrEmpty进行了mock
         * 可以看到虽然入参非空，但是由于返回值返回了true，使得调用sum方法返回的值是0
         * 如果在mock过程中，遇到一些需要特殊参数的方法，或者无法手动编造的参数，可用Mockito.any() 或Mockito.anyString() 或 Mockito.anyList() 等等，
         * 具体用什么参数代替，可以去Mockito的父类Matchers里面去找一下，可以说大部分都能找到
         */
        PowerMockito.when(Utility.listIsNullOrEmpty(Mockito.anyList())).thenReturn(true);

        Assert.assertEquals(0, utilityHelper.sum(dataList));

        /**
         * 如果我们想要验证某静态方法是否被调用，或者被调用了几次，我们可以用如下方式验证：
         * 先使用verifyStatic方法表明要验证静态方法，可以带参数，也可以不带参数，其参数可以使用Mockito的times方法或never方法来表示其调用次数。
         * 下面紧跟着的一行则表示要验证的是哪个已经mock的静态方法
         *
         * 1表示该方法在使用的过程中被调用了1次，如果你这里写了2，但该方法实际仅调用了1次，则会验证不通过（Exception: Wanted 2 times but was 1 time）
         */
        PowerMockito.verifyStatic(Mockito.times(1));
        Utility.listIsNullOrEmpty(Mockito.anyList());
    }

    @Test
    public void testSum02() {
        PowerMockito.when(Utility.listIsNullOrEmpty(Mockito.anyList())).thenReturn(false);
        int sumResult = utilityHelper.sum(dataList);

        Assert.assertEquals(6, sumResult);
    }

    @Test
    public void testProduct1() {
        PowerMockito.when(Utility.listIsNotNullOrEmpty(Mockito.anyList())).thenReturn(false);
        Assert.assertEquals(1, utilityHelper.product(dataList));
    }

    @Test
    public void testProduct2() {
        PowerMockito.when(Utility.listIsNotNullOrEmpty(Mockito.anyList())).thenReturn(true);
        int productResult = utilityHelper.product(dataList);
        Assert.assertEquals(6, productResult);
    }

    /**
     * 该方法的测试效果同testProduct1，它是testProduct1的另外一种写法
     */
    @Test
    public void testProduct1_1() {
        /**
         * 在testProduct1_1中，我们可以看到并没有对product中调用的listIsNotNullOrEmpty进行mock，那么为什么返回值是 1 呢？
         * 原因：主要是因为我们在setup方法中对使用mockStatic方法对Utility.class进行了mock，那么此时该类中的所有方法实际上都已经被mock了，
         * 如果没有对某个方法进行具体mock返回值，则调用该方法时，会直接返回对应返回类型的默认值，并不会执行真正的方法。
         * 此例对于listIsNotNullOrEmpty方法来说，其返回类型为boolean型，其默认值为false，所以product方法返回 1
         *
         *
         * 如果我们想对已经mock的类的某个方法调用真实的方法，而不是调用mock方法，那么该如何处理呢？此处我们介绍两种实现:分别是testProduct2_1和testProduct2_2
         *
         *
         */
        Assert.assertEquals(1, utilityHelper.product(dataList));
    }

    /**
     * 该方法的测试效果同testProduct2，它是testProduct2的另外一种写法
     */
    @Test
    public void testProduct2_1() {
        /**
         * 加了下面一行后，虽然也没有对listIsNotNullOrEmpty进行mock，但此时返回值是真正的值，说明没有调用默认的mock方法。
         * 使用spy后，虽然已经对该类做了mockStatic处理，但此时该类中的所有方法仍然都会调用真实的方法，而不是默认的mock方法。
         * 这种用法主要适用于只想要对某个类的少量方法进行mock，其他方法仍然执行真正的方法，平常写时，可以紧跟在mockStatic方法后
         */
        PowerMockito.spy(Utility.class);
        int productResult = utilityHelper.product(dataList);
        Assert.assertEquals(6, productResult);
    }

    /**
     * 该方法的测试效果同testProduct2，它是testProduct2的另外一种写法
     */
    @Test
    public void testProduct2_2() {
        /**
         * 下面一行的含义就是调用到mock类的该方法执行真正的方法，而不是mock方法。这种方式就是需要对每个要执行的方法都要进行相应的mock处理
         */
        PowerMockito.when(Utility.listIsNotNullOrEmpty(Mockito.anyList())).thenCallRealMethod();
        int productResult = utilityHelper.product(dataList);
        Assert.assertEquals(6, productResult);
    }

    /**
     * 总结：
     * 上述testProduct2_1和testProduct2_2两种方式，可以根据自己的需要进行选择使用哪一种。但是一定要记得，只要使用了mockStatic某类时，该类中的所有方法就已经都默认被mock了， 在调用该类的方法时，必须根据具体方法进行相应的处理
     */
}
