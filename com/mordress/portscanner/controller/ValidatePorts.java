package com.mordress.portscanner.controller;


public class ValidatePorts {

    //Принимаем массив строк пользовательского ввода, возвращаем валидный список портов
    public static boolean isValidPort(String inPorts) {
        int prt;
        try {
            prt = Integer.parseInt(inPorts);
            if (prt > 0 && prt < 65535) {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return false;

    }


}
