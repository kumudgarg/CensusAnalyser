package com.bridgelab.censusanalyserTests;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {
    String STATE_CODE_CSV_FILE_PATH;
    public StateCensusAnalyser(String STATE_CODE_CSV_FILE_PATH) {
        this.STATE_CODE_CSV_FILE_PATH = STATE_CODE_CSV_FILE_PATH;
    }
    int count = 0;
    public int checkNumberOfRecords() throws CSVUserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(STATE_CODE_CSV_FILE_PATH));

            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
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
        } catch (NoSuchFileException e) {
            System.out.println("in nosuch file");
            throw new CSVUserException(CSVUserException.ExceptionType.FILE_NOT_FOUND, "Such type file doesn't exist", e.getCause());
        } catch (IOException e) {
            System.out.println("in io exception");
            throw new CSVUserException(CSVUserException.ExceptionType.NULL_DATA_FOUND, "delimeter problem or file type problem", e.getCause());
        } catch (RuntimeException e) {
            System.out.println("in runtime");
            throw new CSVUserException(CSVUserException.ExceptionType.NULL_DATA_FOUND, "delimeter problem or file type problem or header not found or binding data issue", e.getCause());
        }
        return count;
    }
}
