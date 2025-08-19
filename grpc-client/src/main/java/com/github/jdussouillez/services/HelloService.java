package com.github.jdussouillez.services;

import com.hififilter.hannibal.api.grpc.HelloGrpcApi;
import io.quarkus.grpc.GrpcClient;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;

@ApplicationScoped
public class HelloService {

    private static final Logger LOG = Logger.getLogger(HelloService.class);

    @GrpcClient
    protected HelloGrpcApi helloGrpcApi;

    @Scheduled(every = "2s")
    protected void increment() {
        //
    }
}
