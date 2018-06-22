/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Bean.Customer;
import Models.CustomerModel;
import Models.EmployeeModel;
import Models.Location;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Ashith
 */
@WebService(serviceName = "test_v5")
public class test_v5 {

    @EJB
    private Customer ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "ByCustomerId")
    public List<CustomerModel> ByCustomerId(@WebParam(name = "Order_id") String Order_id) {
        return ejbRef.ByCustomerId(Order_id);
    }

    @WebMethod(operationName = "ByEmployee")
    public List<EmployeeModel> ByEmployee(@WebParam(name = "txt") String txt) {
        return ejbRef.ByEmployee(txt);
    }

    @WebMethod(operationName = "ByLocationID")
    public List<Location> ByLocationID(@WebParam(name = "txt") String txt) {
        return ejbRef.ByLocationID(txt);
    }

    @WebMethod(operationName = "ListofCustomers")
    public List ListofCustomers() {
        return ejbRef.ListofCustomers();
    }

    @WebMethod(operationName = "ListOfLocations")
    public List ListOfLocations() {
        return ejbRef.ListOfLocations();
    }

    @WebMethod(operationName = "TrcuksByID")
    public List TrcuksByID(@WebParam(name = "txt") String txt) {
        return ejbRef.TrcuksByID(txt);
    }

    @WebMethod(operationName = "ListofEmployees")
    public List<EmployeeModel> ListofEmployees() {
        return ejbRef.ListofEmployees();
    }
    
}
