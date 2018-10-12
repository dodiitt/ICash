package com.icash.provider.offer_toro;

import com.icash.handler.NotificationService;
import com.icash.provider.AbstractProviderHandler;
import com.icash.provider_response.OfferToroResponse;
import com.icash.service.EarningHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("offerToroHandler")
public class OfferToroHandlerImpl extends AbstractProviderHandler<OfferToroResponse> implements OfferToroHandler {

    @Autowired
    @Qualifier("userNotificationHandler")
    private NotificationService notificationService;

    @Autowired
    private EarningHistoryService earningHistoryService;

    @Override
    public void handle(OfferToroResponse data) {

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
