package at.htl.tennis.boundary;

import at.htl.tennis.control.MatchPlanRepository;
import io.quarkus.security.identity.SecurityIdentity;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/matchplan")
public class MatchPlanResource {

    @Inject
    MatchPlanRepository matchPlanRepository;

    @Inject
    SecurityIdentity securityIdentity;

    @GET
    @Path("getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMatchPlans() {
        if(!securityIdentity.hasRole("admin") && !securityIdentity.hasRole("emp")) {
            return Response.status(403).build();
        }
        return Response.ok(matchPlanRepository.getAllMatchPlans()).build();
    }

    @GET
    @RolesAllowed("member")
    @Path("getMatchPlansByMatchId/{matchId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMatchPlansByMatchId(@PathParam("matchId") String matchId){
        return Response.ok(matchPlanRepository.getMatchPlansByMatchId(matchId)).build();
    }
}
