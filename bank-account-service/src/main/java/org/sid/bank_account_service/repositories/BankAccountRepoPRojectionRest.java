package org.sid.bank_account_service.repositories;

import org.sid.bank_account_service.entities.BankAcccount;
import org.sid.bank_account_service.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "clients")
public interface BankAccountRepoPRojectionRest extends JpaRepository<BankAcccount,String> {
   @RestResource(path = "/byCurrency")
    List<BankAcccount> findByCurrency(@Param("t") String currency);
    //l'appel se fait via http://localhost:8080/clients/search/byCurrency?t=MAD
}
