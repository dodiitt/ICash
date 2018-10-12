package com.icash.provider;

import com.icash.entity.EarningHistory;
import com.icash.handler.NotificationService;
import com.icash.service.EarningHistoryService;

public abstract class AbstractProviderHandler<T> implements ProviderHandler<T> {

    protected abstract EarningHistoryService getEarningHistoryService();

    protected abstract NotificationService getNotificationService();

    protected void increaseCoin(String userID, double coin){
        // TODO save earned coin for user
    }

    protected void saveEarningHistory(EarningHistory earningHistory){
        // TODO saving earning history
    }

    protected void pushNotification(String userID, String message){
        // TODO push notification to user
    }
}
