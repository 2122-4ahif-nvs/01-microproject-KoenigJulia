package at.htl.tennis.boundary;

import at.htl.tennis.control.MatchRepository;
import io.quarkus.security.identity.SecurityIdentity;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/match")
public class MatchResource {
    @Inject
    MatchRepository matchRepository;

    @Inject
    SecurityIdentity securityIdentity;

    @GET
    @Path("getAll")
    public Response getAllMatchPlans() {
        if(!securityIdentity.hasRole("admin") && !securityIdentity.hasRole("user")) {
            return Response.status(403).build();
        }
        return Response.ok(matchRepository.getAllMatches()).build();
    }
}
