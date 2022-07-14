package com.examples.kafkaapi;

import com.examples.kafkaapi.schemas.Passenger;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.util.List;

public class ReadPassenger {
    public String csvFileName = "data/passenger.csv";
    public List passengerlist;


    public List ReadCSVFile()  {

        try {
            CSVReader csvReader = new CSVReader(new FileReader(csvFileName));

            CsvToBean csvToBean = new CsvToBeanBuilder(csvReader)
                    .withType(Passenger.class)
                    .withIgnoreLeadingWhiteSpace(true).build();

            //This method is not recommended for large CSV File
            passengerlist = csvToBean.parse();

            csvReader.close();
        }catch(Exception FileNotFoundException){
            //e.printStackTrace();
            System.out.println("File is not available...");
        }

        return passengerlist;
    }
}
