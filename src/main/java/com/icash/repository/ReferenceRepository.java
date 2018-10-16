package com.icash.repository;

import com.icash.entity.Reference;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferenceRepository extends PagingAndSortingRepository<Reference, String> {

}
