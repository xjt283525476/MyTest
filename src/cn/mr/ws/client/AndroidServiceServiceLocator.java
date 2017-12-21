/**
 * AndroidServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.mr.ws.client;

public class AndroidServiceServiceLocator extends org.apache.axis.client.Service implements cn.mr.ws.client.AndroidServiceService {

    public AndroidServiceServiceLocator() {
    }


    public AndroidServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AndroidServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AndroidServicePort
    private java.lang.String AndroidServicePort_address = "http://localhost:8080/webgisams/ws/android";

    public java.lang.String getAndroidServicePortAddress() {
        return AndroidServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AndroidServicePortWSDDServiceName = "AndroidServicePort";

    public java.lang.String getAndroidServicePortWSDDServiceName() {
        return AndroidServicePortWSDDServiceName;
    }

    public void setAndroidServicePortWSDDServiceName(java.lang.String name) {
        AndroidServicePortWSDDServiceName = name;
    }

    public cn.mr.ws.client.IAndroidService getAndroidServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AndroidServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAndroidServicePort(endpoint);
    }

    public cn.mr.ws.client.IAndroidService getAndroidServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.mr.ws.client.AndroidServiceServiceSoapBindingStub _stub = new cn.mr.ws.client.AndroidServiceServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getAndroidServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAndroidServicePortEndpointAddress(java.lang.String address) {
        AndroidServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cn.mr.ws.client.IAndroidService.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.mr.ws.client.AndroidServiceServiceSoapBindingStub _stub = new cn.mr.ws.client.AndroidServiceServiceSoapBindingStub(new java.net.URL(AndroidServicePort_address), this);
                _stub.setPortName(getAndroidServicePortWSDDServiceName());
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
        if ("AndroidServicePort".equals(inputPortName)) {
            return getAndroidServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://publish.smc.webservice.mr.android/", "AndroidServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://publish.smc.webservice.mr.android/", "AndroidServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AndroidServicePort".equals(portName)) {
            setAndroidServicePortEndpointAddress(address);
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
