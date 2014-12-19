package com.kosbrother.pullups.statistic;

/**
 * Created by steven on 12/19/14.
 */
public class Record {


    public String name;

    public Record(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
