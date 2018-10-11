package com.icash.handler;

import java.util.List;

public abstract class AbstractNotificationService implements NotificationService {

    protected abstract List<String> getRecipientsEmail(String userID);

    protected abstract List<String> getCCEmail();
}
