package com.knoldus.knolbucks.components;

import com.knoldus.knolbucks.handlers.WalletHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.http.MediaType;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class WalletRouter {

    public RouterFunction<ServerResponse> walletRoutes(WalletHandler walletHandler) {

        return RouterFunctions.route()
                .path("/wallet", builder -> builder
                .POST("/recharge", accept(MediaType.APPLICATION_JSON), walletHandler::rechargeWallet))
                .build();
    }

}
