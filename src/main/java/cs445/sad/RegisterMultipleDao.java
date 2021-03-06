/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs445.sad;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author sukrins
 */
public class RegisterMultipleDao extends ResourceConfig{
    
   public RegisterMultipleDao() throws CategoryNotFoundException, ListingNotFoundException, AdvertiserNotFoundException{
   final AdvertiserDao advertiserDao = new AdvertiserDao();
   final CategoryDao categoryDao = new CategoryDao();
   final ListingDao listingDao = new ListingDao();
   
   packages("cs445.sad");
   register(new AbstractBinder(){
   @Override
   protected void configure(){
   bind(advertiserDao).to(AdvertiserDao.class);
   }
   });
     register(new AbstractBinder(){
   @Override
   protected void configure(){
   bind(categoryDao).to(CategoryDao.class);
   }
   });
     register(new AbstractBinder(){
   @Override
   protected void configure(){
   bind(listingDao).to(ListingDao.class);
   }
   });
   }
    
}
