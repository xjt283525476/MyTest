package cn.mr.ws.client1;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public class TestClient {

    /**
     * 2014-10-10 下午8:32:32 xuejiangtao添加此方法
     * @param args
     */
    public static void main(String[] args) {
        try {
            String a = "<object name=\"message\">"
            +"<object name=\"message\">"
            +"<object name=\"header\">"
                        +"<attribute name=\"authen_code\" type=\"string\" value=\"measurePoint\" required=\"true\"/>"
                        +"<attribute name=\"action_type\" type=\"dic\" value=\"1\" required=\"true\"/>"
                        +"<attribute name=\"action_time\" type=\"date\" value=\"2012-09-19 21:57:00\" required=\"true\"/>"
                        +"<attribute name=\"target_id\" type=\"string\" value=\"null\" required=\"true\"/>"
                        +"<attribute name=\"target_type\" type=\"dic\" value=\"10\" required=\"true\"/>"
                    +"</object>"
                    +"<list name=\"body\">"
                        +"<object name=\"B1PT1311A\">"
                            +"<attribute name=\"item_code\" type=\"string\" value=\"B1PT1311A\" required=\"true\"/>"
                        +"</object>"
                        +"<object name=\"B3PT1313B\">"
                            +"<attribute name=\"item_code\" type=\"string\" value=\"B3PT1313B\" required=\"true\"/>"
                        +"</object>"
                    +"</list>"
                +"</object>";
            IWsServerMeasuringPoint_ServiceLocator locator = new IWsServerMeasuringPoint_ServiceLocator();
            IWsServerMeasuringPoint_PortType wsServerMear4StandardPort = locator.getWsServerMear4StandardPort();
            String info = wsServerMear4StandardPort.receiveMeasuringPointInfo(a);
            System.out.println(info);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
