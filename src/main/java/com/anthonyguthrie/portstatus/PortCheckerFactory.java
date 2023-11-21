package com.anthonyguthrie.portstatus;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.List;

public class PortCheckerFactory {
    public static PortChecker create(String ipv4Address) {
        try {
            byte[] byteAddress = new byte[4];
            List<String> strings = Arrays.asList(ipv4Address.split("\\."));
            for (int x = 0; x < 4; x++) {
                byteAddress[x] = ((byte) Integer.parseInt(strings.get(x)));
            }
            Inet4Address inet4Address = (Inet4Address) Inet4Address.getByAddress(byteAddress);
            return new PortChecker(inet4Address);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}