package com.zzu.demo.udp;

import lombok.extern.slf4j.Slf4j;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
@Slf4j
public class UdpServer extends Thread implements Runnable {
    private final int MAX_LENGTH = 1024;
    private final int PORT = 5060;
    private final int TIMEOUT = 5000;
    private DatagramSocket datagramSocket;

    @Override
    public void run() {
        try {
            init();
            while(true){
                try {
                    byte[] buffer = new byte[MAX_LENGTH];
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    datagramSocket.receive(packet);
                    String receStr = new String(packet.getData(), 0 , packet.getLength());
                    log.info("接收数据包:" + receStr);

//                    byte[] bt = new byte[packet.getLength()];
//                    System.arraycopy(packet.getData(), 0, bt, 0, packet.getLength());
//                    log.info("service:"+packet.getAddress().getHostAddress() + "：" + packet.getPort() + "：" + new String(bt));

                    //回复客户端
//                    InetAddress address = packet.getAddress();
//                    int port = packet.getPort();

                    byte[] responseLanguage = "Yea,You can".getBytes();
                    packet.setData(responseLanguage);
                    datagramSocket.send(packet);

                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("udp线程出现异常：" + e.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化连接
     */
    public void init(){
        try {
            datagramSocket = new DatagramSocket(PORT);
            //datagramSocket.setSoTimeout(TIMEOUT);//设置超时响应时间，防止进入无限等待状态
            log.info("udp服务端已经启动！");
        } catch (Exception e) {
            datagramSocket = null;
            log.error("udp服务端启动失败！");
            e.printStackTrace();
        }
    }
}
