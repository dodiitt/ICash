package com.icash.service.impl;

import com.icash.entity.Lotto;
import com.icash.service.LottoService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LottoServiceImpl implements LottoService {

    @Override
    public void betting(String userID, Integer bettingNumber) {

    }

    @Override
    public List<Lotto> getAllBettingInTime(String userID, Date startTime, Date endTime) {
        return null;
    }

    @Override
    public List<Lotto> getAllLottosInTime(Date startTime, Date endTime) {
        return null;
    }

    @Override
    public void removeLotto(String ID) {

    }
}
