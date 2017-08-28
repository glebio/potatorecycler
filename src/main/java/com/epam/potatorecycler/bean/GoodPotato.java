package com.epam.potatorecycler.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoodPotato implements Potato {

    private int percentOfBlackSpots;

    public GoodPotato() {

    }

    @Override
    public void setPercentOfBlackSpots(int percentOfBlackSpots) {
        this.percentOfBlackSpots = percentOfBlackSpots;
    }

    public int getPercentOfBlackSpots() {
        return percentOfBlackSpots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodPotato that = (GoodPotato) o;

        return percentOfBlackSpots == that.percentOfBlackSpots;
    }

    @Override
    public int hashCode() {
        return percentOfBlackSpots;
    }
}
