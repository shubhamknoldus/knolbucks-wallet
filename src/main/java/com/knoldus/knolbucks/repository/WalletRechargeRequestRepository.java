package com.knoldus.knolbucks.repository;

import com.knoldus.knolbucks.model.WalletRechargeRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WalletRechargeRequestRepository {

    Boolean save(WalletRechargeRequest walletRechargeRequest);

    Flux<WalletRechargeRequest> findByID(String id);

    Flux<WalletRechargeRequest> findAll();

    Boolean updateQuantityByID(String id, String quantity);
}
