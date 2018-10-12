package com.icash.provider.sample_cube;

import com.icash.handler.NotificationService;
import com.icash.provider.AbstractProviderHandler;
import com.icash.provider_response.SampleCubeResponse;
import com.icash.service.EarningHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("sampleCubeHandler")
public class SampleCubeHandlerImpl extends AbstractProviderHandler<SampleCubeResponse> implements SampleCubeHandler {


    @Autowired
    @Qualifier("userNotificationHandler")
    private NotificationService notificationService;

    @Autowired
    private EarningHistoryService earningHistoryService;


    @Override
    protected EarningHistoryService getEarningHistoryService() {
        return this.earningHistoryService;
    }

    @Override
    protected NotificationService getNotificationService() {
        return this.notificationService;
    }

    @Override
    public void handle(SampleCubeResponse data) {

    }
}
