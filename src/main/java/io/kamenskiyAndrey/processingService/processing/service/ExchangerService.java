package io.kamenskiyAndrey.processingService.processing.service;

import io.kamenskiyAndrey.processingService.processing.domainModel.AccountEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ExchangerService {

    private static final String CURRENCY_RUB = "RUB";
    private final AccountCreateService service;

    /*
    Метод перевода валюты с одно счета на другой, в зависимости от условий:
    если у счета переводчика сумма не в рублях, а у счета получателя в рублях,
    если у счета переводчика и у счета получателя суммы не в рублях.
     */
    public BigDecimal exchangeCurrency(String uuid, Long fromAccount, Long toAccount, BigDecimal ammount){
        AccountEntity source = service.getAccountById(fromAccount); //получаем объект счета котрый будет отправлять сумму на другой счет
        AccountEntity target = service.getAccountById(toAccount); // объект счета который будет получать деньги с другого счета

        BigDecimal result;
        //Проверка если код валют на обоих счетах в РУБЛЯХ.
        if (CURRENCY_RUB.equals(source.getCurrencyCode()) && CURRENCY_RUB.equals(target.getCurrencyCode())){
            result = moneyTransferFromOneAccToOther(uuid, source, target, ammount);
        } else if (!CURRENCY_RUB.equals(source.getCurrencyCode()) && CURRENCY_RUB.equals(target.getCurrencyCode())) {
            
        } else if (CURRENCY_RUB.equals(source.getCurrencyCode()) && !CURRENCY_RUB.equals(target.getCurrencyCode())) {

        } else if (!CURRENCY_RUB.equals(source.getCurrencyCode()) && !CURRENCY_RUB.equals(target.getCurrencyCode())) {

        }


        return null;
    }





    /*
    Метод перевода валюты с одного счета на другой счет если валюта с кодом RUB
     */
    public BigDecimal moneyTransferFromOneAccToOther(String uuid, AccountEntity source
            , AccountEntity target, BigDecimal amount) {
        service.addMoneyToAccount(uuid, source.getId(), amount.negate());
        service.addMoneyToAccount(uuid, target.getId(), amount);

        return amount;
    }
}
