package com.TimeTo.TimeTo.Repositories;

import com.TimeTo.TimeTo.Models.Account;
import com.TimeTo.TimeTo.Models.UserAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
}
