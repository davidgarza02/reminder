package com.bill.remind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}


//	@Component
//	public static class AppRunner implements ApplicationRunner{
//
//		@Autowired
//		BillsService billsService;
//		@Autowired
//		MemberService memberService;
//		@Autowired
//		CategoryService categoryService;
//
//		@Override
//		public void run(ApplicationArguments args) throws Exception {
////			Member member = new Member("David Garza", "user", "pass");
////			Member secondMember = new Member("Michel Jordan", "mich", "1234");
////			memberService.addNewMember(member);
////			memberService.addNewMember(secondMember);
////
////			Category utilities = new Category("Utilities", "ic_utilities");
////			Category creditCard = new Category("Credit Card", "ic_credit_card");
////			Category rent = new Category("Rent", "ic_rent");
////			Category loans = new Category("Loans", "ic_loans");
////			Category streaming = new Category("Streaming", "ic_streaming");
////			Category pets = new Category("Pets", "ic_pets");
////			categoryService.addNewCategory(utilities);
////			categoryService.addNewCategory(creditCard);
////			categoryService.addNewCategory(rent);
////			categoryService.addNewCategory(loans);
////			categoryService.addNewCategory(streaming);
////			categoryService.addNewCategory(pets);
////
////			Bill amexBill = new Bill("Amex platinum", 532.12, LocalDate.of(2023,1,22),30, creditCard);
//			//member.addBill(amexBill);
//			//billsService.addNewBill(amexBill);
//
//
//
//		}
//	}
}
