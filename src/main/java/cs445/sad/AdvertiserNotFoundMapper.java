package cs445.sad;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class AdvertiserNotFoundMapper implements ExceptionMapper<AdvertiserNotFoundException> {

    public Response toResponse(AdvertiserNotFoundException ex) {
        return Response.status(404).entity(ex.getMessage()).type("text/plain").build();
    }
}
