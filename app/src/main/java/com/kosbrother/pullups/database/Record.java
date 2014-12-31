package com.kosbrother.pullups.database;


import java.util.Date;

/**
 * Created by steven on 12/31/14.
 */
public class Record {
    public int id;
    public Date trainingDate;
    public int trainingProgramId;
    public int trainingProgramDetailId;
    public String detail;
    public int totalNum;
    public TrainingProgram trainingProgram;
    public TrainingProgramDetail trainingProgramDetail;

    public Record(int id, Date trainingDate,int trainingProgramId, int trainingProgramDetailId, String detail, int totalNum, TrainingProgram trainingProgram, TrainingProgramDetail trainingProgramDetail){
        this.id = id;
        this.trainingDate = trainingDate;
        this.trainingProgramDetailId = trainingProgramDetailId;
        this.trainingProgramId = trainingProgramId;
        this.detail = detail;
        this.totalNum = totalNum;
        this.trainingProgram = trainingProgram;
        this.trainingProgramDetail = trainingProgramDetail;
    }

}
