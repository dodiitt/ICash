package com.icash.service.impl;

import com.icash.entity.EarningHistory;
import com.icash.repository.EarningHistoryRepository;
import com.icash.service.EarningHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EarningHistoryServiceImpl implements EarningHistoryService {

    @Value("${earning.history.size}")
    private Integer size;

    @Autowired
    private EarningHistoryRepository earningHistoryRepository;

    @Override
    public Page<EarningHistory> getEarningHistories(String userID, Integer page) {
        if (page <= 0) {
            page = 1;
        }
        return this.earningHistoryRepository.findAllEarningHistoryByUserID(userID, new PageRequest(page - 1, size, orderBy()));
    }

    private Sort orderBy() {
        return new Sort(Sort.Direction.DESC, "time");
    }
}
