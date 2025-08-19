package com.github.jdussouillez.services;

import com.hififilter.hannibal.api.grpc.HelloGrpcApi;
import com.hififilter.hannibal.api.grpc.HelloRequest;
import com.hififilter.hannibal.api.grpc.HelloResponse;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.scheduler.Scheduled;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;

@ApplicationScoped
public class HelloService {

    private static final Logger LOG = Logger.getLogger(HelloService.class);

    @GrpcClient("hello")
    protected HelloGrpcApi helloGrpcApi;

    @Scheduled(every = "2s")
    protected Uni<Void> sayHello() {
        return helloGrpcApi.sayHello(HelloRequest.newBuilder().setName("John").build())
            .map(HelloResponse::getMessage)
            .invoke(LOG::info)
            .replaceWithVoid();
    }
}
