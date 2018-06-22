/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.ResultSet;
import java.util.ArrayList;


import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.ejb.Stateless;
import Models.Trucks;
import Models.CustomerModel;
import Models.Pricing;
import Models.Location;
//import Models.Transactions;
import Models.EmployeeModel;
import javax.ejb.Stateless;

/**
 *
 * @author Ashith
 */
@Stateless
public class Customer {
    public List<CustomerModel> ByCustomerId(String Order_id ) {
    	CustomerModel em=null;
		List<CustomerModel> llist=new ArrayList<>();
		try {
		    System.out.println(1);
	Class.forName("com.mysql.jdbc.Driver");
	//System.out.println(1);
	String username="root";
	String password="Wadie6669#";
	Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/soafinalproject?useSSL=false",username,password);  
	//System.out.println(1);
        Statement st = con.createStatement();
       
        //System.out.println(1);
        ResultSet sr = st.executeQuery("select * from Customer where customerID='"+Order_id+"'");
			while(sr.next()){
			
                        em=new CustomerModel();	
	
                      em.setAlternateContactName(sr.getString("AlternateContactName"));
                        em.setCity(sr.getString("City"));
                        em.setState(sr.getString("State"));
                      
                      
                  //      em.setContactName(sr.getString("ContactName"));
                  
			llist.add(em);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return llist;
   
    }





 public List<EmployeeModel> ByEmployee(String txt ) {
    	EmployeeModel m=null;
		List list=new ArrayList<>();
		try {
		    System.out.println(1);
	Class.forName("com.mysql.jdbc.Driver");
	//System.out.println(1);
	String username="root";
	String password="Wadie6669#";
	Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/soafinalproject?useSSL=false",username,password);  
	//System.out.println(1);
        Statement st = con.createStatement();
       
        //System.out.println(1);
 ResultSet rs = st.executeQuery("select * from Employee where EmployeeID= '"+txt+"'");
			while(rs.next()){
			
                        m=new EmployeeModel();	
	
                      m.setFirstName(rs.getString("FirstName"));
                        m.setLastName(rs.getString("LastName"));
                        m.setJobTitle(rs.getString("JobTitle"));
                          m.setAddress(rs.getString("Address"));
                            m.setState(rs.getString("State"));
                              m.setPostalCode(rs.getString("PostalCode"));
                              m.setPostalCode(rs.getString("Cellphone"));
                      
                      
                  //      em.setContactName(sr.getString("ContactName"));
                  
			list.add(m);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
   
    }






        
   
 public List<Location> ByLocationID(String txt ) {
    	Location m=null;
		List<Location> list=new ArrayList<>();
		try {
		    System.out.println(1);
	Class.forName("com.mysql.jdbc.Driver");
	//System.out.println(1);
	String username="root";
	String password="Wadie6669#";
	Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/soafinalproject",username,password);  
	//System.out.println(1);
        Statement st = con.createStatement();
       
        //System.out.println(1);
        ResultSet rs = st.executeQuery("select * from Locations where LocationID= '"+txt+"'");
			while(rs.next()){
			
                        m=new Location();	
	
                      m.setLocationName(rs.getString("LocationName"));
                        m.setLocationCode(rs.getString("LocationCode"));
                        m.setAddressStreet1(rs.getString("AddressStreet1"));
                          m.setCity(rs.getString("City"));
                            m.setState(rs.getString("State"));
                              m.setPostalCode(rs.getString("PostalCode"));
                              m.setPostalCode(rs.getString("LocationFaxNumber"));
                      
                      
                  //      em.setContactName(sr.getString("ContactName"));
                  
			list.add(m);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
   
    }

     
     
      public List ListofCustomers() {
    	CustomerModel em=null;
		List<CustomerModel> llist=new ArrayList<>();
		try {
		    System.out.println(1);
	Class.forName("com.mysql.jdbc.Driver");
	//System.out.println(1);
	String username="root";
	String password="Wadie6669#";
	Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/soafinalproject?useSSL=false",username,password);  
	//System.out.println(1);
        Statement st = con.createStatement();
       
        //System.out.println(1);
        ResultSet sr = st.executeQuery("select * from Customer");
			while(sr.next()){
			
                        em=new CustomerModel();	
	
                      em.setAlternateContactName(sr.getString("AlternateContactName"));
                        em.setCity(sr.getString("City"));
                        em.setPhoneNumber(sr.getString("PhoneNumber"));
                      
                      
                  //      em.setContactName(sr.getString("ContactName"));
                  
			llist.add(em);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return llist;
   
    }
    
    
    public List ListOfLocations() {
    	Location m=null;
		List<Location> list=new ArrayList<>();
		try {
		    System.out.println(1);
	Class.forName("com.mysql.jdbc.Driver");
	//System.out.println(1);
	String username="root";
	String password="Wadie6669#";
	Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/soafinalproject",username,password);  
	//System.out.println(1);
        Statement st = con.createStatement();
       
        //System.out.println(1);
        ResultSet rs = st.executeQuery("select * from Locations ");
			while(rs.next()){
			
                        m=new Location();	
	
                      m.setLocationName(rs.getString("LocationName"));
                 //       m.setLocationCode(rs.getString("LocationCode"));
                        m.setAddressStreet1(rs.getString("AddressStreet1"));
                          m.setCity(rs.getString("City"));
                            m.setState(rs.getString("State"));
                              m.setPostalCode(rs.getString("PostalCode"));
                              //m.setPostalCode(rs.getString("LocationFaxNumber"));
                      
                      
                  //      em.setContactName(sr.getString("ContactName"));
                  
			list.add(m);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
   
    }
 public List TrcuksByID(String txt ) {
    	//Trucks em=null;
		List llist=new ArrayList<>();
		try {
		    System.out.println(1);
	Class.forName("com.mysql.jdbc.Driver");
	//System.out.println(1);
	String username="root";
	String password="Wadie6669#";
	Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/soafinalproject?useSSL=false",username,password);  
	//System.out.println(1);
        Statement st = con.createStatement();
       
        //System.out.println(1);
         ResultSet rs = st.executeQuery("select * from Trucks where TruckID= '"+txt+"'");
			while(rs.next()){
			
                     Trucks em=new Trucks();	
	
                      em.setTruckID(rs.getString("TruckID"));
                        em.setModel(rs.getString("Model"));
                        em.setCost(rs.getString("Cost"));
                        em.setColor(rs.getString("Color"));
                      
                      
                  //      em.setContactName(sr.getString("ContactName"));
                  
			llist.add(em);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return llist;
   
    }

     public List<EmployeeModel> ListofEmployees( ) {
    	//EmployeeModel m=null;
		List list=new ArrayList<>();
		try {
		    System.out.println(1);
	Class.forName("com.mysql.jdbc.Driver");
	//System.out.println(1);
	String username="root";
	String password="Wadie6669#";
	Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/soafinalproject?useSSL=false",username,password);  
	//System.out.println(1);
        Statement st = con.createStatement();
       
        //System.out.println(1);
 ResultSet rs = st.executeQuery("select * from Employee");
			while(rs.next()){
			
                    EmployeeModel m=new EmployeeModel();	
	
                      m.setFirstName(rs.getString("FirstName"));
                        m.setLastName(rs.getString("LastName"));
                       // m.setJobTitle(rs.getString("JobTitle"));
                         // m.setAddress(rs.getString("Address"));
                          //  m.setState(rs.getString("State"));
                              m.setEmail(rs.getString("Email"));
                              m.setPostalCode(rs.getString("Cellphone"));
                      
                      
                  //      em.setContactName(sr.getString("ContactName"));
                  
			list.add(m);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
   
    }
    
     public List PricingByID(String txt ) {
    	
		List<Location> list=new ArrayList<>();
		try {
		    System.out.println(1);
	Class.forName("com.mysql.jdbc.Driver");
	//System.out.println(1);
	String username="root";
	String password="Wadie6669#";
	Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/soafinalproject",username,password);  
	//System.out.println(1);
        Statement st = con.createStatement();
       
        //System.out.println(1);
        ResultSet rs = st.executeQuery("select * from Locations where LocationID= '"+txt+"'");
			while(rs.next()){
			
                     Pricing m=new Pricing();	
	
                      m.setPriceID(rs.getString("priceID"));
                        m.setPrice(rs.getString("price"));
                        m.setLocationNameTO(rs.getString("locationNameTo"));
                          m.setLocationNamefrom(rs.getString("locationNamefrom"));
                          
                      
                      
                  //      em.setContactName(sr.getString("ContactName"));
                  
			//list.add(m);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
   
    }

public List TransactionsByID(String txt ) {
    	
		List<Location> list=new ArrayList<>();
		try {
		    System.out.println(1);
	Class.forName("com.mysql.jdbc.Driver");
	//System.out.println(1);
	String username="root";
	String password="Wadie6669#";
	Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/soafinalproject",username,password);  
	//System.out.println(1);
        Statement st = con.createStatement();
       
        //System.out.println(1);
        ResultSet rs = st.executeQuery("select * from Locations where LocationID= '"+txt+"'");
			while(rs.next()){
			
                     Pricing m=new Pricing();	
	
                      m.setPriceID(rs.getString("priceID"));
                        m.setPrice(rs.getString("price"));
                        m.setLocationNameTO(rs.getString("locationNameTo"));
                          m.setLocationNamefrom(rs.getString("locationNamefrom"));
                          
                      
                      
                  //      em.setContactName(sr.getString("ContactName"));
                  
			//list.add(m);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
   
    }
     
}
    
    


