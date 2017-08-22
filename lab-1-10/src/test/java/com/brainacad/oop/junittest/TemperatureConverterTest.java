package com.brainacad.oop.junittest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/**
 * Created by Павло on 10.08.2017.
 */
public class TemperatureConverterTest {
    TemperatureConverter temperatureConverter = null;



    @Before
    public void setUp() throws Exception {
        temperatureConverter = new TemperatureConverter();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void convertFtoC() throws Exception {
        double cel = 455.5;
        double expected = cel / 5.0 * 9.0 + 32.0;
        double unexpected = cel / 5.0 * 9.0 + 33.0;
        double actual = temperatureConverter.convertCtoF(cel);
        assertEquals(expected, actual, 0.1);
        assertNotEquals(unexpected, actual);
    }

    @Test
    public void convertCtoF() throws Exception {
    }

    @Test
    public void convertCtoK() throws Exception {
    }

    @Test
    public void convertKtoC() throws Exception {
    }

    @Test
    public void convertFtoK() throws Exception {
    }

    @Test
    public void convertKtoF() throws Exception {
    }

}