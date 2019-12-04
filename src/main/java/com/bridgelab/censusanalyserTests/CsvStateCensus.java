package com.bridgelab.censusanalyserTests;

import com.opencsv.bean.CsvBindByName;

public class CsvStateCensus {

    @CsvBindByName(column = "State")
    private  String State;

    @CsvBindByName(column = "Population")
    private Integer Population;

    @CsvBindByName(column = "AreaInSqKm")
    private String AreaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm")
    private Integer DensityPerSqKm;

    public CsvStateCensus() {

    }

    public CsvStateCensus(String state, Integer population, String areaInSqKm, Integer densityPerSqKm) {
        State = state;
        Population = population;
        AreaInSqKm = areaInSqKm;
        DensityPerSqKm = densityPerSqKm;
    }

    public  String getState() {
        return State;
    }

    public Integer getPopulation() {
        return Population;
    }

    public String getAreaInSqKm() {
        return AreaInSqKm;
    }

    public Integer getDensityPerSqKm() {
        return DensityPerSqKm;
    }

    public void setState(String state) {
        State = state;
    }

    public void setPopulation(Integer population) {
        Population = population;
    }

    public void setAreaInSqKm(String areaInSqKm) {
        AreaInSqKm = areaInSqKm;
    }

    public void setDensityPerSqKm(Integer densityPerSqKm) {
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
