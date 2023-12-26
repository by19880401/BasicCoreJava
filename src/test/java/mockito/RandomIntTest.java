package mockito;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * (1) mock接管了对象的全部方法,意思是mock是产生一个新对象，该对象不含有原对象所含有的代码，只含有mock的方法
 * (2) spy将有桩实现（stubbing）的调用进行mock，其余方法仍然是实际调用, spy产生的对象含有原对象的所有方法，但mock的方法会被优先调用
 */
@RunWith(PowerMockRunner.class)
public class RandomIntTest {

    /**
     * 无参, UT可通过,但由于是mock出的randomInt对象,其方法调用都是假的,所以代码不会被覆盖
     */
    @Test
    @Ignore
    public void testGenerateRandomValue() {
        RandomInt randomInt = Mockito.mock(RandomInt.class);
        /**
         * 当调用RandomInt的generateRandomValue()方法时, 返回1
         */
        PowerMockito.doAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocation) throws Throwable {
                return 1;
            }
        }).when(randomInt).generateRandomValue();

        Assert.assertEquals(1, randomInt.generateRandomValue());
        Assert.assertNotEquals(2, randomInt.generateRandomValue());
    }

    /**
     * 同上, 如果你想测试方法真实的内部调用,请使用spy
     */
    @Test
    @Ignore
    public void testGenerateRandomValueWithParam() {
        RandomInt randomInt = Mockito.mock(RandomInt.class);
        /**
         * 当调用RandomInt的generateRandomValue(int bound)方法时, 返回2, 参数必须为10时才返回
         */
        PowerMockito.doAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocation) throws Throwable {
                // 这里可以写一些模拟逻辑
                return 2;
            }
        }).when(randomInt).generateRandomValue(10);

        Assert.assertEquals(2, randomInt.generateRandomValue(10));
        Assert.assertNotEquals(2, randomInt.generateRandomValue(9));
    }

    /**
     * 无参, 会真实调用randomInt对象内部的所有方法逻辑,代码会被覆盖到
     */
    @Test
    public void testGenerateRandomValueRealCall() {
        RandomInt randomInt = PowerMockito.spy(new RandomInt());
        /**
         * 这里的randomInt.generateRandomValue()被真实调用, 只是返回值被指定了, 是11
         */
        PowerMockito.when(randomInt.generateRandomValue()).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocation) throws Throwable {
                return 11;
            }
        });

        Assert.assertEquals(11, randomInt.generateRandomValue());
    }

    @Test
    public void testGenerateRandomValueWithParamRealCall() {
        /**
         * <T> void spy(Class<T> type)意思是:PowerMockito.spy(RandomInt.class),无返回值
         * <T> T spy(T object)意思是: 传入一个new对象, 返回一个对象实例,即PowerMockito.spy(new RandomInt()), 如下
         */
        RandomInt randomInt = PowerMockito.spy(new RandomInt());
        // TODO 不知道为什么这里不用Mockito.eq(9),而用真实的值9呢,是因为我spy调用真实的方法么
        PowerMockito.when(randomInt.generateRandomValue(9)).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocation) throws Throwable {
                return 12;
            }
        });

        Assert.assertEquals(12, randomInt.generateRandomValue(9));
    }


}
