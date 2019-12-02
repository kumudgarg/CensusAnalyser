package com.bridgelab.censusanalyserTests;

import com.opencsv.bean.CsvBindByName;

public class CsvStateCensus {

    @CsvBindByName(column = "State",required = true)
    private String State;

    @CsvBindByName(column = "Population" ,required = true)
    private String Population;

    @CsvBindByName(column = "AreaInSqKm")
    private String AreaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm")
    private String DensityPerSqKm;

    public CsvStateCensus() {

    }
    public CsvStateCensus(String state, String population, String areaInSqKm, String densityPerSqKm) {
        State = state;
        Population = population;
        AreaInSqKm = areaInSqKm;
        DensityPerSqKm = densityPerSqKm;
    }

    public String getState() {
        return State;
    }

    public String getPopulation() {
        return Population;
    }

    public String getAreaInSqKm() {
        return AreaInSqKm;
    }

    public String getDensityPerSqKm() {
        return DensityPerSqKm;
    }

    public void setState(String state) {
        State = state;
    }

    public void setPopulation(String population) {
        Population = population;
    }

    public void setAreaInSqKm(String areaInSqKm) {
        AreaInSqKm = areaInSqKm;
    }

    public void setDensityPerSqKm(String densityPerSqKm) {
        DensityPerSqKm = densityPerSqKm;
    }

    @Override
    public String toString() {
        return "CsvStateCensus{" +
                "State='" + State + '\'' +
                ", Population='" + Population + '\'' +
                ", AreaInSqKm='" + AreaInSqKm + '\'' +
                ", DensityPerSqKm='" + DensityPerSqKm + '\'' +
                '}';
    }
}
