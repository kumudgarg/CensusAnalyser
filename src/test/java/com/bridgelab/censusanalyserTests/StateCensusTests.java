package com.bridgelab.censusanalyserTests;

import org.junit.Assert;
import org.junit.Test;

public class StateCensusTests {
    @Test
    public void givenNumberOfRecords_ChecksWhetherMatchesOrNot_() throws CSVUserException {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser("/home/admin165/Desktop/censusAnalyser/src/main/resources/StateCode.csv");
        int checkNumberOfRecords = stateCensusAnalyser.checkNumberOfRecords();
        Assert.assertEquals(37, checkNumberOfRecords);

    }

    @Test
    public void givenWrongFileName_ShouldThrowNoSuchFileException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser("/home/admin165/Desktop/censusAnalyser/src/main/resources/StateCode12.csv");
            int checkNumberOfRecords = stateCensusAnalyser.checkNumberOfRecords();
        } catch (CSVUserException e) {
            Assert.assertEquals("Such type file doesn't exist", e.getMessage());
        }
    }

    @Test
    public void givenWrongFileType_ShouldThrowFileNotFoundException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser("/home/admin165/Desktop/censusAnalyser/src/main/resources/Basic Programs.pdf");
            int checkNumberOfRecords = stateCensusAnalyser.checkNumberOfRecords();
        } catch (CSVUserException e) {
            Assert.assertEquals("binding of file to failed", e.getMessage());
        }
    }


}
