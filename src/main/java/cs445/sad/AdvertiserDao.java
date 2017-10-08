/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs445.sad;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author sukrins
 */
public class AdvertiserDao {

    Map<String, Advertiser> advertisers = new HashMap<>();

    AdvertiserDao() {
        //add new advertisers here
        advertisers = new ConcurrentHashMap<>();

        //demo data
        Advertiser bulls = new Advertiser();
        bulls.setAdvertiserID("1");
        bulls.setFirstName("Jerry");
        bulls.setLastName("Reinsdorf");
        bulls.setBusinessName("Chicago Bulls");
        bulls.setAddress(new Address("1901 West Madison Street", "Chicago", "IL", 60612));
        bulls.setEmail("bulls@email.com");
        bulls.setPhone("7732282276");
        bulls.setFacebook("facebook.com/chicagobulls");
        bulls.setTwitter("@ChicagoBulls");
        bulls.setLinkedin("@ChicagoBulls");

        Advertiser good = new Advertiser();
        good.setAdvertiserID("2");
        good.setFirstName("Kanye");
        good.setLastName("West");
        good.setBusinessName("G.O.O.D Music Inc.");
        good.setAddress(new Address("1550 Madison Ave.", "New York", "NY", 10022));
        good.setEmail("good@email.com");
        good.setPhone("5702282276");
        good.setFacebook("facebook.com/goodmusic");
        good.setTwitter("@GoodMusic");
        good.setLinkedin("@GoodMusic");


        advertisers.put("1", bulls);
        advertisers.put("2", good);


    }

    //get all the advertisers
    Collection<Advertiser> getAdvertisers() {
        return (advertisers.values());
    }

    //get a specif advertiser by id
    Advertiser getAdvertiser(String advertiserID) throws AdvertiserNotFoundException {

        if (advertisers.containsKey(advertiserID)) {
            return (advertisers.get(advertiserID));
        } else {
            throw new AdvertiserNotFoundException("Advertiser " + advertiserID + " is not found");
        }
    }

    //add an advertiser
    Advertiser addAdvertiser(Advertiser advertiser) {
        advertisers.put(advertiser.getAdvertiserID(), advertiser);
        return (advertiser);
    }

    //update an advertiser
    Advertiser updateDavertiser(Advertiser advertiser) {
        if (advertiser.getAdvertiserID().equals("")) {
            return null;
        }
        advertisers.put(advertiser.getAdvertiserID(), advertiser);
        return advertiser;

    }

    //delete an advertiser
    public void deleteAdvertiser(String advertiserID) {

        advertisers.remove(advertiserID);
    }

    //search all the advertisers by name
    Collection<Advertiser> searchByLastName(String lastName) {
        Map<String, Advertiser> advertiserList = new HashMap<>();
        for (Advertiser advertiser : advertisers.values()) {
            String l = advertiser.getLastName();
            if (l.equals(lastName)) {
                advertiserList.put("1", advertiser);

            }

        }

        return advertiserList.values();
    }

    //search all the advertisers by email
    Collection<Advertiser> searchByEmail(String email) {
        Map<String, Advertiser> advertiserList = new HashMap<>();
        for (Advertiser advertiser : advertisers.values()) {
            String e = advertiser.getEmail();

            if (e.equals(email)) {
                advertiserList.put(advertiser.getAdvertiserID(), advertiser);
            }

        }
        return (advertiserList.values());
    }

    //search all the advertisers by business name
    Collection<Advertiser> searchByBusiness(String business) {
        Map<String, Advertiser> advertiserList = new HashMap<>();
        for (Advertiser advertiser : advertisers.values()) {
            if (advertiser.getBusinessName().equals(business)) {
                advertiserList.put(advertiser.getAdvertiserID(),advertiser);

            }

        }

        return advertiserList.values();
    }

    //search all the advertisers by phone number
    Collection<Advertiser> searchByPhone(String phone) {
        Map<String, Advertiser> advertiserList = new HashMap<>();
        for (Advertiser advertiser : advertisers.values()) {
            if (advertiser.getPhone().equals(phone)) {
                advertiserList.put(advertiser.getAdvertiserID(),advertiser);

            }

        }

        return advertiserList.values();
    }

    //search all the advertisers by facebook
    Collection<Advertiser> searchByFacebook(String facebook) {
        Map<String, Advertiser> advertiserList = new HashMap<>();
        for (Advertiser advertiser : advertisers.values()) {
            if (advertiser.getFacebook().equals(facebook)) {
                advertiserList.put(advertiser.getAdvertiserID(),advertiser);

            }

        }

        return advertiserList.values();
    }

    //search all the advertisers by twitter
    Collection<Advertiser> searchByTwitter(String twitter) {
        Map<String, Advertiser> advertiserList = new HashMap<>();
        for (Advertiser advertiser : advertisers.values()) {
            if (advertiser.getTwitter().equals(twitter)) {
                advertiserList.put(advertiser.getAdvertiserID(),advertiser);

            }

        }

        return advertiserList.values();
    }

    //search all the advertisers by linkedin
    Collection<Advertiser> searchByLinkedin(String linkedin) {
        Map<String, Advertiser> advertiserList = new HashMap<>();
        for (Advertiser advertiser : advertisers.values()) {
            if (advertiser.getLinkedin().equals(linkedin)) {
                advertiserList.put(advertiser.getAdvertiserID(),advertiser);

            }

        }

        return advertiserList.values();
    }
    
   
}
