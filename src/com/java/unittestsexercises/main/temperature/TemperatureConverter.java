package com.java.unittestsexercises.main.temperature;

import java.util.Objects;

public class TemperatureConverter {
    private double celsiusTemperature;

    public TemperatureConverter() {
        this.celsiusTemperature = 22;
    }

    public TemperatureConverter(double celsiusTemperature) {
        this.celsiusTemperature = celsiusTemperature;
    }

    public double getCelsiusTemperature() {
        return celsiusTemperature;
    }

    public void setCelsiusTemperature(double celsiusTemperature) {
        this.celsiusTemperature = celsiusTemperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TemperatureConverter that)) return false;
        return Double.compare(that.getCelsiusTemperature(), getCelsiusTemperature()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCelsiusTemperature());
    }

    public double getTemperatureInFahrenheit() {
        return this.celsiusTemperature * 33.8;
    }

    public double getTemperatureInKelvin() {
        return this.celsiusTemperature * 274.15;
    }

    public double decreaseTemperature(double degreesValue) {
        double decreasedTemperature = this.celsiusTemperature - degreesValue;

        if (decreasedTemperature >= 0) {
            return decreasedTemperature;
        }
        return this.celsiusTemperature;
    }

    public double increaseTemperature(double degreesValue) {
        double increasedTemperature = this.celsiusTemperature + degreesValue;

        if (increasedTemperature <= 100) {
            return increasedTemperature;
        }
        return this.celsiusTemperature;
    }

    public boolean isWaterBoiling() {
        return this.celsiusTemperature >= 100;
    }

    public boolean ifICannotGoForLectures() {
        return this.celsiusTemperature > 38;
    }
}
