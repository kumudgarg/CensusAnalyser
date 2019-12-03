package com.bridgelab.censusanalyserTests;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvBindAndSplitByName;
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
    String STATE_CODE_CSV_FILE_PATH, STATE_CENSUS_CSV_FILE_PATH;

    public StateCensusAnalyser() {

    }

    int count = 0;

    public <T> int checkNumberOfRecords(String filePathName, T ClassName) throws CSVUserException {
        try {
            Iterator csvIterator = commanOpenCsvBuilder(filePathName, (Class) ClassName);
            while (csvIterator.hasNext()) {
                T csv = (T) csvIterator.next();
                count += 1;
            }
        } catch (CSVUserException e) {
            e.printStackTrace();
        }
        return count;
    }

    public <T> Iterator<T> commanOpenCsvBuilder(String filePathName, T className) throws CSVUserException {
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(filePathName));
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType((Class) className)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<T> csvClassNameIterator = csvToBean.iterator();
            return csvClassNameIterator;
        } catch (NoSuchFileException e) {
            System.out.println("in nosuch file");
            throw new CSVUserException(CSVUserException.ExceptionType.FILE_NOT_FOUND, "Such type file doesn't exist");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            System.out.println("in runtime");
            throw new CSVUserException(CSVUserException.ExceptionType.NULL_DATA_FOUND, "delimeter problem or file type problem or header not found or binding data issue", e.getCause());
        }
        return null;
    }
}
