package com.twitter.challenge;

import com.twitter.challenge.util.DeviationCalculator;

import org.assertj.core.data.Offset;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.within;

public class DeviationCalculatorTest {

    @Test
    public void testOnCalculateDeviation() {
        final Offset<Float> precision = within(0.01f);

        List<Float> testList = new ArrayList<>();
        testList.add((float) 2.0);
        testList.add((float) 3.0);
        testList.add((float) 4.0);
        testList.add((float) 5.0);
        testList.add((float) 6.0);

        assertThat(DeviationCalculator.calculateDeviation(testList)).isEqualTo((float) 1.5811, precision);
    }
}
