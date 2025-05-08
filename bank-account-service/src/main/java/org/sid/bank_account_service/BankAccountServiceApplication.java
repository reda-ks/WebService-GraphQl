package org.sid.bank_account_service;

import org.sid.bank_account_service.entities.BankAcccount;
import org.sid.bank_account_service.enums.AccountType;
import org.sid.bank_account_service.repositories.BankAccountRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(BankAccountRepo bankAccountRepo){
		return args -> {
			for(int i=0;i<10;i++){
				BankAcccount bankAcccount=BankAcccount.builder()
						.id((UUID.randomUUID().toString()))
						.accountType(Math.random()>0.5? AccountType.CurrentAccount:AccountType.SaveAccount)
						.balance(10000+Math.random()*90000)
						.createdAt(new Date())
						.currency("MAD")
						.build();

				bankAccountRepo.save(bankAcccount);
			}
		};
	}
}
