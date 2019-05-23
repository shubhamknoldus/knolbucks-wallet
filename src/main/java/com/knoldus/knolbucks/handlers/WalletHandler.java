package com.knoldus.knolbucks.handlers;

import com.knoldus.knolbucks.model.WalletRechargeRequest;
import com.knoldus.knolbucks.service.WalletService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

@Component
public class WalletHandler {

    private final WalletService walletService;

    public WalletHandler(WalletService walletService) {

        this.walletService = walletService;

    }

    public Mono<ServerResponse> rechargeWallet(ServerRequest serverRequest) {
        Mono<WalletRechargeRequest> walletRechargeRequest = serverRequest.bodyToMono(WalletRechargeRequest.class);

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(walletRechargeRequest.flatMap(walletService::rechargeWallet), WalletRechargeRequest.class));


    }

}
