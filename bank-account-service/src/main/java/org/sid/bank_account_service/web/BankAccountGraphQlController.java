package org.sid.bank_account_service.web;

import org.sid.bank_account_service.entities.BankAcccount;
import org.sid.bank_account_service.repositories.BankAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
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
    @QueryMapping
    public List<BankAcccount> accountList(){
        return bankAccountRepo.findAll();
    }
    @QueryMapping
    public BankAcccount bankAccountById(@Argument String id){
        return bankAccountRepo.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found",id)));
    }
}
