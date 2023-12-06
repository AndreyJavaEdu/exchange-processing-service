package io.kamenskiyAndrey.processingService.processing.service;

import io.kamenskiyAndrey.processingService.processing.domainModel.AccountEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ExchangerService {

    private final AccountCreateService service;







    /*
    Метод перевода валюты с одного счета на другой счет
     */
    public BigDecimal moneyTransferFromOneAccToOther(String uuid, AccountEntity source
            , AccountEntity target, BigDecimal amount) {
        service.addMoneyToAccount(uuid, source.getId(), amount.negate());
        service.addMoneyToAccount(uuid, target.getId(), amount);

        return amount;
    }
}
