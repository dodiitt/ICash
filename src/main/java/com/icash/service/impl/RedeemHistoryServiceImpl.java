package com.icash.service.impl;

import com.icash.entity.RedeemHistory;
import com.icash.repository.RedeemHistoryRepository;
import com.icash.service.RedeemHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class RedeemHistoryServiceImpl implements RedeemHistoryService {

    @Value("${redeem.history.size}")
    private Integer size;

    @Autowired
    private RedeemHistoryRepository redeemHistoryRepository;

    @Override
    public Page<RedeemHistory> getRedeemHistories(String userID, Integer page) {
        if(page <= 0){
            page = 1;
        }
        return this.redeemHistoryRepository.findAllRedeemHistoryByUserID(userID, new PageRequest(page -1 , size, orderBy()));
    }

    private Sort orderBy() {
        return new Sort(Sort.Direction.DESC, "time");
    }
}
