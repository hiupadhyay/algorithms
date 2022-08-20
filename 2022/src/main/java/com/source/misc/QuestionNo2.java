package com.source.misc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class QuestionNo2 {

    /**
     * *
     *
     * @param totalCapacity          maximum capacity a pair for foreground and background device shares.
     * @param foregroundApplications map of applicationId and memoryConsumption by that device
     * @param backgroundApplications map of applicationId and memoryConsumption by that device
     *
     * @return
     */
    public static Map<Integer, Integer> optimalPairs(final int totalCapacity,
            final Map<Integer, Integer> foregroundApplications,
            final Map<Integer, Integer> backgroundApplications) {

        int maxCapacityOfPair = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Map.Entry<Integer, Integer> fg : foregroundApplications.entrySet()) {
            for (Map.Entry<Integer, Integer> bg : backgroundApplications.entrySet()) {
                maxCapacityOfPair = Math.max(maxCapacityOfPair, fg.getValue() + bg.getValue());
                if (maxCapacityOfPair < totalCapacity) {
                    map.clear();
                    map.put(fg.getKey(), bg.getKey());
                }
            }
        }

        if (map.isEmpty()) {

            return Collections.emptyMap();
        }
        return map;
    }

    public static void main(String[] args) {
        final Map<Integer,Integer> foregroundApplications=new HashMap<>();
        final Map<Integer,Integer> backgroundApplications=new HashMap<>();
        foregroundApplications.put(101,2);
        foregroundApplications.put(102,4);
        foregroundApplications.put(103,6);

        backgroundApplications.put(201,2);
        System.out.println(optimalPairs(8,foregroundApplications,backgroundApplications));


    }
}
