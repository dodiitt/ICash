package com.icash.provider.super_rewards;

import com.icash.handler.NotificationService;
import com.icash.provider.AbstractProviderHandler;
import com.icash.provider_response.SuperRewardResponse;
import com.icash.service.EarningHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("superRewardsHandler")
public class SuperRewardsHandlerImpl extends AbstractProviderHandler<SuperRewardResponse> implements SuperRewardHandler {

    @Autowired
    @Qualifier("userNotificationHandler")
    private NotificationService notificationService;

    @Autowired
    private EarningHistoryService earningHistoryService;

    @Override
    public void handle(SuperRewardResponse data) {

    }

    @Override
    protected EarningHistoryService getEarningHistoryService() {
        return this.earningHistoryService;
    }

    @Override
    protected NotificationService getNotificationService() {
        return this.notificationService;
    }
}
