package cn.mr.ws.client;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
public class TestClient1 {

    /**
     * 2014-10-10 下午9:41:45 xuejiangtao添加此方法
     * @param args
     */
    public static void main(String[] args) {
        String url = "http://localhost:8080/axisTest/services/AddService";
        try {
            Service service = new Service();
            // 创建调用
            org.apache.axis.client.Call call = (Call) service.createCall();
            // 设置端点地址
            call.setTargetEndpointAddress(url);
            // 设置调用方法
            call.setOperationName(new QName(url, "add"));
            // 执行调用方法,得到结果
            Object result = call.invoke(new Object[] { 1, 2 });
            System.out.println(result);
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
