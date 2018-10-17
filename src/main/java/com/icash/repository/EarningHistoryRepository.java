package com.icash.repository;

import com.icash.entity.EarningHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EarningHistoryRepository extends PagingAndSortingRepository<EarningHistory, String> {
    Page<EarningHistory> findAllEarningHistoryByUserId(String userID, Pageable pageable);
}
