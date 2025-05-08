package org.sid.bank_account_service.entities;

import org.sid.bank_account_service.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;
//@projection sert  à specifie les attribut à retourner
//l'appel se fait via: ip:port/endpoint?projection=p1 (nom projection)
@Projection(types = BankAcccount.class,name = "p2")
public interface AccountProjection {
    String getId();
    //Double getBalance();
  //  public AccountType getAccountType();
   // public Double getBalance();
}
