package com.bridgelab.censusanalyserTests;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StateCensusAnalyser {

    public StateCensusAnalyser() {

    }
    CsvStateCensus csvStateCensus = new CsvStateCensus();
    public <T> int checkNumberOfRecords(String filePathName, T ClassName) throws CSVUserException {
        int count = 0;
        List<T> censusDataList = new ArrayList<T>();
        try {
            Iterator csvIterator = commanOpenCsvBuilder(filePathName, (Class) ClassName);
            while (csvIterator.hasNext()) {
                T csvObj = (T) csvIterator.next();
                censusDataList.add(csvObj);
                count += 1;
            }
           // sortByStatePopulation(censusDataList);
            //sortByState(censusDataList);
           // sortByStatePopulationDensity(censusDataList);
            sortByStateArea(censusDataList);
            sortedCensusDataIntoJson(censusDataList);

        } catch (CSVUserException | IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public <T> Iterator<T> commanOpenCsvBuilder(String filePathName, T className) throws CSVUserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(filePathName));
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

    public <T> void sortByState(List unsortCensusDataList) {
        unsortCensusDataList.sort(Comparator.comparing(CsvStateCensus::getState));
    }

    public void sortedCensusDataIntoJson(List sortedCensusDataList) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(sortedCensusDataList);
        FileWriter writer = new FileWriter("/home/admin105/Desktop/CensusAnalyser/src/main/resources/sortedCensusData.json");
        writer.write(json);
        writer.close();

    }

    public void sortByStatePopulation(List unsortCensusDataList) {
        unsortCensusDataList.sort(Comparator.comparing(CsvStateCensus::getState).reversed());
    }

    public void sortByStatePopulationDensity(List unsortCensusDataList) {
        unsortCensusDataList.sort(Comparator.comparing(CsvStateCensus::getDensityPerSqKm).reversed());
    }

    public void sortByStateArea(List unsortCensusDataList) {
        unsortCensusDataList.sort(Comparator.comparing(CsvStateCensus::getAreaInSqKm).reversed());
    }



}


