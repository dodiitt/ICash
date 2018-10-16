package com.icash.repository;

import com.icash.entity.RedeemHistory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedeemHistoryRepository extends PagingAndSortingRepository<RedeemHistory, String> {

}
