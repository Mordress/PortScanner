package com.mordress.portscanner.model;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Host {

    private String ip = "0.0.0.0";

    private int port;

    private final int TIMEOUT = 1000;

    public Host(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public boolean isOpen() {
        try {
            Socket socket = new Socket();
            SocketAddress socketAddress = new InetSocketAddress(this.ip, this.port);
            socket.connect(socketAddress, this.TIMEOUT);
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
