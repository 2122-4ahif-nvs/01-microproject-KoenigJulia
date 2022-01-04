package at.htl.tennis.boundary;

import at.htl.tennis.control.MemberService;
import at.htl.tennis.entity.Member;
import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.awt.print.Book;
import java.util.Set;
import java.util.stream.Collectors;

@Path("/member")
public class MemberResource {
    @Inject
    Validator validator;

    @Inject
    MemberService memberService;

    @Inject @Location("MemberResource/memberTemplate.html")
    Template memberTemplate;

    @Path("/getMember")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(
            @QueryParam("fn") @DefaultValue("") String firstName,
            @QueryParam("ln") @DefaultValue("") String lastName,
            @QueryParam("m") @DefaultValue("") String mail,
            @QueryParam("pn") @DefaultValue("") String phoneNumber
    ) {
        Member member = new Member(firstName, lastName, mail, phoneNumber);
        return memberTemplate.data("member", memberService.getMemberByMember(member));
    }

    @Path("/service-method-validation")
    @POST
    public Result tryMeServiceMethodValidation(Member member, @Context UriInfo uriInfo) {
        try {
            memberService.validateMember(member);
            return new Result("Book is valid! It was validated by service method validation.");
        } catch (ConstraintViolationException e) {
            return new Result(e.getConstraintViolations());
        }
    }

    @Path("/manual-validation")
    @POST
    public Result manualValidation(Member member, @Context UriInfo uriInfo) {
        Set<ConstraintViolation<Member>> violations = validator.validate(member);
        if (violations.isEmpty()) {
            return new Result("Member is valid! It was validated by manual validation.");
        } else {
            return new Result(violations);
        }
    }

    @Path("/end-point-method-validation")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Result endPointMethodValidation(@Valid Member member, @Context UriInfo uriInfo) {
        return new Result("Book is valid! It was validated by end point method validation.");
    }

    //region Result
    public static class Result {
        Result(String message) {
            this.success = true;
            this.message = message;
        }

        Result(Set<? extends ConstraintViolation<?>> violations) {
            this.success = false;
            this.message = violations.stream()
                    .map(cv -> cv.getMessage())
                    .collect(Collectors.joining(", "));
        }

        private String message;
        private boolean success;

        public String getMessage() {
            return message;
        }

        public boolean isSuccess() {
            return success;
        }
    }
    //endregion
}
