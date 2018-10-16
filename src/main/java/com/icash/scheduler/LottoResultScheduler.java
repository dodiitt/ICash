package com.icash.scheduler;

import com.icash.service.LottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LottoResultScheduler {

    @Autowired
    private LottoService lottoService;

    @Scheduled(cron = "* * * * * *")
    private void processLotto(){

    }
}
