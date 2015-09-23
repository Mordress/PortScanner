package com.mordress.portscanner.view;


import com.mordress.portscanner.controller.ValidateIPV4;
import com.mordress.portscanner.controller.ValidatePorts;
import com.mordress.portscanner.model.Host;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleView {

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.print("Enter host's IP: ");
            Scanner scanner = new Scanner(System.in);
            String userInputHostIp;
            while (true) {
                userInputHostIp = scanner.nextLine();
                if (userInputHostIp == null || !ValidateIPV4.isValidIPV4(userInputHostIp)) {
                    System.err.println("Wrong ip! Try again.");
                } else {
                    break;
                }
            }

            System.out.println("Enter host's ports 1-65535 (using whitespace for split): ");
            String ports = scanner.nextLine();
            String[] userInputPorts = ports.split("\\s");

            for (String iter : userInputPorts) {
                if (ValidatePorts.isValidPort(iter)) {
                    Host host = new Host(userInputHostIp, Integer.parseInt(iter));
                    if (host.isOpen()) {
                        System.out.println(host + " \t\tis opened");
                    } else {
                        System.out.println(host + " \t\tis closed");
                    }
                } else {
                    System.out.println(iter + "\tis not valid port number");
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
