/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * 
 * @author Ashith
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {

    @WebMethod(operationName = "ByCustomerId")
    public String ByCustomers(@WebParam(name = "name") int txt) {
        ArrayList Cust  = new ArrayList();
       
   try {
          System.out.println(1);
	Class.forName("com.mysql.jdbc.Driver");
//	System.out.println(1);
	String username="root";
	String password="Wadie6669#";
	Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/soafinalproject?useSSL=false",username,password);  
//	System.out.println(1);
        Statement st = con.createStatement();
       
        System.out.println(1);
    
        ResultSet rs = st.executeQuery("select * from Customer where customerID= '"+txt+"'");
        while(rs.next())
        { 
            String a1= rs.getString("AlternateContactName");
         String a2= rs.getString("City");
	String a3= rs.getString("State");
            System.out.println("Customer List" + a1+ a2);
            Cust.add(a1);
            Cust.add(a2); 
            Cust.add(a3);
             
        }
        System.out.println("test.Test.main()"+ Cust.toString());
         
                
               
   

                    st.close();
                    con.close();
            } catch (Exception e) {
	        	e.printStackTrace();
                    }
                
        return Cust.toString();
    }
    
     @WebMethod(operationName = "ByLocationID")
    public String ByLocationID(@WebParam(name = "name") int txt) {
        ArrayList Loc  = new ArrayList();
       
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
        ResultSet rs = st.executeQuery("select * from Locations where LocationID= '"+txt+"'");
        while(rs.next())
        { 
            String a1= rs.getString("LocationName");
         String a2= rs.getString("LocationCode");
	String a3= rs.getString("AddressStreet1");
        String a4= rs.getString("City");
        String a5= rs.getString("State");
     int a6= rs.getInt("PostalCode");
      int a7= rs.getInt("LocationFaxNumber");
        
//            System.out.println("Customer List" + a1+ a2);
            Loc.add(a1);
            Loc.add(a2); 
            Loc.add(a3);
             Loc.add(a4);
              Loc.add(a5);
          Loc.add(a6);
                Loc.add(a7);
             
        }
        System.out.println("test.Test.main()"+ Loc.toString());
         
                
               
   

                    st.close();
                    con.close();
            } catch (Exception e) {
	        	e.printStackTrace();
                    }
                
        return Loc.toString();
    }
    
     @WebMethod(operationName = "ByEmployee")
    public String ByEmployee(@WebParam(name = "name") int txt) {
        ArrayList Emp  = new ArrayList();
       
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
      while(rs.next())
      { 
        String a1= rs.getString("FirstName");
//`       String a2= rs.getString("LastName");
String a3= rs.getString("JobTitle");
      String a4= rs.getString("Address");
      String a5= rs.getString("State");
   int a6= rs.getInt("PostalCode");
    int a7= rs.getInt("Cellphone");
    //int a7= rs.getInt("LocationFaxNumber");
//     System.out.println("details ------> " +a1 +" "+ a2 +" "+a3+" "+a4 +" "+ a5+ " "+ a6+" "+ a7  );
      //int a7= rs.getInt("LocationFaxNumber");
        
//            System.out.println("Customer List" + a1+ a2);
          Emp.add(a1);
  //          Emp.add(a2); 
            Emp.add(a3);
             Emp.add(a4);
              Emp.add(a5);
          Emp.add(a6);
                Emp.add(a7);
             
        }
        System.out.println("test.Test.main()"+ Emp.toString());
         
                
               
   

                    st.close();
                    con.close();
            } catch (Exception e) {
	        	e.printStackTrace();
                    }
                
        return Emp.toString();
    }

       @WebMethod(operationName = "TrucksByID")
    public String Trucks(@WebParam(name = "name") int txt) {
        ArrayList Emp  = new ArrayList();
       
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
      while(rs.next())
      { 
        int a1= rs.getInt("TruckID");
       int a2= rs.getInt("Model");
         int a3= rs.getInt("Cost");
      String a4= rs.getString("Color");
    
    //int a7= rs.getInt("LocationFaxNumber");
     System.out.println("details ------> " +a1 +" "+ a2 +" "+a3+" "+a4 +" ");
      //int a7= rs.getInt("LocationFaxNumber");
        
//            System.out.println("Customer List" + a1+ a2);
          Emp.add(a1);
            Emp.add(a2); 
            Emp.add(a3);
             Emp.add(a4);
        
             
        }
        System.out.println("test.Test.main()"+ Emp.toString());
         
                
               
   

                    st.close();
                    con.close();
            } catch (Exception e) {
	        	e.printStackTrace();
                    }
                
        return Emp.toString();
    }
  
    
    
    
       @WebMethod(operationName = "TranscationsByID")
    public String Transaction(@WebParam(name = "name") int txt) {
        ArrayList tran  = new ArrayList();
       
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
       ResultSet rs = st.executeQuery("select * from Transactions where TransactionID= '"+txt+"'");
	  //ResultSet rs = st.executeQuery("select * from Payments where PaymentID= '"+x+"'"); 
	  while(rs.next())
        { 
		 double a1= rs.getDouble("TransactionAmount");
	       int a2= rs.getInt("Quantity");
	       double  a3= rs.getDouble("UnitPrice");
	      String a4= rs.getString("TransactionDescription");
            System.out.println("Customer List" + a1 + a2 + a4 );
            
        
    
    //int a7= rs.getInt("LocationFaxNumber");
     System.out.println("details ------> " +a1 +" "+ a2 +" "+a3+" "+a4 +" ");
      //int a7= rs.getInt("LocationFaxNumber");
        
//            System.out.println("Customer List" + a1+ a2);
          tran.add(a1);
            tran.add(a2); 
            tran.add(a3);
             tran.add(a4);
        
             
        }
        System.out.println("test.Test.main()"+ tran.toString());
         
                
               
   

                    st.close();
                    con.close();
            } catch (Exception e) {
	        	e.printStackTrace();
                    }
                
        return tran.toString();
    }
 @WebMethod(operationName = "PricingByID")
    public String Pricing(@WebParam(name = "name") int txt) {
        ArrayList price  = new ArrayList();
       
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
       ResultSet rs = st.executeQuery("select * from Pricing where priceID= '"+txt+"'");
	  //ResultSet rs = st.executeQuery("select * from Payments where PaymentID= '"+x+"'"); 
	  while(rs.next())
        {  int a1= rs.getInt("priceID");
		 int a2= rs.getInt("price");
	      String  a3= rs.getString("locationNameTo");
	      String a4= rs.getString("locationNamefrom");
            System.out.println("Customer List" + a1 + a2 + a4 );
            
        
    
    //int a7= rs.getInt("LocationFaxNumber");
     System.out.println("details ------> " +a1 +" "+ a2 +" "+a3+" "+a4 +" ");
      //int a7= rs.getInt("LocationFaxNumber");
        
//            System.out.println("Customer List" + a1+ a2);
          price.add(a1);
            price.add(a2); 
            price.add(a3);
             price.add(a4);
        
             
        }
        System.out.println("test.Test.main()"+ price.toString());
         
                
               
   

                    st.close();
                    con.close();
            } catch (Exception e) {
	        	e.printStackTrace();
                    }
                
        return price.toString();
    }
 @WebMethod(operationName = "ListofCustomers")
    public  String lists() {
        //TODO write your implementation code here:
     ArrayList Cust  = new ArrayList();
//        ArrayList<Truck> Trucks = new ArrayList();
        try {
             //   Class.forName("oracle.jdbc.OracleDriver");
             Class.forName("com.mysql.jdbc.Driver");  
             
	String username="root";
	String password="Wadie6669#";
	Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/soafinalproject?useSSL=false",username,password);  
	//System.out.println(1);
        Statement st = con.createStatement();
       	//String sql ="Select * from Customer";
                ResultSet rs = st.executeQuery("Select * from Customer");
                while(rs.next()){
                String a1= rs.getString("AlternateContactName");
                String a2= rs.getString("City");
		int a3= rs.getInt("PhoneNumber");
                
                Cust.add(a1);
                Cust.add(a2); 
                Cust.add(a3);
                }
                System.out.println("test.Test.main()"+ Cust.toString());
//                Trucks.add()

                    st.close();
                    con.close();
            } catch (Exception e) {
			e.printStackTrace();
                    }
                
        return Cust.toString();
    
    }
    @WebMethod(operationName = "ListofLocations")
    public String list() {
        //TODO write your implementation code here:
     ArrayList Locn  = new ArrayList();
//        ArrayList<Truck> Trucks = new ArrayList();
        try {
             //   Class.forName("oracle.jdbc.OracleDriver");
             Class.forName("com.mysql.jdbc.Driver");  
             
	String username="root";
	String password="Wadie6669#";
	Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/soafinalproject?useSSL=false",username,password);  
	//System.out.println(1);
        Statement st = con.createStatement();
       	//String sql ="Select * from Customer";
                ResultSet rs = st.executeQuery("Select * from Locations");
                while(rs.next()){
                String a1= rs.getString("LocationName");
                String a2= rs.getString("AddressStreet1");
		String a3= rs.getString("City");
                String a4= rs.getString("State");
                
                //System.out.println("ITMD566.NewWebService_ITMD566.truckList" + a1+ a2+ a3);
                Locn.add(a1);
                Locn.add(a2); 
                Locn.add(a3);
                }
                System.out.println("test.Test.main()"+ Locn.toString());
//                Trucks.add()

                    st.close();
                    con.close();
            } catch (Exception e) {
			e.printStackTrace();
                    }
                
        return Locn.toString();
    
    }
     @WebMethod(operationName = "ListofEmployees")
    public String Employeelist() {
        //TODO write your implementation code here:
     ArrayList Emp  = new ArrayList();
//        ArrayList<Truck> Trucks = new ArrayList();
        try {
             //   Class.forName("oracle.jdbc.OracleDriver");
             Class.forName("com.mysql.jdbc.Driver");  
             
	String username="root";
	String password="Wadie6669#";
	Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/soafinalproject?useSSL=false",username,password);  
	//System.out.println(1);
        Statement st = con.createStatement();
       	//String sql ="Select * from Customer";
                ResultSet rs = st.executeQuery("Select * from Employee");
                while(rs.next()){
                String a1= rs.getString("FirstName");
                String a2= rs.getString("LastName");
		String a3= rs.getString("Email");
                int a4= rs.getInt("CellPhone");
                
                //System.out.println("ITMD566.NewWebService_ITMD566.truckList" + a1+ a2+ a3);
                Emp.add(a1);
                Emp.add(a2); 
                Emp.add(a3);
                }
                System.out.println("test.Test.main()"+ Emp.toString());         
                
//                Trucks.add()

                    st.close();
                    con.close();
            } catch (Exception e) {
			e.printStackTrace();
                    }
                
        return Emp.toString();
    
    }
    
     @WebMethod(operationName = "ListofExpenses")
    public String Expenses() {
        //TODO write your implementation code here:
     ArrayList Exp  = new ArrayList();
//        ArrayList<Truck> Trucks = new ArrayList();
        try {
             //   Class.forName("oracle.jdbc.OracleDriver");
             Class.forName("com.mysql.jdbc.Driver");  
             
	String username="root";
	String password="Wadie6669#";
	Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/soafinalproject?useSSL=false",username,password);  
	//System.out.println(1);
        Statement st = con.createStatement();
       	//String sql ="Select * from Customer";
                ResultSet rs = st.executeQuery("Select * from Expenses");
                while(rs.next()){
                int a1= rs.getInt("ExpenseID");
                 String a2= rs.getString("ExpenseType");
		String a3= rs.getString("PurposeofExpense");
                String a4= rs.getString("Description");
                
                //System.out.println("ITMD566.NewWebService_ITMD566.truckList" + a1+ a2+ a3);
                Exp.add(a1);
                Exp.add(a2); 
                Exp.add(a3);
                }
                System.out.println("test.Test.main()"+ Exp.toString());
//                Trucks.add()

                    st.close();
                    con.close();
            } catch (Exception e) {
			e.printStackTrace();
                    }
                
        return Exp.toString();
    
    }
}







