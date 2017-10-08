/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs445.sad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author sukrins
 */
public class AdvertiserResourceTest {

    @Test
    public void testDelete() {

        AdvertiserDao advertiserDao = new AdvertiserDao();

        advertiserDao.deleteAdvertiser("1");

    }

    @Test
    public void testPut() {
        AdvertiserDao advertiserDao = new AdvertiserDao();
        Advertiser advertiser = new Advertiser();

        advertiser.setAdvertiserID("1");
        advertiser.setBusinessName("Test Business");
        advertiser.setEmail("test@email.com");
        advertiser.setAddress(new Address("3333 S. Wabash", "Chicago", "IL", 60606));
        advertiser.setFacebook("www.facebook.com/test");
        advertiser.setFirstName("FirstTest");
        advertiser.setLastName("LastTest");
        advertiser.setLinkedin("www.linkedin.com/test");
        advertiser.setPhone("773-202-test");
        advertiser.setTwitter("@test");

        advertiser = advertiserDao.updateDavertiser(advertiser);

        assertNotNull(advertiser);

    }

    @Test
    public void testAdd() {

        AdvertiserDao advertiserDao = new AdvertiserDao();
        Advertiser advertiser = new Advertiser();

        advertiser.setAdvertiserID("6");
        advertiser.setBusinessName("Test2 Business");
        advertiser.setEmail("test2@email.com");
        advertiser.setAddress(new Address("2222 S. Wabash", "Chicago", "IL", 60606));
        advertiser.setFacebook("www.facebook.com/test2");
        advertiser.setFirstName("FirstTest2");
        advertiser.setLastName("LastTest2");
        advertiser.setLinkedin("www.linkedin.com/test2");
        advertiser.setPhone("773-202-test2");
        advertiser.setTwitter("@test2");

        advertiser = advertiserDao.updateDavertiser(advertiser);

        assertNotNull(advertiser);

    }

    @Test
    public void TestGetAdvertiser() throws AdvertiserNotFoundException {

        AdvertiserDao advertiserDao = new AdvertiserDao();
        Advertiser advertiser = advertiserDao.getAdvertiser("1");
        assertNotNull(advertiser);
    }

    @Test
    public void testGetAllAdvertisers() {
        AdvertiserDao advertiserDao = new AdvertiserDao();
        Collection<Advertiser> advertisers = advertiserDao.getAdvertisers();

        assertNotNull(advertisers);

    }

    @Test(expected = AdvertiserNotFoundException.class)
    public void testNotFoundRequest() throws AdvertiserNotFoundException {
        AdvertiserDao advertiserDao = new AdvertiserDao();

        advertiserDao.getAdvertiser("");
    }

    @Test
    public void getAdvertiserByEmail() {

        AdvertiserDao dao = new AdvertiserDao();
        List<Advertiser> advertisers = new ArrayList<>();

        String searchValue = "good@email.com";

        dao.searchByEmail(searchValue);
        
        for(Advertiser advertiser : dao.advertisers.values()){
        if(advertiser.getEmail().equals(searchValue))
            advertisers.add(advertiser);
        }
        
        assertNotNull(advertisers);

    }
    
     @Test
    public void getAdvertiserByLastName() {

        AdvertiserDao dao = new AdvertiserDao();
        List<Advertiser> advertisers = new ArrayList<>();

        String searchValue = "West";

        dao.searchByLastName(searchValue);
        
        for(Advertiser advertiser : dao.advertisers.values()){
        if(advertiser.getLastName().equals(searchValue))
            advertisers.add(advertiser);
        }
        
        assertNotNull(advertisers);

    }
     @Test
    public void getAdvertiserByBusinessName() {

        AdvertiserDao dao = new AdvertiserDao();
        List<Advertiser> advertisers = new ArrayList<>();

        String searchValue = "G.O.O.D Music Inc.";

        dao.searchByBusiness(searchValue);
        
        for(Advertiser advertiser : dao.advertisers.values()){
        if(advertiser.getBusinessName().equals(searchValue))
            advertisers.add(advertiser);
        }
        
        assertNotNull(advertisers);

    }
     @Test
    public void getAdvertiserByPhone() {

        AdvertiserDao dao = new AdvertiserDao();
        List<Advertiser> advertisers = new ArrayList<>();

        String searchValue = "5702282276";

        dao.searchByPhone(searchValue);
        
        for(Advertiser advertiser : dao.advertisers.values()){
        if(advertiser.getPhone().equals(searchValue))
            advertisers.add(advertiser);
        }
        
        assertNotNull(advertisers);

    }
     @Test
    public void getAdvertiserByFacebook() {

        AdvertiserDao dao = new AdvertiserDao();
        List<Advertiser> advertisers = new ArrayList<>();

        String searchValue = "facebook.com/goodmusic";

        dao.searchByFacebook(searchValue);
        
        for(Advertiser advertiser : dao.advertisers.values()){
        if(advertiser.getFacebook().equals(searchValue))
            advertisers.add(advertiser);
        }
        
        assertNotNull(advertisers);

    }
     @Test
    public void getAdvertiserByTwitter() {

        AdvertiserDao dao = new AdvertiserDao();
        List<Advertiser> advertisers = new ArrayList<>();

        String searchValue = "@GoodMusic";

        dao.searchByTwitter(searchValue);
        
        for(Advertiser advertiser : dao.advertisers.values()){
        if(advertiser.getTwitter().equals(searchValue))
            advertisers.add(advertiser);
        }
        
        assertNotNull(advertisers);

    }
     @Test
    public void getAdvertiserByLinkedin() {

        AdvertiserDao dao = new AdvertiserDao();
        List<Advertiser> advertisers = new ArrayList<>();

        String searchValue = "@GoodMusic";

        dao.searchByLinkedin(searchValue);
        
        for(Advertiser advertiser : dao.advertisers.values()){
        if(advertiser.getLinkedin().equals(searchValue))
            advertisers.add(advertiser);
        }
        
        assertNotNull(advertisers);

    }

}
