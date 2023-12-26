package mockstatic;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import staticmethod.MessageService;

@DisplayName("Testing using JUnit 5")
public class MessageServiceTest {

    @BeforeClass
    public static void init() {
        // 被注解的（静态）方法(即该init方法)将在当前类中的所有 @Test 方法前执行一次
    }

    @AfterClass
    public static void done() {
        // 被注解的（静态）方法将在当前类中的所有 @Test 方法后执行一次
    }

    @DisplayName("Test MessageService.getMsg()")
    @Test
    public void testGetMsg() {
        /**
         * Passed, 之所以可以这样写MessageService.getMsg(), 大概是因为MessageService是静态方法吧
         */
        Assert.assertEquals("Hello Junit 5", MessageService.getMsg());
    }
}
