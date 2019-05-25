package com.twitter.challenge.util;

import java.util.List;

public class DeviationCalculator {

    public static float calculateDeviation(List<Float> list) {
        int dayNum = 0;
        float sum = 0;

        for (float aFloat :  list) {
            dayNum++;
            sum += aFloat;
        }
        float avg = sum / dayNum;
        sum = 0;

        for (float aFloat : list) {
            sum += Math.pow(aFloat - avg, 2);
        }

        return (float) Math.sqrt(sum / (dayNum - 1));
    }
}
