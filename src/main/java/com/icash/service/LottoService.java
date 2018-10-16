package com.icash.service;

import com.icash.entity.Lotto;

import java.util.Date;
import java.util.List;

public interface LottoService {
    void betting(String userID, Integer bettingNumber);
    List<Lotto> getAllBettingInTime(String userID, Date startTime, Date endTime);
}
