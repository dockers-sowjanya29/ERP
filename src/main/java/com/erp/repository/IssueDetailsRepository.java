package com.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.erp.entity.IssueDetails;

@Repository
public interface IssueDetailsRepository extends JpaRepository<IssueDetails, Long>{
	
	 @Query("SELECT SUM(isd.quantity) FROM IssueDetails isd where isd.inventoryId=?1")
	 public Long getIssueQuantityByInventoryID(Long inventoryId);
	 
	 @Modifying
	 @Query("DELETE from  IssueDetails isd where isd.inventoryId=?1")
	 public void deleteIssueInventory(Long inventoryId);

}
