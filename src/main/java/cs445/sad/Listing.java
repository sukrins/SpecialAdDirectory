/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs445.sad;

import java.util.Date;

/**
 *
 * @author sukrins
 */
public class Listing {

    private String listingId;
    private String businessDescription;
    private String image;
    private String websiteLink;
    private String price;
    private Date startDate;
    private Date endDate;
    private Category category;
    private Advertiser advertiser;
    private TypesOfListing typeOfListing;

    public Listing() {
        // TODO Auto-generated constructor stub
    }

    public Listing(String listingId, String businessDescription, String image,
            String websiteLink, String price, Date startDate, Date endDate,
            Category category, Advertiser advertiser,
            TypesOfListing typeOfListing
    ) {
        super();
        this.listingId = listingId;
        this.businessDescription = businessDescription;
        this.image = image;
        this.websiteLink = websiteLink;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
        this.advertiser = advertiser;
        this.typeOfListing = typeOfListing;
    }

    public String getListingId() {
        return listingId;
    }

    public String getListingId(String listingId) {
        return listingId;
    }

    public void setListingId(String listingId) {
        this.listingId = listingId;
    }

    public String getBusinessDescription() {
        return businessDescription;
    }

    public void setBusinessDescription(String businessDescription) {
        this.businessDescription = businessDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = new Date(startDate.getDay(), startDate.getMonth(),
                startDate.getYear());
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = new Date(endDate.getDay(), endDate.getMonth(),
                endDate.getYear());
    }

    public Category getCategory() {
        return category;
    }

    public Category getCategory(String categoryID) {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Advertiser getAdvertiser() {
        return advertiser;
    }

    public Advertiser getAdvertiser(AdvertiserDao advertiserID) {
        return advertiser;
    }

    public void setAdvertiser(Advertiser advertiser) {
        this.advertiser = advertiser;
    }

    public TypesOfListing getTypeOfListing() {
        return typeOfListing;
    }

    public TypesOfListing getTypeOfListing(TypesOfListing listingType) {
        return typeOfListing;
    }

    public void setTypeOfListing(TypesOfListing typeOfListing) {
        this.typeOfListing = typeOfListing;
    }

   
    
    

}
