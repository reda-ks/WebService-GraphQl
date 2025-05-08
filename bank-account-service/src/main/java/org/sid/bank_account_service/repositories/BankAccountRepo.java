package org.sid.bank_account_service.repositories;

import org.sid.bank_account_service.entities.BankAcccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepo extends JpaRepository<BankAcccount,String> {
}
