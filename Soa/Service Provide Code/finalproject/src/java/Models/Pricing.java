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
public class Pricing {
    
       private String priceID;
    private String price;
    private String locationNameTO;
     private String locationNamefrom;

    public String getPriceID() {
        return priceID;
    }

    public void setPriceID(String priceID) {
        this.priceID = priceID;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLocationNameTO() {
        return locationNameTO;
    }

    public void setLocationNameTO(String locationNameTO) {
        this.locationNameTO = locationNameTO;
    }

    public String getLocationNamefrom() {
        return locationNamefrom;
    }

    public void setLocationNamefrom(String locationNamefrom) {
        this.locationNamefrom = locationNamefrom;
    }

   
}
