package at.htl.tennis.boundary;

import at.htl.tennis.control.MatchPlanRepository;
import io.quarkus.security.identity.SecurityIdentity;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/matchplan")
public class MatchPlanResource {

    @Inject
    MatchPlanRepository matchPlanRepository;

    @Inject
    SecurityIdentity securityIdentity;

    @GET
    @Path("getAll")
    public Response getAllMatchPlans() {
        if(!securityIdentity.hasRole("admin") && !securityIdentity.hasRole("emp")) {
            return Response.status(403).build();
        }
        return Response.ok(matchPlanRepository.getAllMatchPlans()).build();
    }
}
