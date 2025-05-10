package org.sid.bank_account_service.service;

import org.sid.bank_account_service.dto.BankAccountRequestDTO;
import org.sid.bank_account_service.dto.BankAccountResponseDTO;
import org.sid.bank_account_service.entities.BankAcccount;
import org.sid.bank_account_service.enums.AccountType;
import org.sid.bank_account_service.mappers.AccountMapper;
import org.sid.bank_account_service.repositories.BankAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
  @Autowired
  private BankAccountRepo bankAccountRepo;
  @Autowired
    AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAcccount bankAcccount =BankAcccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountRequestDTO.getBalance())
                .currency(bankAccountRequestDTO.getCurrency())
                .type(AccountType.valueOf(String.valueOf(bankAccountRequestDTO.getType())))
                .build();
        BankAcccount savedAccount=bankAccountRepo.save(bankAcccount);
        //utiliser mappers pour clean code (get set)
        BankAccountResponseDTO bankAccountResponseDTO =accountMapper.fromBankAccount(savedAccount);
        return bankAccountResponseDTO;
    }
}
