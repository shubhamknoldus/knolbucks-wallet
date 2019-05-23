package com.knoldus.knolbucks.service;

import com.knoldus.knolbucks.model.WalletRechargeRequest;
import reactor.core.publisher.Mono;

public interface WalletService {

    Mono<WalletRechargeRequest> rechargeWallet(WalletRechargeRequest walletRechargeRequest);


}
