package com.kosbrother.pullups.database;

import java.util.ArrayList;

/**
 * Created by steven on 12/31/14.
 */
public class TrainingProgram {
    public int id;
    public String name;
    public ArrayList<TrainingProgramDetail> details;

    public TrainingProgram(int id, String name, ArrayList<TrainingProgramDetail> details){
        this.id = id;
        this.name = name;
        this.details = details;
    }
}
