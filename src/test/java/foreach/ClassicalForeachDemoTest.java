package foreach;

import com.objectiva.foreach.ClassicalForeachDemo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(PowerMockRunner.class)
public class ClassicalForeachDemoTest {

    @Test
    public void testHasAvailableBgpJobsWithEmptyList() {
        ClassicalForeachDemo demo = Mockito.spy(ClassicalForeachDemo.class);
        PowerMockito.when(demo.getList()).thenReturn(new ArrayList<>());
        Assert.assertTrue(demo.hasAvailableBgpJobs(Mockito.anyList()));
    }

    @Test
    public void testHasAvailableBgpJobsWithBoth0List() {
        ClassicalForeachDemo demo = Mockito.spy(ClassicalForeachDemo.class);
        PowerMockito.when(demo.getList()).thenReturn(mockBoth0List());
        Assert.assertFalse(demo.hasAvailableBgpJobs(mockBoth0List()));
    }

    @Test
    public void testHasAvailableBgpJobsWith0And1List() {
        ClassicalForeachDemo demo = Mockito.spy(ClassicalForeachDemo.class);
        PowerMockito.when(demo.getList()).thenReturn(mock0And1List());
        Assert.assertTrue(demo.hasAvailableBgpJobs(mock0And1List()));
    }

    @Test
    public void testGetList() {
        ClassicalForeachDemo demo = PowerMockito.spy(new ClassicalForeachDemo());
        Assert.assertEquals(2, demo.getList().size());
    }

    private List<Integer> mockBoth0List() {
        return Arrays.asList(0, 0);
    }

    private List<Integer> mock0And1List() {
        return Arrays.asList(1, 0);
    }
}
