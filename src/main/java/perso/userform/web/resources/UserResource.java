package perso.userform.web.resources;


import com.sun.jersey.api.JResponse;
import perso.userform.domain.User;
import perso.userform.repository.UserRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Produces({MediaType.APPLICATION_JSON})
public class UserResource {

    @Inject
    private UserRepository userRepository;

    @GET
    @Path("/Users")
    public JResponse<Iterable<User>> users() {
        Iterable<User> users = userRepository.findAll();
        return JResponse.ok(users).build();
    }

    @GET
    @Path("/user/{id}")
    public Response user(@PathParam("id") Integer id) {
        return Response.ok("user " + id).build();
    }

    @PUT
    @Path("/user")
    public Response createUser(User user) {
        userRepository.createUser(user);
        return Response.ok(user).build();
    }
}
