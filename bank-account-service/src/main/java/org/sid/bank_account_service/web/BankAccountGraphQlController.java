package org.sid.bank_account_service.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bank_account_service.dto.BankAccountRequestDTO;
import org.sid.bank_account_service.dto.BankAccountResponseDTO;
import org.sid.bank_account_service.entities.BankAcccount;
import org.sid.bank_account_service.repositories.BankAccountRepo;
import org.sid.bank_account_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

//pour api graphQL
//l appel se fait :http://localhost:8080/graphiql
//on passe:  query{
//  accountList{
//    id,balance //je veux juste id et la balance
//  }
//}
@Controller
public class BankAccountGraphQlController {
    @Autowired
    private BankAccountRepo bankAccountRepo;
    @Autowired
    private AccountService accountService;
    @QueryMapping
    public List<BankAcccount> accountList(){
        return bankAccountRepo.findAll();
    }
    @QueryMapping
    public BankAcccount bankAccountById(@Argument String id){
        return bankAccountRepo.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found",id)));
    }
    @MutationMapping //c preque comme un postMapping
    public BankAccountResponseDTO addAccount(@Argument("bankAccount") BankAccountRequestDTO bankAccountDTO){
        BankAccountResponseDTO bankAccountResponseDTO=accountService.addAccount(bankAccountDTO);
        System.out.println("body"+bankAccountResponseDTO.toString());
        return bankAccountResponseDTO;
    }
}

