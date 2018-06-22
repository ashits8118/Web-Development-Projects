/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Bean.Customer;
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
@WebService(serviceName = "test_v_1")
public class test_v_1 {

    @EJB
    private Customer ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "ByLocationID")
    public List<Location> ByLocationID(@WebParam(name = "txt") String txt) {
        return ejbRef.ByLocationID(txt);
    }
    
}
