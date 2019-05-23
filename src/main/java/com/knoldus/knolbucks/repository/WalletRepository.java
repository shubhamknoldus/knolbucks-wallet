package com.knoldus.knolbucks.repository;

import com.knoldus.knolbucks.model.WalletRechargeRequest;
import reactor.core.publisher.Mono;

public interface WalletRepository {

    public Mono<Integer> rechargeWallet(WalletRechargeRequest request);

}
