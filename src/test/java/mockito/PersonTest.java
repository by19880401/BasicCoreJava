package mockito;

import com.objectiva.mockito.Person;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PersonTest {

    @Test
    public void testGetSex() {
        Person person = Mockito.spy(Person.class);
        person.getSex(0);//必须要调用一次, 后面才能verify到调用的次数
        Mockito.verify(person).getSex(0);//这行代码与下一行代码等效,这行代码并不会真正调用getSex()方法, 而仅是统计调用getSex()方法的次数
//        Mockito.verify(person, Mockito.times(1)).getSex(0);
        person.getSex(1);//这里调用一次参数为1的getSex()
        person.getSex(1);//这里再次调用一次参数为1的getSex()
        Mockito.verify(person, Mockito.times(2)).getSex(1);//统计参数为1的getSex()方法的调用次数, 预期应该是2次

        person.getSex(3);
        Mockito.verify(person, Mockito.times(1)).getSex(3);
    }

    @Test
    public void testGetSexAsString() {
        Person person = Mockito.spy(Person.class);
        Assert.assertEquals("Female", person.getSexAsString(0));
        Assert.assertEquals("Male", person.getSexAsString(1));
        Assert.assertEquals("Null", person.getSexAsString(2));
    }

    @Test
    public void isMan() {
        Person person = Mockito.spy(Person.class);// 如果需要调用真实的方法, 这里不可以mock, 而必须spy一个真实的Person对象
        Assert.assertTrue(person.isMan(1));
    }

}
