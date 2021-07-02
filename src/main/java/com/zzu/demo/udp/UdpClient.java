package com.zzu.demo.udp;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.*;
@Slf4j
public class UdpClient {

    private String sendStr = "Can I come in ?";
    private String netAddress = "255.255.255.255";
    private final int PORT = 5060;

    private DatagramSocket datagramSocket;
    private DatagramPacket datagramPacket;

    public UdpClient(){
        try {
            datagramSocket = new DatagramSocket();
            byte[] buf = sendStr.getBytes();
            InetAddress address = InetAddress.getByName(netAddress);
            datagramPacket = new DatagramPacket(buf, buf.length, address, PORT);
            datagramSocket.send(datagramPacket);

            //接受服务端信息
            byte[] receBuf = new byte[1024];
            DatagramPacket recePacket = new DatagramPacket(receBuf, receBuf.length);
            datagramSocket.receive(recePacket);

            String receStr = new String(recePacket.getData(), 0 , recePacket.getLength());
            log.info("client receive:"+receStr);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭socket
            if(datagramSocket != null){
                datagramSocket.close();
            }
        }
    }

    public static void main(String[] args) {
        UdpServer udpServer = new UdpServer();
        udpServer.start();
        for (int i = 0; i < 1; i++) {
            new Thread(() -> {
                new UdpClient();
            }).start();
        }
    }
}