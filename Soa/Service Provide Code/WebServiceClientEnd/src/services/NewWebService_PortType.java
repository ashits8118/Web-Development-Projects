/**
 * NewWebService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package services;

public interface NewWebService_PortType extends java.rmi.Remote {
    public java.lang.String listofLocations() throws java.rmi.RemoteException;
    public java.lang.String listofCustomers() throws java.rmi.RemoteException;
    public java.lang.String byEmployee(int name) throws java.rmi.RemoteException;
    public java.lang.String byLocationID(int name) throws java.rmi.RemoteException;
    public java.lang.String transcationsByID(int name) throws java.rmi.RemoteException;
    public java.lang.String byCustomerId(int name) throws java.rmi.RemoteException;
    public java.lang.String listofEmployees() throws java.rmi.RemoteException;
    public java.lang.String listofExpenses() throws java.rmi.RemoteException;
    public java.lang.String pricingByID(int name) throws java.rmi.RemoteException;
    public java.lang.String trucksByID(int name) throws java.rmi.RemoteException;
}
