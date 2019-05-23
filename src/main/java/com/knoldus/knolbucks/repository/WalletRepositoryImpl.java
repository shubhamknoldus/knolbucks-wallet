package com.knoldus.knolbucks.repository;

import com.knoldus.knolbucks.model.WalletRechargeRequest;
import org.davidmoten.rx.jdbc.Database;
import reactor.core.publisher.Mono;

import javax.inject.Inject;

public class WalletRepositoryImpl implements WalletRepository {

    private Database database;

    @Inject
    public WalletRepositoryImpl() {
        database = Database.from("jdbc:mysql://localhost:3306/knolbucks?user=root&password=root", 10);
    }

    @Override
    public Mono<Integer> rechargeWallet(WalletRechargeRequest request) {

        return Mono.fromSupplier(() ->
                database.update("insert into coupon_requests values(?, ?, ?, ?, ?, ?, ?, ?)")
                        .parameters(request.getId(),
                                request.getWalletId(),
                                request.getIssuerId(),
                                request.getRequestedOn(),
                                request.getApprovedOn(),
                                request.getQuantity(),
                                request.getStatus())
                        .counts().blockingSingle()
        );
    }

}
