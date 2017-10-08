/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs445.sad;

import java.util.Collection;
import java.util.List;
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
@Path("categories")
public class CategoryResource {

    @Context
    CategoryDao dao;
    
    //permission to view all categories
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Category> getCategorys() {
        return (dao.getCategories());
    }
          
    //permission to view a spefic category by id
    @Path("{categoryID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Listing> getCategoryinListing(@PathParam("categoryID") String categoryID) throws CategoryNotFoundException, ListingNotFoundException, AdvertiserNotFoundException {
        return (dao.getCategoryListings(categoryID));
    }


}
