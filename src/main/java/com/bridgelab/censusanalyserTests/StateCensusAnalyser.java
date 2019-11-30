package com.bridgelab.censusanalyserTests;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {
    private static final String STATE_CODE_CSV_FILE_PATH = "/home/admin165/Desktop/censusAnalyser/src/main/resources/StateCode.csv";
    int count = 0;

    public int checkNumberOfRecords() {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(STATE_CODE_CSV_FILE_PATH));
        ) {
            CsvToBean<StateCodeCSVUser> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(StateCodeCSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<StateCodeCSVUser> stateCodeCSVUserIterator = csvToBean.iterator();
            while (stateCodeCSVUserIterator.hasNext()) {
                StateCodeCSVUser stateCodeCSVUser = stateCodeCSVUserIterator.next();
                System.out.println("SrNo : " + stateCodeCSVUser.getSrNo());
                System.out.println("State : " + stateCodeCSVUser.getStateName());
                System.out.println("Name : " + stateCodeCSVUser.getTIN());
                System.out.println("TIN : " + stateCodeCSVUser.getStateCode());
                System.out.println("==========================");
                count += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;

    }
}
