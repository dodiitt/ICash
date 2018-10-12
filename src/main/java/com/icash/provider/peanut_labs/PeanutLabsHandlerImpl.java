package com.icash.provider.peanut_labs;

import com.icash.handler.NotificationService;
import com.icash.provider.AbstractProviderHandler;
import com.icash.provider_response.PeanutLabsResponse;
import com.icash.service.EarningHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("peanutLabsHandler")
public class PeanutLabsHandlerImpl extends AbstractProviderHandler<PeanutLabsResponse> implements PeanutLabsHandler {

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
    public void handle(PeanutLabsResponse data) {

    }
}
