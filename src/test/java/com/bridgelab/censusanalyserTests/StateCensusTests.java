package com.bridgelab.censusanalyserTests;

import org.junit.Assert;
import org.junit.Test;

public class StateCensusTests {
    @Test
    public void givenNumberOfRecords_ChecksWhetherMatchesOrNot_() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        int checkNumberOfRecords = stateCensusAnalyser.checkNumberOfRecords();
        Assert.assertEquals(37, checkNumberOfRecords);

    }
}
