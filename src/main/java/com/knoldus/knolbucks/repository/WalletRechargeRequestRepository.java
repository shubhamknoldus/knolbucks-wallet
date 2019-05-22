package com.knoldus.knolbucks.repository;

import com.knoldus.knolbucks.model.WalletRechargeRequest;
import reactor.core.publisher.Mono;

public interface WalletRechargeRequestRepository {

    Boolean save(WalletRechargeRequest walletRechargeRequest);
}
