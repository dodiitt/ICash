package com.icash.repository;

import com.icash.entity.EarningHistory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EearningHistoryRepository extends PagingAndSortingRepository<EarningHistory, String> {

}
