package com.mordress;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by Mordress on 28.05.2015.
 */
public class Host {
    private String ip = "0.0.0.0";
    private int port;
    private final int timeout = 1000;

    public Host(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }



    boolean isOpen() {
        try {
            Socket socket = new Socket();
            SocketAddress socketAddress = new InetSocketAddress(this.ip, this.port);
            socket.connect(socketAddress, this.timeout);
            socket.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return ip + ":" + port + " ";
    }
}
