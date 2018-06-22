/**
 * NewWebService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package services;

public class NewWebService_ServiceLocator extends org.apache.axis.client.Service implements services.NewWebService_Service {

    public NewWebService_ServiceLocator() {
    }


    public NewWebService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public NewWebService_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for NewWebServicePort
    private java.lang.String NewWebServicePort_address = "http://localhost:8080/WebApplicationFinal/NewWebService";

    public java.lang.String getNewWebServicePortAddress() {
        return NewWebServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String NewWebServicePortWSDDServiceName = "NewWebServicePort";

    public java.lang.String getNewWebServicePortWSDDServiceName() {
        return NewWebServicePortWSDDServiceName;
    }

    public void setNewWebServicePortWSDDServiceName(java.lang.String name) {
        NewWebServicePortWSDDServiceName = name;
    }

    public services.NewWebService_PortType getNewWebServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(NewWebServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getNewWebServicePort(endpoint);
    }

    public services.NewWebService_PortType getNewWebServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            services.NewWebServicePortBindingStub _stub = new services.NewWebServicePortBindingStub(portAddress, this);
            _stub.setPortName(getNewWebServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setNewWebServicePortEndpointAddress(java.lang.String address) {
        NewWebServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (services.NewWebService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                services.NewWebServicePortBindingStub _stub = new services.NewWebServicePortBindingStub(new java.net.URL(NewWebServicePort_address), this);
                _stub.setPortName(getNewWebServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("NewWebServicePort".equals(inputPortName)) {
            return getNewWebServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://services/", "NewWebService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://services/", "NewWebServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("NewWebServicePort".equals(portName)) {
            setNewWebServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
