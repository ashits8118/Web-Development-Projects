package services;

public class NewWebServiceProxy implements services.NewWebService_PortType {
  private String _endpoint = null;
  private services.NewWebService_PortType newWebService_PortType = null;
  
  public NewWebServiceProxy() {
    _initNewWebServiceProxy();
  }
  
  public NewWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initNewWebServiceProxy();
  }
  
  private void _initNewWebServiceProxy() {
    try {
      newWebService_PortType = (new services.NewWebService_ServiceLocator()).getNewWebServicePort();
      if (newWebService_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)newWebService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)newWebService_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (newWebService_PortType != null)
      ((javax.xml.rpc.Stub)newWebService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public services.NewWebService_PortType getNewWebService_PortType() {
    if (newWebService_PortType == null)
      _initNewWebServiceProxy();
    return newWebService_PortType;
  }
  
  public java.lang.String listofLocations() throws java.rmi.RemoteException{
    if (newWebService_PortType == null)
      _initNewWebServiceProxy();
    return newWebService_PortType.listofLocations();
  }
  
  public java.lang.String listofCustomers() throws java.rmi.RemoteException{
    if (newWebService_PortType == null)
      _initNewWebServiceProxy();
    return newWebService_PortType.listofCustomers();
  }
  
  public java.lang.String byEmployee(int name) throws java.rmi.RemoteException{
    if (newWebService_PortType == null)
      _initNewWebServiceProxy();
    return newWebService_PortType.byEmployee(name);
  }
  
  public java.lang.String byLocationID(int name) throws java.rmi.RemoteException{
    if (newWebService_PortType == null)
      _initNewWebServiceProxy();
    return newWebService_PortType.byLocationID(name);
  }
  
  public java.lang.String transcationsByID(int name) throws java.rmi.RemoteException{
    if (newWebService_PortType == null)
      _initNewWebServiceProxy();
    return newWebService_PortType.transcationsByID(name);
  }
  
  public java.lang.String byCustomerId(int name) throws java.rmi.RemoteException{
    if (newWebService_PortType == null)
      _initNewWebServiceProxy();
    return newWebService_PortType.byCustomerId(name);
  }
  
  public java.lang.String listofEmployees() throws java.rmi.RemoteException{
    if (newWebService_PortType == null)
      _initNewWebServiceProxy();
    return newWebService_PortType.listofEmployees();
  }
  
  public java.lang.String listofExpenses() throws java.rmi.RemoteException{
    if (newWebService_PortType == null)
      _initNewWebServiceProxy();
    return newWebService_PortType.listofExpenses();
  }
  
  public java.lang.String pricingByID(int name) throws java.rmi.RemoteException{
    if (newWebService_PortType == null)
      _initNewWebServiceProxy();
    return newWebService_PortType.pricingByID(name);
  }
  
  public java.lang.String trucksByID(int name) throws java.rmi.RemoteException{
    if (newWebService_PortType == null)
      _initNewWebServiceProxy();
    return newWebService_PortType.trucksByID(name);
  }
  
  
}