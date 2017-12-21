package cn.mr.udp.test1;

import java.net.InetAddress;

public class lanDemo {
    public static String msg;   

    public static String ip;
    public static String hostName;
    public static void main(String[] args) { // 程序入口点
        lanSend lSend;
        try {
            InetAddress addr = InetAddress.getLocalHost();
            ip = addr.getHostAddress().toString();
            hostName = addr.getHostName().toString();
            msg = ip + "@" + hostName;
            lSend = new lanSend();
            lSend.join(); // 加入组播，并创建线程侦听
            lSend.sendGetUserMsg(); // 广播信息，寻找上线主机交换信息
            Thread.sleep(3000); // 程序睡眠3秒
            lSend.offLine(); // 广播下线通知
        } catch (Exception e) {
            System.out.println("*****获取本地用户信息出错*****");
        }
    }
}
