package io.kamenskiyAndrey.processingService.processing.controller;


import io.kamenskiyAndrey.processingService.processing.domainModel.AccountEntity;
import io.kamenskiyAndrey.processingService.processing.dto.NewAccountDTO;
import io.kamenskiyAndrey.processingService.processing.dto.PutMoneyToAccountDTO;
import io.kamenskiyAndrey.processingService.processing.service.AccountCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RequiredArgsConstructor
@RestController
@RequestMapping("/processing")
public class ProcessingAccountController {
    private final AccountCreateService service;

    @PostMapping(path = "/account")
    public AccountEntity createAccount(@RequestBody NewAccountDTO account){
        return service.createNewAccount(account);
    }

    @PutMapping(path = "/account/{id}")
    public AccountEntity putMoney(@PathVariable(value = "id") Long accountId, @RequestBody PutMoneyToAccountDTO dto){
       return service.addMoneyToAccount(dto.getUid(), accountId, dto.getAmountOfMoney());
    }

    @PutMapping(path = "/account/{uid}")
    public BigDecimal exchangeCurrency (@PathVariable(value = "uid") String uid){

    }
}



