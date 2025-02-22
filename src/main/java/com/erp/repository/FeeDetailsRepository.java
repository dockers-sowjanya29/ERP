package com.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.entity.FeeDetails;

@Repository
public interface FeeDetailsRepository extends JpaRepository<FeeDetails, Long> {

//	 @Query("select (fd.total_amount - fd.amount_paid) balance from fee_details fd where fd.student_id=?1")
	// public Long getBalanceAmountForStudent(Long studentId);

}
