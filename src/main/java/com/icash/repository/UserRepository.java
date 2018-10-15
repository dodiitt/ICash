package com.icash.repository;

import com.icash.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT u FROM user u WHERE u.email = ?1",  nativeQuery = true)
    User findUserByEmail(String email);
}
