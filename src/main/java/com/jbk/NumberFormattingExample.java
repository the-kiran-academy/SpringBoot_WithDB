package com.jbk;

import java.text.DecimalFormat;

public class NumberFormattingExample {
    public static void main(String[] args) {
        double number = 4506.610000000001;
        
        DecimalFormat decimalFormat = new DecimalFormat("#.000");
        String formattedNumber = decimalFormat.format(number);
        
        System.out.println(formattedNumber);
    }
}
