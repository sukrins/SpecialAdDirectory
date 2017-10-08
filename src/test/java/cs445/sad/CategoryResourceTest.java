/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs445.sad;

import java.util.Collection;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author sukrins
 */
public class CategoryResourceTest {

    @Test
    public void testDelete() throws ListingNotFoundException, CategoryNotFoundException, AdvertiserNotFoundException {
        CategoryDao categoryDao = new CategoryDao();

        categoryDao.deleteCategory("1");

    }

    @Test
    public void testPut() throws ListingNotFoundException, CategoryNotFoundException, AdvertiserNotFoundException {
        CategoryDao categoryDao = new CategoryDao();
        Category category = new Category();

        category.setCategoryID("1");
        category.setCategoryName("Clothing");

        category = categoryDao.updateCategory(category);

        assertNotNull(category);

    }

    @Test
    public void testAdd() throws ListingNotFoundException, CategoryNotFoundException, AdvertiserNotFoundException {

        CategoryDao categoryDao = new CategoryDao();

        Category category = new Category();

        category.setCategoryID("5");
        category.setCategoryName("Technology");

        category = categoryDao.addCategory(category);

        assertNotNull(category);

    }

    @Test
    public void TestGet() throws ListingNotFoundException, CategoryNotFoundException, AdvertiserNotFoundException {

        CategoryDao categoryDao = new CategoryDao();

        Category category = categoryDao.getCategory("1");

        assertNotNull(category);
    }

    @Test
    public void testGetAllCategories() throws ListingNotFoundException, CategoryNotFoundException, AdvertiserNotFoundException {
        CategoryDao categoryDao = new CategoryDao();

        Collection<Category> categories = categoryDao.getCategories();

        assertNotNull(categories);
    }

    @Test(expected = CategoryNotFoundException.class)
    public void testNotFoundRequest() throws ListingNotFoundException, CategoryNotFoundException, AdvertiserNotFoundException {

        CategoryDao categoryDao = new CategoryDao();

        categoryDao.getCategory("");
    }

    @Test
    public void testGetAllCategoryListings() throws CategoryNotFoundException, AdvertiserNotFoundException, ListingNotFoundException {
        ListingDao dao = new ListingDao();
        Category category = new Category();
        
        String searchValue = "1";
        
        for (Listing listing : dao.listings.values()) {
            if (listing.getCategory().getCategoryID().equals(category.key(searchValue))) {
                dao.listingsInCategory.clear();
                dao.listingsInCategory.add(listing);

            }

        }
        
        assertNotNull(dao.listingsInCategory);
    }

}
