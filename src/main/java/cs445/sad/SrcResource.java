/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs445.sad;

import java.util.Collection;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author sukrins
 */
@Path("src/search")
public class SrcResource {

    @Context
    AdvertiserDao dao = new AdvertiserDao();
    Advertiser advertiser = new Advertiser();

    //permission to search advertisers by email
    @GET
    @Path("email")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Advertiser> getAdvertiserByEmail(@QueryParam("email") String email) {

        return (Collection<Advertiser>) (dao.searchByEmail(email));

    }

    //permission to search advertisers by lastName
    @GET
    @Path("lastName")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Advertiser> getAdvertiserByLastName(@QueryParam("lastName") String lastName) {

        return (Collection<Advertiser>) (dao.searchByLastName(lastName));

    }
    
    //permission to search advertisers by business name
    @GET
    @Path("business")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Advertiser> getAdvertiserByBusinessName(@QueryParam("business") String business) {

        return (Collection<Advertiser>) (dao.searchByLastName(business));

    }
    
    //permission to search advertisers by phone number
    @GET
    @Path("phone")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Advertiser> getAdvertiserByPhone(@QueryParam("phone") String phone) {

        return (Collection<Advertiser>) (dao.searchByPhone(phone));

    }
    
    //permission to search advertisers by facebook
    @GET
    @Path("facebook")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Advertiser> getAdvertiserByFacebook(@QueryParam("facebook") String facebook) {

        return (Collection<Advertiser>) (dao.searchByFacebook(facebook));

    }
    
    //permission to search advertisers by twitter
    @GET
    @Path("twitter")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Advertiser> getAdvertiserByTwitter(@QueryParam("twitter") String twitter) {

        return (Collection<Advertiser>) (dao.searchByTwitter(twitter));

    }
    
    //permission to search advertisers by linkedin
    @GET
    @Path("linkedin")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Advertiser> getAdvertiserByLinkedin(@QueryParam("linkedin") String linkedin) {

        return (Collection<Advertiser>) (dao.searchByLinkedin(linkedin));

    }
    
}
