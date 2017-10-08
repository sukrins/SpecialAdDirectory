/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs445.sad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author sukrins
 */
class ListingDao {

    Map<String, Listing> listings;
    List<Listing> homePageListings = new ArrayList<>();
    List<Listing> listingsInCategory = new ArrayList<>();

    ListingDao() throws CategoryNotFoundException, AdvertiserNotFoundException, ListingNotFoundException {

        //add new listings here
        listings = new ConcurrentHashMap<String, Listing>();

        //demo data
        Listing listing1 = new Listing();
        listing1.setListingId("1");
        listing1.setBusinessDescription("This is a test Business Description");
        listing1.setImage("listing1.png");
        listing1.setWebsiteLink("www.listing1.com");
        listing1.setPrice("$150");
        listing1.setStartDate(new Date(2016, 12, 01));
        listing1.setEndDate(new Date(2017, 12, 01));
        listing1.setCategory(new CategoryDao().getCategory("1"));
        listing1.setAdvertiser(new AdvertiserDao().getAdvertiser("1"));
        listing1.setTypeOfListing(TypesOfListing.Regular);

        Listing listing2 = new Listing();
        listing2.setListingId("2");
        listing2.setBusinessDescription("This is a test Business Description 2");
        listing2.setImage("listing2.png");
        listing2.setWebsiteLink("www.listing2.com");
        listing2.setPrice("$150");
        listing2.setStartDate(new Date(2016, 12, 02));
        listing2.setEndDate(new Date(2017, 12, 02));
        listing2.setCategory(new CategoryDao().getCategory("2"));
        listing2.setAdvertiser(new AdvertiserDao().getAdvertiser("2"));
        listing2.setTypeOfListing(TypesOfListing.Regular);

        Listing listing3 = new Listing();
        listing3.setListingId("3");
        listing3.setBusinessDescription("This is a test Business Description 3");
        listing3.setImage("listing3.png");
        listing3.setWebsiteLink("www.listing3.com");
        listing3.setPrice("$150");
        listing3.setStartDate(new Date(2016, 12, 03));
        listing3.setEndDate(new Date(2017, 12, 03));
        listing3.setCategory(new CategoryDao().getCategory("3"));
        listing3.setAdvertiser(new AdvertiserDao().getAdvertiser("1"));
        listing3.setTypeOfListing(TypesOfListing.Regular);

        Listing listing4 = new Listing();
        listing4.setListingId("4");
        listing4.setBusinessDescription("This is a test Business Description 4");
        listing4.setImage("listing4.png");
        listing4.setWebsiteLink("www.listing4.com");
        listing4.setPrice("$150");
        listing4.setStartDate(new Date(2016, 12, 04));
        listing4.setEndDate(new Date(2017, 12, 04));
        listing4.setCategory(new CategoryDao().getCategory("4"));
        listing4.setAdvertiser(new AdvertiserDao().getAdvertiser("2"));
        listing4.setTypeOfListing(TypesOfListing.Regular);

        Listing listing5 = new Listing();
        listing5.setListingId("5");
        listing5.setBusinessDescription("This is a test Business Description 5");
        listing5.setImage("listing5.png");
        listing5.setWebsiteLink("www.listing5.com");
        listing5.setPrice("$150");
        listing5.setStartDate(new Date(2016, 12, 04));
        listing5.setEndDate(new Date(2017, 12, 04));
        listing5.setCategory(new CategoryDao().getCategory("4"));
        listing5.setAdvertiser(new AdvertiserDao().getAdvertiser("1"));
        listing5.setTypeOfListing(TypesOfListing.Regular);

        Listing listing6 = new Listing();
        listing6.setListingId("6");
        listing6.setBusinessDescription("This is a test Business Description 6");
        listing6.setImage("listing6.png");
        listing6.setWebsiteLink("www.listing6.com");
        listing6.setPrice("$150");
        listing6.setStartDate(new Date(2016, 12, 05));
        listing6.setEndDate(new Date(2017, 12, 05));
        listing6.setCategory(new CategoryDao().getCategory("1"));
        listing6.setAdvertiser(new AdvertiserDao().getAdvertiser("2"));
        listing6.setTypeOfListing(TypesOfListing.HomePageFeatured);

        listings.put("1", listing1);
        listings.put("2", listing2);
        listings.put("3", listing3);
        listings.put("4", listing4);
        listings.put("5", listing5);
        listings.put("6", listing6);

    }

    //get all listings
    Collection<Listing> getListings() {
        return (listings.values());
    }

    //get spefic listing by id
    Listing getListing(String listingId) throws ListingNotFoundException {
        if (listings.containsKey(listingId)) {
            return (listings.get(listingId));
        } else {
            throw new ListingNotFoundException("Listing " + listingId + " is not found");
        }

    }

    //get homepage listings
    List<Listing> getHomePageListings() {

        for (Listing listing : listings.values()) {
            if(!homePageListings.contains(listing))
            if (listing.getTypeOfListing() == TypesOfListing.HomePageFeatured) {
                homePageListings.add(listing);
            }

        }

        return homePageListings;
    }

    //add listings
    Listing addListing(Listing listing) {
        listings.put(listing.getListingId(), listing);
        return (listing);
    }

    //update listings
    Listing updateListing(Listing listing) {
        if (listing.getListingId().equals("")) {
            return null;
        }
        listings.put(listing.getListingId(), listing);
        return listing;

    }

    //delete listings
    public void deleteListing(String listingId) {

        listings.remove(listingId);
    }

}
