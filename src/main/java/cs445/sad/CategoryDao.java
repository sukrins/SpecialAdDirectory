/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs445.sad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author sukrins
 */
public class CategoryDao {

    Map<String, Category> categories;
    List<Listing> listingsInCategory = new ArrayList<>();

    CategoryDao() throws ListingNotFoundException, CategoryNotFoundException, AdvertiserNotFoundException {

        //add categories here
        categories = new ConcurrentHashMap<String, Category>();

        //demo data
        Category sports = new Category();
        sports.setCategoryID("1");
        sports.setCategoryName("Sports");

        Category music = new Category();
        music.setCategoryID("2");
        music.setCategoryName("Music");

        Category food = new Category();
        food.setCategoryID("3");
        food.setCategoryName("Food");

        Category tech = new Category();
        tech.setCategoryID("4");
        tech.setCategoryName("Technology");

        categories.put("1", sports);
        categories.put("2", music);
        categories.put("3", food);
        categories.put("4", tech);
    }

    //get all categories
    Collection<Category> getCategories() {
        return (categories.values());
    }

    //get spefic category by id
    Category getCategory(String categoryID) throws CategoryNotFoundException {

        if (categories.containsKey(categoryID)) {
            return (categories.get(categoryID));
        } else {
            throw new CategoryNotFoundException("Category " + categoryID + " is not found");
        }

    }

    //get a listing(s) of a category
    List<Listing> getCategoryListings(String categoryId) throws ListingNotFoundException, CategoryNotFoundException, AdvertiserNotFoundException {
        ListingDao dao = new ListingDao();
        Category category = new Category();
        for (Listing listing : dao.listings.values()) {
            if (listing.getCategory().getCategoryID().equals(category.key(categoryId))) {
                listingsInCategory.clear();
                listingsInCategory.add(listing);

            }

        }
        return listingsInCategory;

    }

    //add category
    Category addCategory(Category category) {
        categories.put(category.getCategoryID(), category);
        return (category);
    }

    //update category
    Category updateCategory(Category category) {
        if (category.getCategoryID().equals("")) {
            return null;
        }
        categories.put(category.getCategoryID(), category);
        return category;

    }

    //delete category
    public void deleteCategory(String categoryID) {

        categories.remove(categoryID);
    }

}
