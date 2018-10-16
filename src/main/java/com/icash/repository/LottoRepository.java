package com.icash.repository;

import com.icash.entity.Lotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LottoRepository extends JpaRepository<Lotto, String> {

}
