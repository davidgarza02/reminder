package com.bill.remind.service;

import com.bill.remind.controller.exception.BillIsNullException;
import com.bill.remind.controller.exception.BillNotFoundException;
import com.bill.remind.controller.exception.CategoryNotFoundException;
import com.bill.remind.controller.exception.MemberNotFoundException;
import com.bill.remind.entity.Bill;
import com.bill.remind.entity.Category;
import com.bill.remind.entity.Member;
import com.bill.remind.model.BillDTO;
import com.bill.remind.repository.BillsRepository;
import com.bill.remind.repository.CategoryRepository;
import com.bill.remind.repository.MemberRepository;
import com.bill.remind.utils.JsonNullableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillsService {

    @Autowired
    BillsRepository billsRepository;
    @Autowired
    MemberRepository membersRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public List<Bill> getBills() {
        return billsRepository.isDeletedFalse().orElse(new ArrayList<>());
    }

    public List<Bill> createNewBills(List<Bill> bills) {
        return billsRepository.saveAll(bills);
    }

    public Bill createBill(Bill bill) {
        if (bill != null)
            return billsRepository.save(bill);
        else
            throw new BillIsNullException();
    }

    public Bill deleteBill(Long billId) {
        Bill bill = billsRepository.findById(billId)
                .orElseThrow(BillNotFoundException::new);
         bill.setDeleted(true);
         return billsRepository.save(bill);
    }

    public List<Bill> getBillsByMember(Long userId) {
        return billsRepository.findByMemberIdAndIsDeletedFalse(userId).orElse(new ArrayList<>());
    }

    public Bill updateBill(Long billId, BillDTO billDto) {
        Bill bill = billsRepository.findById(billId).orElseThrow(BillNotFoundException::new);

        JsonNullableUtils.changeIfPresent(billDto.getName(), bill::setName);
        JsonNullableUtils.changeIfPresent(billDto.getAmount(), bill::setAmount);
        JsonNullableUtils.changeIfPresent(billDto.getDueDate(), bill::setDueDate);
        JsonNullableUtils.changeIfPresent(billDto.getRepeat(), bill::setRepeat);
        JsonNullableUtils.changeIfPresent(billDto.getNotes(), bill::setNotes);

        return billsRepository.save(bill);
    }

    public Bill assignBillToMember(Long billId, Long memberId) {
        Bill bill = billsRepository.findById(billId).orElseThrow(BillNotFoundException::new);
        Member member = membersRepository.findById(memberId).orElseThrow(MemberNotFoundException::new);
        bill.assignMember(member);

        return billsRepository.save(bill);
    }

    public Bill assignBillToCategory(Long billId, Long categoryId) {
        Bill bill = billsRepository.findById(billId).orElseThrow(BillNotFoundException::new);
        Category category = categoryRepository.findById(categoryId).orElseThrow(CategoryNotFoundException::new);
        bill.assignCategory(category);

        return billsRepository.save(bill);
    }
}
