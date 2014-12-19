package com.kosbrother.pullups.training_program;

import java.util.ArrayList;
import java.util.List;


public class TrainContent {


    public static List<TrainItem> Level1 = new ArrayList<TrainItem>();


    static {
        level1AddItem(new TrainItem("Day 01", "1-1-1-1"));
        level1AddItem(new TrainItem("Day 02", "1-2-2-1"));
        level1AddItem(new TrainItem("Day 03", "2-2-1-2"));
    }

    private static void level1AddItem(TrainItem item) {
        Level1.add(item);
    }

    public static class TrainItem {
        public String day;
        public String train_set;

        public TrainItem(String day, String train_set) {
            this.day = day;
            this.train_set = train_set;
        }

        @Override
        public String toString() {
            return day + " " +train_set;
        }
    }
}
