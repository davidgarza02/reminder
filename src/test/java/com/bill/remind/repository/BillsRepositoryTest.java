package com.bill.remind.repository;

import com.bill.remind.entity.Bill;
import com.bill.remind.entity.Category;
import com.bill.remind.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@DataJpaTest
class BillsRepositoryTest {

    @Autowired
    private BillsRepository billsRepository;

    @Test
    void addNewBill() {
        Bill newBill = new Bill(
                new Member("New user", "newusername", "newpassword"),
                "",
                0d,
                LocalDate.now(),
                10,
                new Category("new Category", "ic_res_name")
        );
        billsRepository.save(newBill);

        Optional<Bill> expected = billsRepository.findById(newBill.getBillId());
        assert (expected.isPresent());
    }

    @Test
    void withValidUserIdReturn2() {
        Optional<List<Bill>> expected = billsRepository.findByUserId(1L);

        assert (expected.isPresent());
        assert (expected.get().size() == 2);
    }

    @Test
    void withValidIdReturnSuccess(){
        Optional<Bill> expected = billsRepository.findById(1L);

        assert(expected.isPresent());
    }

    @Test
    void withInvalidIdReturnsEmpty(){
        Optional<Bill> expected = billsRepository.findById(15L);

        assert(expected.isEmpty());
    }
}