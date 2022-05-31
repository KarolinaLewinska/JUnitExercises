package com.java.unittestsexercises.test;

import com.java.unittestsexercises.main.temperature.TemperatureConverter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TemperatureConverterTests {
    TemperatureConverter temperatureConverter;

    @BeforeEach
    void beforeEach() {
        temperatureConverter = new TemperatureConverter();
    }

    @Test
    void shouldReturnFahrenheit() {
        assertEquals(743.6, temperatureConverter.getTemperatureInFahrenheit());
    }

    @Test
    void shouldReturnKelvin() {
        TemperatureConverter temperatureConverter = new TemperatureConverter(44.5);
        assertEquals(12199.7, temperatureConverter.getTemperatureInKelvin());
    }

    @Test
    void shouldDecreaseTemperature() {
        TemperatureConverter temperatureConverter = new TemperatureConverter(20);
        assertEquals(0, temperatureConverter.decreaseTemperature(20));
    }

    @Test
    void shouldNotDecreaseTemperature() {
        assertEquals(22, temperatureConverter.decreaseTemperature(30));
    }

    @Test
    void shouldIncreaseTemperature() {
        assertEquals(33.7, temperatureConverter.increaseTemperature(11.7));
    }

    @Test
    void shouldNotIncreaseTemperature() {
        TemperatureConverter temperatureConverter = new TemperatureConverter(1);
        assertEquals(1, temperatureConverter.increaseTemperature(200));
    }

    @Test
    void shouldWaterBeBoiling() {
        TemperatureConverter temperatureConverter = new TemperatureConverter(100.1);
        assertTrue(temperatureConverter.isWaterBoiling());
    }

    @Test
    void shouldNotWaterBeBoiling() {
        assertFalse(temperatureConverter.isWaterBoiling());
    }

    @Test
    void iCannotGoForLecturesReturnsTrue() {
        TemperatureConverter temperatureConverter = new TemperatureConverter(44);
        assertTrue(temperatureConverter.ifICannotGoForLectures());
    }

    @Test
    void iCannotGoForLectureReturnsFalse() {
        assertFalse(temperatureConverter.ifICannotGoForLectures());
    }

    @AfterEach
    void afterEach() {
        temperatureConverter = null;
    }
}
