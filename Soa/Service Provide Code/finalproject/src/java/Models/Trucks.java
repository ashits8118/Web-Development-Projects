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
public class Trucks {

    public String getTruckID() {
        return TruckID;
    }

    public void setTruckID(String TruckID) {
        this.TruckID = TruckID;
    }

    public String getTruckNumber() {
        return TruckNumber;
    }

    public void setTruckNumber(String TruckNumber) {
        this.TruckNumber = TruckNumber;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String Year) {
        this.Year = Year;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getLicensePlateNumber() {
        return LicensePlateNumber;
    }

    public void setLicensePlateNumber(String LicensePlateNumber) {
        this.LicensePlateNumber = LicensePlateNumber;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String Cost) {
        this.Cost = Cost;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }
       private String TruckID;
    private String TruckNumber;
    private String Year;
     private String Model;
    private String LicensePlateNumber;
    private String Color;
    private String Cost;
    private String VIN;
 
    
}
