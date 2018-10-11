package com.icash.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FeedOfferScheduler {

    @Scheduled(cron = "* * * * * *")
    private void feedOffer(){
        //TODO Provider will response data, we don't need to implement scheduled to feed the data; However this way make the app faster ( loaded to cache )
    }
}
