package org.fugerit.java.demo.jwt;

import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.build.JwtClaimsBuilder;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.fugerit.java.emp.sm.service.ServiceMessage;

import java.util.List;

@ApplicationScoped
@Path("/consume")
@Slf4j
public class ConsumerDemoRest {

    @Inject
    JsonWebToken jwt;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/jwt")
    @RolesAllowed({ "User", "Demo" })
    public String jwt( @Context SecurityContext ctx ) {
        return "OK! nickname: " + jwt.getClaim(Claims.nickname.name() ).toString();
    }

    private boolean hasJwt() {
        return jwt.getClaimNames() != null;
    }

}
