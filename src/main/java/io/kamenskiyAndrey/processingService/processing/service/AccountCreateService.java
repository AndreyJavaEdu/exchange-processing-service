package io.kamenskiyAndrey.processingService.processing.service;

import io.kamenskiyAndrey.processingService.processing.domainModel.AccountEntity;
import io.kamenskiyAndrey.processingService.processing.dto.NewAccountDTO;
import io.kamenskiyAndrey.processingService.processing.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountCreateService {

    private final AccountRepository repository;

    @Transactional
    public AccountEntity createNewAccount(NewAccountDTO dto){
        //заполняем Entity объект данными из DTO
        var account = new AccountEntity();
        account.setCurrencyCode(dto.getCurrencyCode());
        account.setUserId(dto.getUserId());
        account.setBalance(new BigDecimal(0));

        //Сохраняем объект в базу
        var entityAccountObjectInBase = repository.save(account);
        return entityAccountObjectInBase;
    }
}
