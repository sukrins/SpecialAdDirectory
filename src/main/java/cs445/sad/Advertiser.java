package cs445.sad;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Advertiser {

    private String advertiserID;
    
    @NotNull(message = "First Name is required")
    private String firstName;
    
    private String lastName;
    private String businessName;
    
    @NotNull(message = "Address is required")
    private Address address;
    
    @NotNull(message = "Email is required")
    private String email;
    
    @NotNull(message = "Phone is required")
    private String phone;
    
    @NotNull(message = "Facebook is required")
    private String facebook;
    
    @NotNull(message = "Twitter is required")
    private String twitter;
    
    private String linkedin;

    public Advertiser() {
    }

    public Advertiser(String aID, String firstName, String lastName, String businessName, Address address, String email,
            String phone, String facebook, String twitter) {
        this.advertiserID = aID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.businessName = businessName;
        this.address = new Address(address.getStreetAddress(),
                address.getCity(), address.getState(), address.getZipCode());
        this.email = email;
        this.phone = phone;
        this.facebook = facebook;
        this.twitter = twitter;
    }

    public String getAdvertiserID() {
        return advertiserID;
    }

    public void setAdvertiserID(String aID) {
        this.advertiserID = aID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = new Address(address.getStreetAddress(),
                address.getCity(), address.getState(), address.getZipCode());

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

//    @Override
//    public String toString() {
//        return "Advertiser{" + "advertiserID=" + advertiserID + ", firstName=" + firstName + ", lastName=" + lastName + ", businessName=" + businessName + ", address=" + address + ", email=" + email + ", phone=" + phone + ", facebook=" + facebook + ", twitter=" + twitter + ", linkedin=" + linkedin + '}';
//    }
}
