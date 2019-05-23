package com.knoldus.knolbucks.repository;

import com.knoldus.knolbucks.model.Wallet;
import reactor.core.publisher.Flux;

public interface WalletRepository {

    Boolean create();

    Boolean save(Wallet wallet);

    Flux<Wallet> findAll();

    Flux<Wallet> findByID(String id);

    Boolean updateByID(String id, String amount);
}
