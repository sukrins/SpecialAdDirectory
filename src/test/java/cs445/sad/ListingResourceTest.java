/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs445.sad;

import java.util.Collection;
import java.util.Date;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author sukrins
 */
public class ListingResourceTest {

    @Test
    public void testDelete() throws ListingNotFoundException, CategoryNotFoundException, AdvertiserNotFoundException {
        ListingDao listingDao = new ListingDao();

        listingDao.deleteListing("1");

    }

    @Test
    public void testPut() throws ListingNotFoundException, CategoryNotFoundException, AdvertiserNotFoundException {
        Listing listing = new Listing();

        listing.setListingId("1");
        listing.setBusinessDescription("This is a test description.");
        listing.setImage("test.png");
        listing.setWebsiteLink("www.test.com");
        listing.setPrice("$150");
        listing.setStartDate(new Date(2016, 9, 25));
        //listing.setCategory(new Category("1", "Test"));
        listing.setAdvertiser(new Advertiser());
        listing.setTypeOfListing(TypesOfListing.Regular);

        ListingDao listingDao = new ListingDao();

        listing = listingDao.updateListing(listing);

        assertNotNull(listing);

    }

    @Test
    public void testAdd() throws CategoryNotFoundException, AdvertiserNotFoundException, ListingNotFoundException {

        ListingDao listingDao = new ListingDao();

        Listing listing = new Listing();

        listing.setListingId("2");
        listing.setBusinessDescription("This is another test description.");
        listing.setImage("test2.png");
        listing.setWebsiteLink("www.test2.com");
        listing.setPrice("$150");
        listing.setStartDate(new Date(2016, 9, 25));
        //listing.setCategory(new Category("2", "Test2"));
        listing.setAdvertiser(new Advertiser());
        listing.setTypeOfListing(TypesOfListing.CategoryFeatured);

        listing = listingDao.addListing(listing);

        assertNotNull(listing);

    }

    @Test
    public void testGet() throws CategoryNotFoundException, AdvertiserNotFoundException, ListingNotFoundException {
        ListingDao listingDao = new ListingDao();

        Listing listing = listingDao.getListing("1");

        assertNotNull(listing);
    }

    @Test
    public void testGetAllListings() throws CategoryNotFoundException, AdvertiserNotFoundException, ListingNotFoundException {
        ListingDao listingDao = new ListingDao();

        Collection<Listing> listings = listingDao.getListings();

        assertNotNull(listings);

    }

    @Test(expected = ListingNotFoundException.class)
    public void testNotFoundRequest() throws CategoryNotFoundException, AdvertiserNotFoundException, ListingNotFoundException {

        ListingDao listingDao = new ListingDao();

        listingDao.getListing("");

    }

    @Test
    public void testHomePageListing() throws CategoryNotFoundException, AdvertiserNotFoundException, ListingNotFoundException {

        ListingDao dao = new ListingDao();

        for (Listing listing : dao.listings.values()) {
            if (!dao.homePageListings.contains(listing)) {
                if (listing.getTypeOfListing() == TypesOfListing.HomePageFeatured) {
                    dao.homePageListings.add(listing);
                }
            }

        }

        assertNotNull(dao.homePageListings);
    }

}
