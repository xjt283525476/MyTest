package cn.mr.ws.client;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public class TestClient {

    /**
     * 2014-10-10 下午8:32:32 xuejiangtao添加此方法
     * @param args
     */
    public static void main(String[] args) {
        try {
            AndroidServiceServiceLocator locator = new AndroidServiceServiceLocator();
            IAndroidService servicePort = locator.getAndroidServicePort();
            servicePort.acceptTask("", 1, 2);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
