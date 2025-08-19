package com.github.jdussouillez.services;

import com.hififilter.hannibal.api.grpc.HelloGrpcApi;
import com.hififilter.hannibal.api.grpc.HelloRequest;
import com.hififilter.hannibal.api.grpc.HelloResponse;
import io.quarkus.grpc.GrpcService;
import io.quarkus.runtime.StartupEvent;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.event.Observes;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

@GrpcService
public class HelloGrpcApiService implements HelloGrpcApi {

    private static final Logger LOG = Logger.getLogger(HelloGrpcApiService.class);

    @ConfigProperty(name = "server.id")
    String serverId;

    @Override
    public Uni<HelloResponse> sayHello(final HelloRequest req) {
        return Uni.createFrom()
            .item(() -> String.format("Hello %s! (sent from %s)", req.getName(), serverId))
            .map(msg -> HelloResponse.newBuilder().setMessage(msg).build());
    }

    void onStart(@Observes StartupEvent ev) {
        LOG.infof("Starting gRPC server %s", serverId);
    }
}
