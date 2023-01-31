package com.rewards.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.rewards.model.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    
    @Query(nativeQuery = true, value = "select * from user_transactions where user_id = :userId and created_at >= now()-interval :duration month")
    public List<Transaction> getTransForUserByDuration(@Param("userId") Long userId, @Param("duration") short duration);
}