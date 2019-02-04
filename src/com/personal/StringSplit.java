package com.personal;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringSplit {

    static Map<String,Integer> mapOfIndexes = new HashMap<>();
    static Map<String,String> mapOfOutput = new LinkedHashMap<>();

    public static void main(String[] args) {

        String input = "N1*a1*b1*c1~N2*a2*b2*c2~N1*a3*b3*c3*d4";

        String[] firstSplit = input.split("~");

        for(String temp : firstSplit) {
            secondSplit(temp);
        }

        System.out.println("Map is " + mapOfOutput.toString());

    }

    private static void secondSplit(String stringWithAsteriks) {

        String[] secondSplit = stringWithAsteriks.split("\\*");

        if( mapOfIndexes.containsKey(secondSplit[0])) {
            Integer existingCount = mapOfIndexes.get(secondSplit[0]);
            mapOfIndexes.replace(secondSplit[0],++existingCount);
        }
        else {
            mapOfIndexes.put(secondSplit[0],1);
        }

        String keyForSecondMap = secondSplit[0] + "_" + mapOfIndexes.get(secondSplit[0]) + "_" ;

        for(int i=1; i < secondSplit.length;++i) {
            mapOfOutput.put( keyForSecondMap.concat(String.valueOf(i)),secondSplit[i]);
        }
    }
}
