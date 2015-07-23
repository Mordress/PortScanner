package com.mordress.portscanner.view;


import com.mordress.portscanner.controller.ValidateIPV4;
import com.mordress.portscanner.controller.ValidatePorts;
import com.mordress.portscanner.model.Host;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleView {
    static String ip;
    static ArrayList<Integer> ports;
    static boolean exit = false;

    public static void main(String[] args) {
        while (!exit) {
            System.out.print("Enter host's IP: ");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                String input = scanner.nextLine();
                ports = new ArrayList<>();

                if (!ValidateIPV4.isValidIPV4(input)) {
                    System.err.println("Wrong ip! Try again.");
                } else {
                    ip = input;
                    break;
                }
            }

            System.out.println("Enter host's ports 1-65535 (using whitespace for split): ");
            String input = scanner.nextLine();
            String[] inputPorts = input.split("\\s");


            for (String iter : inputPorts) {
                if (ValidatePorts.isValidPort(iter)) {
                    ports.add(Integer.parseInt(iter));
                } else {
                    System.out.println(iter + "\tis not valid port number");
                }
            }

            if (ports != null) {
                for (int prt : ports) {
                    Host host = new Host(ip, prt);
                    if (host.isOpen()) {
                        System.out.println(host + " \tis opened");
                    } else {
                        System.out.println(host + " \tis closed");
                    }
                }
            }
            System.out.println("\'rerun\' - for rerung programm, \'exit\' for exit");
            String userchoice = scanner.nextLine();

            switch (userchoice) {
                case "exit": {
                    exit = true;
                    break;
                }
                case "rerun":
                    break;
                default: {
                    System.out.println("wrong input");
                    return;
                }
            }
        }
    }


}
