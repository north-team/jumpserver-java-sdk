package com.jumpserver.sdk.v2.jumpserver.xpack;

import com.jumpserver.sdk.v2.common.BaseJmsService;
import com.jumpserver.sdk.v2.common.ClientConstants;
import com.jumpserver.sdk.v2.model.CloudInstance;
import com.jumpserver.sdk.v2.model.SyncInstanceTask;

import java.util.List;

public class CloudServiceImpl extends BaseJmsService implements CloudService{

    @Override
    public List<SyncInstanceTask> cloudInstanceTasks() {
        return get(SyncInstanceTask.class, ClientConstants.SYNC_INSTANCE_TASKS).executeList();
    }

    @Override
    public List<CloudInstance> instances(String taskId) {
        return get(CloudInstance.class, ClientConstants.SYNCED_CLOUD_INSTANCES.replace("{task_id}", taskId)).executeList();
    }
}
