package cs445.sad;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ListingNotFoundMapper implements ExceptionMapper<ListingNotFoundException> {

    public Response toResponse(ListingNotFoundException ex) {
        return Response.status(404).entity(ex.getMessage()).type("text/plain").build();
    }
}
