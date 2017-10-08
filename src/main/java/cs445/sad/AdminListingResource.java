/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs445.sad;

import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author sukrins
 */
@Path("admin/listing")
public class AdminListingResource {

    @Context
    ListingDao listingDao;

    /**
     *
     * @param listing
     * @return
     */
    //Give admin permission to add new listings
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Listing addListing(Listing listing) {
        listingDao.addListing(listing);
        return listing;
    }

    //Give admin permission to view listings
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Listing> getListings() {
        return (Collection<Listing>) (listingDao.getListings());
    }

    //Give admin permission to update listings
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Listing updateListing(Listing listing) {

        return listingDao.updateListing(listing);
    }

    //Give admin permission to view spefic listings by their id
    @Path("{listingID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Listing getListing(@PathParam("listingID") String listingID) throws ListingNotFoundException {
        return (listingDao.getListing(listingID));
    }

    //Give admin permission to delete spefic listings by their id
    @Path("{listingID}")
    @DELETE
    public void deleteListing(@PathParam("listingID") String listingID) throws ListingNotFoundException {
        listingDao.deleteListing(listingID);
    }

}
