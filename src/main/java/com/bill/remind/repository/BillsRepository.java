package com.bill.remind.repository;

import com.bill.remind.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BillsRepository extends JpaRepository<Bill, Long> {
    Optional<List<Bill>> findByMemberIdAndIsDeletedFalse(Long userId);

    Optional<List<Bill>> isDeletedFalse();

}
