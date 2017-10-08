/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs445.sad;

import java.util.Collection;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author sukrins
 */
@Path("")
public class BaseURI {

    @Context
    ListingDao dao;

    //permission to view homepage listings
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Listing> getListings() {
        return (dao.getHomePageListings());
    }

    //permissino to view spefic homepage listings by id
    @Path("{listingId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Listing getHomePageListing(@PathParam("listingId") String listingId) throws ListingNotFoundException {
        return (dao.getListing(listingId));

    }
}
