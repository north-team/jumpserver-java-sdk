package jms;

import com.jumpserver.sdk.v2.model.CloudInstance;
import com.jumpserver.sdk.v2.model.SyncInstanceTask;
import org.junit.Test;

import java.util.List;

/**
 * 用户API调用相关测试用例
 */
public class JmsXpackCloudTest extends CommonBeforeTest {

    @Test
    public void cloudInstanceTasks() {
        System.out.println("list tasks::::");
        List<SyncInstanceTask> tasks = os.cloud().cloudInstanceTasks();
        System.out.println(tasks.size());
        for (SyncInstanceTask task : tasks) {
            System.out.println(task.getName());
        }
    }

    @Test
    public void syncedCloudInstances() {
        System.out.println("list tasks::::");
        List<CloudInstance> instances = os.cloud().instances("81528a15-821d-4926-80cd-7e7380e3ebf8");
        System.out.println(instances.size());
        for (CloudInstance instance : instances) {
            System.out.println(instance.getInstance_id());
        }
    }
}
