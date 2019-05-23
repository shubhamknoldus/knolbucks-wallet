package com.knoldus.knolbucks.service;

import com.knoldus.knolbucks.exception.RecordNotInserted;
import com.knoldus.knolbucks.model.WalletRechargeRequest;
import com.knoldus.knolbucks.repository.WalletRepository;
import reactor.core.publisher.Mono;

import javax.inject.Inject;

public class WalletServiceImpl implements WalletService {

    private WalletRepository walletRepository;

    @Inject
    public WalletServiceImpl(WalletRepository walletRepository) {

        this.walletRepository = walletRepository;
    }

    @Override
    public Mono<WalletRechargeRequest> rechargeWallet(WalletRechargeRequest walletRechargeRequest) {
        return walletRepository.rechargeWallet(walletRechargeRequest).map(value -> {
            if(value > 0) {
                return walletRechargeRequest;
            }
            else {
                throw new RecordNotInserted();
            }
        })
                .onErrorMap(throwable -> new RuntimeException(throwable.getCause()));
    }
}
