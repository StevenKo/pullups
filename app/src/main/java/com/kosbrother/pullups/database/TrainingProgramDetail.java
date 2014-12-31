package com.kosbrother.pullups.database;

/**
 * Created by steven on 12/31/14.
 */
public class TrainingProgramDetail {
    public int id;
    public String set;
    public String setRelax;
    public int trainingProgramId;
    public int expectNum;

    public TrainingProgramDetail(int id, String set, String setRelax, int trainingProgramId, int expectNum){
        this.id = id;
        this.set = set;
        this.setRelax = setRelax;
        this.trainingProgramId = trainingProgramId;
        this.expectNum = expectNum;
    }
}
