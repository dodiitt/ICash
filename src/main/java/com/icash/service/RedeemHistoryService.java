package com.icash.service;

import com.icash.entity.RedeemHistory;
import org.springframework.data.domain.Page;

public interface RedeemHistoryService {
    Page<RedeemHistory> getRedeemHistories(String userID, Integer page);
}
