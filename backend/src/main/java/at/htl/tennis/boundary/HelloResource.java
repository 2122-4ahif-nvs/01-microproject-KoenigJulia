package at.htl.tennis.boundary;

import io.quarkus.grpc.GrpcClient;
import io.smallrye.mutiny.Uni;

import at.htl.tennis.Greeter;
import at.htl.tennis.HelloReply;
import at.htl.tennis.HelloRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
@Produces(MediaType.TEXT_PLAIN)
public class HelloResource {
    @GrpcClient
    Greeter hello;

    @GET
    public String hello() {
        return "hello";
    }

    @GET
    @Path("/{name}")
    public Uni<String> hello(@PathParam("name") String name) {
        return hello.sayHello(HelloRequest.newBuilder().setName(name).build())
                .onItem().transform(helloReply -> helloReply.getMessage());
    }

    @GET
    @Path("/mutiny/{name}")
    public Uni<String> helloMutiny(@PathParam("name") String name) {
        return hello.sayHello(HelloRequest.newBuilder().setName(name).build())
                .onItem().transform(HelloReply::getMessage);
    }
}
