package com.mordress;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class Main {
    private static String IP = "127.0.0.1";
    private static String[] ports;
    private static final int timeout = 1000;
    static boolean exit = false;

    public static String getIP() {
        return IP;
    }


    public static void setIP(String Ip) {
        Main.IP = Ip;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (!exit) {

            System.out.print("Enter host's IP: ");

            setIP(scanner.nextLine());

            System.out.print("\nEnter host's ports: ");

            String inPorts = scanner.nextLine();
            ports = inPorts.split("\\s");

            for (int i = 0; i < ports.length; i++) {
                if (isOpen(IP, Integer.parseInt(ports[i]), timeout)) {
                    System.out.println("port " + ports[i] + " \tis opened");
                } else {
                    System.out.println("port " + ports[i] + " \tis closed");
                }
            }
            System.out.println("For exit type \"exit\", for rerun type - \"rerun\"");
            String choice = scanner.nextLine();
            switch (choice) {
                case "exit": exit = true; break;
                case "rerun": exit = false; break;
                default:
                    System.out.println("Wrong input. Try again.");

            }



        }





    }

    public static boolean isOpen(String host, int port, int timeout) {
        try {
            Socket socket = new Socket();
            SocketAddress socketAddress = new InetSocketAddress(host, port);
            socket.connect(socketAddress, timeout);
            socket.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
