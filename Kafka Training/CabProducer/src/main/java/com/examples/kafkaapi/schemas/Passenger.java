package com.examples.kafkaapi.schemas;

import com.opencsv.bean.CsvBindByName;

public class Passenger {
    @CsvBindByName
    public int passengerid;

    @CsvBindByName(column="name")
    public String name;

    @CsvBindByName
    public String source;

    @CsvBindByName
    public String destination;

    public int getPassengerid() {
        return passengerid;
    }

    public void setPassengerid(int passengerid) {
        this.passengerid = passengerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
