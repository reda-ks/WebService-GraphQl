package org.sid.bank_account_service.web;

import org.sid.bank_account_service.dto.BankAccountRequestDTO;
import org.sid.bank_account_service.dto.BankAccountResponseDTO;
import org.sid.bank_account_service.entities.BankAcccount;
import org.sid.bank_account_service.repositories.BankAccountRepo;
import org.sid.bank_account_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
//controleur Rest
@RestController
@RequestMapping("/api")
public class AccountRestController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private BankAccountRepo bankAccountRepo;
    @GetMapping("/bankAccounts")
    public List<BankAcccount> bankAccounts(){
        return bankAccountRepo.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public BankAcccount bankAccounts(@PathVariable String id){
        return bankAccountRepo.findById(id).orElseThrow(() -> new RuntimeException(String.format("Account numero %s not found",id)));
    }
    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO saveAccount(@RequestBody BankAccountRequestDTO bankAcccount){
        return accountService.addAccount(bankAcccount);
    }
    @PutMapping("/bankAccounts/{id}")
    public BankAcccount updateAccount(@PathVariable String id,@RequestBody BankAcccount bankAcccount){
        BankAcccount account=bankAccountRepo.findById(id).orElseThrow();
        if (bankAcccount.getBalance()!=null) account.setBalance(bankAcccount.getBalance());
        if (bankAcccount.getType()!=null) account.setType(bankAcccount.getType());
        if (bankAcccount.getCurrency()!=null) account.setCurrency(bankAcccount.getCurrency());
        if (bankAcccount.getCreatedAt()!=null) account.setCreatedAt(bankAcccount.getCreatedAt());
        return bankAccountRepo.save(account);
    }
    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
       bankAccountRepo.deleteById(id);
    }
}
