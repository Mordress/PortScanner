package com.mordress;


import java.util.ArrayList;

public class ValidatePorts {
    static ArrayList<Integer> portList = new ArrayList<>();




    static ArrayList<Integer> isValidPorts(String[] inPorts) {

        for (int i = 0; i < inPorts.length ; i++) {
            try {
                portList.add(Integer.parseInt(inPorts[i]));
            }
            catch (NumberFormatException e) {
                System.out.println("Wrong port(s)");

            }
        }

        for (int i = 0; i < portList.size() ; i++) {
            if (portList.get(i) < 0 && portList.get(i) > 65535) {
                System.out.println("Wrong port number(0-65535)");

            }
        }
        return portList;

    }


}
