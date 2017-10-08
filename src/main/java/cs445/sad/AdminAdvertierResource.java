/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs445.sad;

import java.util.Collection;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
@Path("admin/advertiser")
public class AdminAdvertierResource {

 
    @Context
    AdvertiserDao advertiserDao;

    /**
     *
     * @param advertiser
     * @return
     */
    
    //Give admin permission to add new advertisers
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Advertiser addAdvertiser(@Valid @NotNull Advertiser advertiser) {
        advertiserDao.addAdvertiser(advertiser);
        return advertiser;
    }

    //Give admin permission to view advertisers
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Advertiser> getAdvertisers() {
        return (Collection<Advertiser>) (advertiserDao.getAdvertisers());
    }

    //Give admin permission to update advertisers
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Advertiser updateAdvertiser(Advertiser advertiser) {

        return advertiserDao.updateDavertiser(advertiser);
    }

    //Give admin permission to view spefic advertisers by their id
    @Path("{advertiserID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Advertiser getAdvertiser(@PathParam("advertiserID") String advertiserID) throws AdvertiserNotFoundException {
        return (advertiserDao.getAdvertiser(advertiserID));
    }

    //Give admin permission to delete spefic advertisers by their id
    @Path("{advertiserID}")
    @DELETE
    public void deleteAdvertiser(@PathParam("advertiserID") String advertiserID) throws AdvertiserNotFoundException {
        advertiserDao.deleteAdvertiser(advertiserID);
    }

}
