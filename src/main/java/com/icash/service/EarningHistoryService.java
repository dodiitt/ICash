package com.icash.service;

import com.icash.entity.EarningHistory;
import org.springframework.data.domain.Page;

public interface EarningHistoryService {
    Page<EarningHistory> getEarningHistories(String userID, Integer page);
}
