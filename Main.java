package com.mordress;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static String ip;
    static ArrayList<Integer> ports;

    public static void main(String[] args) {
        System.out.print("Enter host's IP: ");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (!ValidateIPV4.isValidIPV4(input)) {
                System.out.println("Wrong ip! Try again.");
            }
            else{
                ip = input;
                break;}
        }

        System.out.println("\nEnter host's ports(using whitespace for split): ");
        String input = scanner.nextLine();
        String[] inputPorts = input.split("\\s");
        ports = new ArrayList<Integer>();
        for (String i : inputPorts) {
            try {
                ports.add(Integer.parseInt(i));
            }
            catch (NumberFormatException e) {
                System.out.println("Wrong port number(s)");
            }
        }

        for (int prt : ports) {
            Host host = new Host(ip, prt);
            if (host.isOpen()) {
                System.out.println(host + " \tis opened");
            }
            else {
                System.out.println(host + " \tis closed");
            }
        }
    }


}
