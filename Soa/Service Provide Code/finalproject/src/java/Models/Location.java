/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Ashith
 */
public class Location {
     private String LocationID;
    private String LocationName;
    private String LocationCode;
     private String AddressStreet1;
    private String City;
    private String State;
    private String PostalCode;
    private String LocationContactName;
    private String LocationPhone;
     private String LocationFaxNumber;
    private String LocationEmailAddress;

    public String getLocationID() {
        return LocationID;
    }

    public void setLocationID(String LocationID) {
        this.LocationID = LocationID;
    }

    public String getLocationName() {
        return LocationName;
    }

    public void setLocationName(String LocationName) {
        this.LocationName = LocationName;
    }

    public String getLocationCode() {
        return LocationCode;
    }

    public void setLocationCode(String LocationCode) {
        this.LocationCode = LocationCode;
    }

    public String getAddressStreet1() {
        return AddressStreet1;
    }

    public void setAddressStreet1(String AddressStreet1) {
        this.AddressStreet1 = AddressStreet1;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String PostalCode) {
        this.PostalCode = PostalCode;
    }

    public String getLocationContactName() {
        return LocationContactName;
    }

    public void setLocationContactName(String LocationContactName) {
        this.LocationContactName = LocationContactName;
    }

    public String getLocationPhone() {
        return LocationPhone;
    }

    public void setLocationPhone(String LocationPhone) {
        this.LocationPhone = LocationPhone;
    }

    public String getLocationFaxNumber() {
        return LocationFaxNumber;
    }

    public void setLocationFaxNumber(String LocationFaxNumber) {
        this.LocationFaxNumber = LocationFaxNumber;
    }

    public String getLocationEmailAddress() {
        return LocationEmailAddress;
    }

    public void setLocationEmailAddress(String LocationEmailAddress) {
        this.LocationEmailAddress = LocationEmailAddress;
    }
   
   
}
