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
@Path("admin/category")
public class AdminCategoryResource {

    @Context
    CategoryDao categoryDao;

    /**
     *
     * @param category
     * @return
     */
    //Give admin permission to add new categories
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Category addCategory(Category category) {
        categoryDao.addCategory(category);
        return category;
    }

    //Give admin permission to view categories
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Category> getCategories() {
        return (Collection<Category>) (categoryDao.getCategories());
    }

    //Give admin permission to update categories
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Category updateCategory(Category category) {

        return categoryDao.updateCategory(category);
    }

    //Give admin permission to view spefic categories by their id
    @Path("{categoryID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Category getCategory(@PathParam("categoryID") String categoryID) throws CategoryNotFoundException {
        return (categoryDao.getCategory(categoryID));
    }

    //Give admin permission to delete spefic categories by their id
    @Path("{categoryID}")
    @DELETE
    public void deleteCategory(@PathParam("categoryID") String categoryID) throws CategoryNotFoundException {
        categoryDao.deleteCategory(categoryID);
    }

}
