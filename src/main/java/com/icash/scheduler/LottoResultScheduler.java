package com.icash.scheduler;

import com.icash.service.LottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Component
public class LottoResultScheduler {


    @Value("app.game.lotto.min")
    private Integer min;

    @Value("app.game.lotto.max")
    private Integer max;

    @Value("app.game.lotto.result.size")
    private Integer size;

    @Autowired
    private LottoService lottoService;

    @Scheduled(cron = "0 8 * * *")
    private void processLotto(){
        Set<Integer> lottoResult = processResult();


    }

    private Set<Integer> processResult() {
        Set<Integer> value = new HashSet<>();
        while (value.size() < size){
            value.add(getRandomNumberInRange(min, max));
        }
        return value;
    }


    private int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
