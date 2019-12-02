package com.bridgelab.censusanalyserTests;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCensusTests {
    @Test
    public void givenNumberOfRecords_ChecksWhetherMatchesOrNot_() throws CSVUserException, IOException {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        int checkNumberOfRecords = stateCensusAnalyser.checkNumberOfRecords("/home/admin165/Desktop/censusAnalyser/src/main/resources/StateCode.csv");
        Assert.assertEquals(37, checkNumberOfRecords);

    }

    @Test
    public void givenWrongFileName_ShouldThrowNoSuchFileException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            int checkNumberOfRecords = stateCensusAnalyser.checkNumberOfRecords("/home/admin165/Desktop/censusAnalyser/src/main/resources/StateCode12.csv");
        } catch (CSVUserException e) {
            e.printStackTrace();
            Assert.assertEquals("Such type file doesn't exist", e.getMessage());
        }
    }

    @Test
    public void givenWrongFileType_ShouldThrowRunTimeException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            int checkNumberOfRecords = stateCensusAnalyser.checkNumberOfRecords("/home/admin165/Desktop/censusAnalyser/src/main/resources/StateCensusData.csv");
        } catch (CSVUserException e) {
            Assert.assertEquals("Such type file doesn't exist", e.getMessage());
            e.printStackTrace();

        }
    }

    @Test
    public void givenWrongDelimer_ShouldThrowRunTimeException() throws CSVUserException {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            int checkNumberOfRecords = stateCensusAnalyser.checkNumberOfRecords("/home/admin165/Desktop/censusAnalyser/src/main/resources/delimeterCsv.csv");
        } catch (CSVUserException e) {
            e.printStackTrace();
            Assert.assertEquals("delimeter problem or file type problem or header not found or binding data issue", e.getMessage());
        }
    }
    @Test
    public void givenWrongheaders_ShouldThrowRunTimeException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            int checkNumberOfRecords = stateCensusAnalyser.checkNumberOfRecords("/home/admin165/Desktop/censusAnalyser/src/main/resources/delimeterCsv.csv");
        } catch (CSVUserException e) {
            e.printStackTrace();
            Assert.assertEquals("delimeter problem or file type problem or header not found or binding data issue", e.getMessage());
        }
    }

    @Test
    public void givenNumOfRecords_ChecksWhetherMatchesOrNot_() throws CSVUserException {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        int checkNumberOfRecords = stateCensusAnalyser.checkNumberOfRecordsOfSateCensus("/home/admin165/Desktop/censusAnalyser/src/main/resources/StateCensusData.csv");
        Assert.assertEquals(29, checkNumberOfRecords);

    }

    @Test
    public void givenWrongStateCensusName_ShouldThrowNoSuchFileException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            int checkNumberOfRecords = stateCensusAnalyser.checkNumberOfRecordsOfSateCensus("/home/admin165/Desktop/censusAnalyser/src/main/resources/StateCensusData123.csv");
        } catch (CSVUserException e) {
            e.printStackTrace();
            Assert.assertEquals("Such type file doesn't exist", e.getMessage());
        }
    }

    @Test
    public void givenWrongFileType_ShouldThrowNoSuchFileException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            int checkNumberOfRecords = stateCensusAnalyser.checkNumberOfRecordsOfSateCensus("/home/admin105/Desktop/CensusAnalyser/src/main/resources/StateCode.csv");
        } catch (CSVUserException e) {
            Assert.assertEquals("delimeter problem or file type problem or header not found or binding data issue", e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void givenWrongDelimerInCensusData_ShouldReturnWrongDelimiterException() throws CSVUserException {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            int checkNumberOfRecords = stateCensusAnalyser.checkNumberOfRecords("/home/admin105/Desktop/CensusAnalyser/src/main/resources/CensusDelimiter.csv");
        } catch (CSVUserException e) {
            e.printStackTrace();
            Assert.assertEquals("delimeter problem or file type problem or header not found or binding data issue", e.getMessage());
        }
    }


}
