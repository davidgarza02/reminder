package com.bill.remind.controller;

import com.bill.remind.entity.Bill;
import com.bill.remind.model.BillDTO;
import com.bill.remind.service.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bills")
public class BillsController {

    private final BillsService billsService;

    @Autowired
    public BillsController(BillsService billsService) {
        this.billsService = billsService;
    }

    @PostMapping("/createBill")
    public Bill createBill(@RequestBody(required = false) Bill bill){
        return billsService.createBill(bill);
    }

    @GetMapping
    public List<Bill> getBills(){
        return billsService.getBills();
    }

    @GetMapping("/member/{memberId}")
    public List<Bill> getBillsByMember(@PathVariable Long memberId){
        return billsService.getBillsByMember(memberId);
    }

    @PutMapping(path = "/{billId}/member/{memberId}")
    public Bill assignBillToMember(@PathVariable Long billId,
                                   @PathVariable Long memberId){
        return billsService.assignBillToMember(billId, memberId);
    }

    @PutMapping(path = "/{billId}/category/{categoryId}")
    public Bill assignBillToCategory(@PathVariable Long billId,
                                     @PathVariable Long categoryId){
        return billsService.assignBillToCategory(billId, categoryId);
    }

    @PostMapping("/createBills")
    public List<Bill> createBills(@RequestBody List<Bill> bills){
        return billsService.createNewBills(bills);
    }

    @DeleteMapping(path = "{billId}")
    public Bill deleteBill(@PathVariable Long billId){
        return billsService.deleteBill(billId);
    }

    @PatchMapping(path = "/update/{billId}")
    public Bill updateBill(@PathVariable("billId") Long billId,
                           @RequestBody BillDTO billDTO) {
        return billsService.updateBill(billId, billDTO);
    }
}
