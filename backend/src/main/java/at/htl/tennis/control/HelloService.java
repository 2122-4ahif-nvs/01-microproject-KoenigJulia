package at.htl.tennis.control;

import io.grpc.stub.StreamObserver;
import at.htl.tennis.Greeter;
import at.htl.tennis.HelloReply;
import at.htl.tennis.HelloRequest;
import io.quarkus.grpc.GrpcService;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;

@GrpcService
public class HelloService implements Greeter {

    @Override
    public Uni<HelloReply> sayHello(HelloRequest request) {
        return Uni.createFrom().item(() ->
                HelloReply.newBuilder().setMessage("Hello " + request.getName()).build()
        );
    }
}