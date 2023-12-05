package io.kamenskiyAndrey.processingService.processing.controller;


import io.kamenskiyAndrey.processingService.processing.domainModel.AccountEntity;
import io.kamenskiyAndrey.processingService.processing.dto.NewAccountDTO;
import io.kamenskiyAndrey.processingService.processing.service.AccountCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/processing")
public class ProcessingAccountController {
    private final AccountCreateService service;

    @PostMapping(path = "/account")
    public AccountEntity createAccount(@RequestBody NewAccountDTO account){
        return service.createNewAccount(account);
    }
}
