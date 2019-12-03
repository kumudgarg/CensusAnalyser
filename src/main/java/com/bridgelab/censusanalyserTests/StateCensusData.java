package com.bridgelab.censusanalyserTests;

import com.opencsv.bean.CsvBindByName;

public class StateCensusData {

    public StateCensusData() {

    }

    public StateCensusData(String srNo, String stateName, String TIN, String stateCode, String population, String areaInSqKm, String densityPerSqKm) {
        SrNo = srNo;
        StateName = stateName;
        this.TIN = TIN;
        StateCode = stateCode;
        Population = population;
        AreaInSqKm = areaInSqKm;
        DensityPerSqKm = densityPerSqKm;
    }

    private CsvStateCensus censusobj;

    @CsvBindByName(column = "SrNo")
    private String SrNo;

    @CsvBindByName(column = "StateName")
    private String StateName;

    @CsvBindByName(column = "TIN")
    private String TIN;

    @CsvBindByName(column = "StateCode")
    private String StateCode;

    private String Population;

    private String AreaInSqKm;

    private String DensityPerSqKm;

    public String getSrNo() {
        return SrNo;
    }

    public String getStateName() {
        return StateName;
    }

    public String getTIN() {
        return TIN;
    }

    public String getStateCode() {
        return StateCode;
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

    public void setSrNo(String srNo) {
        SrNo = srNo;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    public void setTIN(String TIN) {
        this.TIN = TIN;
    }

    public void setStateCode(String stateCode) {
        StateCode = stateCode;
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

    public CsvStateCensus getCensusobj() {
        return censusobj;
    }

    public void setCensusobj(CsvStateCensus censusobj) {
        this.censusobj = censusobj;
    }

    @Override
    public String toString() {
        return "StateCensusData{" +
                "SrNo='" + SrNo + '\'' +
                ", StateName='" + StateName + '\'' +
                ", TIN='" + TIN + '\'' +
                ", StateCode='" + StateCode + '\'' +
                ", Population='" + Population + '\'' +
                ", AreaInSqKm='" + AreaInSqKm + '\'' +
                ", DensityPerSqKm='" + DensityPerSqKm + '\'' +
                '}';
    }
}
