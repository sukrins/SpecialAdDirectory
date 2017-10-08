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
@Path("advertisers")
public class AdvertiserResource {

    @Context
    AdvertiserDao advertiserDao;

    //permission to view all the advertisers
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Advertiser> getAdvertisers() {
        return (Collection<Advertiser>) (advertiserDao.getAdvertisers());
    }

    //permission to view a spefic advertiser by id
    @Path("{advertiserID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Advertiser getAdvertiser(@PathParam("advertiserID") String advertiserID) throws AdvertiserNotFoundException {
        return (advertiserDao.getAdvertiser(advertiserID));
    }

}
