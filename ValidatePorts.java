package com.mordress;


import java.util.ArrayList;

public class ValidatePorts {
    static ArrayList<Integer> portList = new ArrayList<>();
    static ArrayList<Integer> ValidPortList = new ArrayList<>();




    static ArrayList<Integer> isValidPorts(String[] inPorts) {

        for (int i = 0; i < inPorts.length ; i++) {
            try {
                portList.add(Integer.parseInt(inPorts[i]));
            }
            catch (NumberFormatException e) {
                System.err.println("Wrong port: " + inPorts[i]);

            }
        }

        for (int i = 0; i < portList.size() ; i++) {
            if (portList.get(i) > 0 && portList.get(i) < 65535) {
                ValidPortList.add(portList.get(i));
            }
            else {
                System.err.println("Wrong port number " + portList.get(i) + ". Must be at scope 1 - 65535");
            }
        }
        return ValidPortList;

    }


}
