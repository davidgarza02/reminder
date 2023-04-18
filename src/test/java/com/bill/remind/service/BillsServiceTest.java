package com.bill.remind.service;

import com.bill.remind.entity.Bill;
import com.bill.remind.entity.Category;
import com.bill.remind.entity.Member;
import com.bill.remind.repository.BillsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
class BillsServiceTest {

    @Mock
    private BillsRepository billsRepository;
    private BillsService billsService;

    @BeforeEach
    void setUp() {
        billsService = new BillsService(billsRepository);
    }

    @Test
    void canGetBills() {
        billsService.getBills();

        Mockito.verify(billsRepository).findAll();
    }

    @Test
    void canAddNewBill() {
        Bill newBill = new Bill(
                new Member("New user", "newusername", "newpassword"),
                "",
                0d,
                LocalDate.now(),
                10,
                new Category("new Category", "ic_res_name")
        );
        billsService.createBill(newBill);


        ArgumentCaptor<Bill> billArgumentCaptor =
                ArgumentCaptor.forClass(Bill.class);

        Mockito.verify(billsRepository)
                .save(billArgumentCaptor.capture());

        Bill capturedBill = billArgumentCaptor.getValue();

        assert(capturedBill == newBill);
    }

    @Test
    void deleteInvalidBillThrowsException()  {
        Long invalidBillId = 90L;

        assertThatThrownBy(()-> billsService.deleteBill(invalidBillId))
                .hasMessage("Bill with Id " + invalidBillId + "does not exist."
        );
    }

    @Test
    void deleteBill() {
        Bill newBill = new Bill(
                new Member("New user", "newusername", "newpassword"),
                "",
                0d,
                LocalDate.now(),
                10,
                new Category("new Category", "ic_res_name")
        );
        Optional<Bill> optional = Optional.of(newBill);
        Mockito.when(billsRepository.findById(1L)).thenReturn(optional);

        billsService.deleteBill(1L);

        assert(newBill.isDeleted());
        //TODO:use assertions from mockito or assertj
    }

    @Test
    void getMyBills() {
        Bill newBill = new Bill(
                new Member("New user", "newusername", "newpassword"),
                "",
                0d,
                LocalDate.now(),
                10,
                new Category("new Category", "ic_res_name")
        );
        List<Bill> newBillsList = List.of(newBill, newBill);
        Optional<List<Bill>> optional = Optional.of(newBillsList);
        Mockito.when(billsRepository.findByUserId(1L)).thenReturn(optional);

        List<Bill> expected = billsService.getMyBills(1L);

        Mockito.verify(billsRepository).findByUserId(1L);
        assert(expected == newBillsList);
    }

    @Test
    void updateBill() {
        Bill newBill = new Bill(
                new Member("New user", "newusername", "newpassword"),
                "AmexCredit",
                0d,
                LocalDate.now(),
                10,
                new Category("new Category", "ic_res_name")
        );
        Optional<Bill> optional = Optional.of(newBill);
        Mockito.when(billsRepository.findById(1L)).thenReturn(optional);

        billsService.updateBill(1L, "NewBank",999.00,"newNotes");

        assert(newBill.getName().equals("NewBank"));
        assert(newBill.getAmount() == 999);
        assert(newBill.getNotes().equals("newNotes"));
    }
}