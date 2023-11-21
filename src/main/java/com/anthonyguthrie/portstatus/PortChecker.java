package com.anthonyguthrie.portstatus;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.SocketException;

public class PortChecker {
    private Inet4Address inet4Address;
    private DatagramSocket datagramSocket;

    public PortChecker(Inet4Address inet4Address) {
        this.inet4Address = inet4Address;
    }

    public boolean checkUDPPort(int port) {
        DatagramSocket udp = null;
        try {
            udp = new DatagramSocket(port, this.inet4Address);
            if (udp != null && udp.isBound()) {
                udp.close();
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean checkTCPPort(int port) {
        Socket tcp = null;
        try {
            tcp = new Socket(inet4Address, port);
            if (tcp != null && tcp.isBound()) {
                tcp.close();
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public String checkPort(int port) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean tcpTest, udpTest = false;
        tcpTest = checkTCPPort(port);
        udpTest = checkUDPPort(port);
        stringBuilder.append("Checking Port#: " + port + "\n");
        stringBuilder.append((tcpTest == true) ? "TCP: OPEN\n" : "TCP: UNAVAILABLE\n");
        stringBuilder.append((udpTest == true) ? "UDP: OPEN\n" : "UDP: UNAVAILABLE\n");
        return stringBuilder.toString();
    }
}
