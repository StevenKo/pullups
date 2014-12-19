package com.kosbrother.pullups.statistic.dummy;

import com.kosbrother.pullups.statistic.Record;

import java.util.ArrayList;

/**
 * Created by steven on 12/19/14.
 */
public class RecordContent {
    public static ArrayList<Record> ITEMS = new ArrayList<Record>();

    static {
        addItem(new Record("17下"));
        addItem(new Record("17下"));
    }

    private static void addItem(Record item) {
        ITEMS.add(item);
    }
}
