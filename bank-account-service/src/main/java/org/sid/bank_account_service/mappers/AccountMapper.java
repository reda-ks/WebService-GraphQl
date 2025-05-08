package org.sid.bank_account_service.mappers;

import org.sid.bank_account_service.dto.BankAccountResponseDTO;
import org.sid.bank_account_service.entities.BankAcccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
        public BankAccountResponseDTO fromBankAccount(BankAcccount bankAcccount){
            BankAccountResponseDTO bankAccountResponseDTO=new BankAccountResponseDTO();
            BeanUtils.copyProperties(bankAcccount,bankAccountResponseDTO);
            return bankAccountResponseDTO;
        }
}
