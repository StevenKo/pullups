package com.kosbrother.pullups.database.dummy;

import com.kosbrother.pullups.database.Record;
import com.kosbrother.pullups.database.TrainingProgram;
import com.kosbrother.pullups.database.TrainingProgramDetail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by steven on 12/31/14.
 */
public class Dummy {
    static public ArrayList<Record> RECORDS = new ArrayList<Record>();
    static public ArrayList<TrainingProgramDetail> DETAILS = new ArrayList<TrainingProgramDetail>();
    static public TrainingProgram PROGRAM = new TrainingProgram(1,"Program 1",DETAILS);

    static public TrainingProgramDetail trainingDetail1;
    static public TrainingProgramDetail trainingDetail2;
    static public TrainingProgramDetail trainingDetail3;

    static{
        trainingDetail1 = new TrainingProgramDetail(1,"3-2-1-3","60-60-60-60",1,9);
        trainingDetail2 = new TrainingProgramDetail(2,"3-2-1-4","60-60-60-60",1,10);
        trainingDetail3 = new TrainingProgramDetail(3,"3-2-1-5","60-60-60-60",1,11);
        DETAILS.add(trainingDetail1);
        DETAILS.add(trainingDetail2);
        DETAILS.add(trainingDetail3);

        String dtStart1 = "2010-10-15T09:27:37Z";
        String dtStart2 = "2010-10-16T09:27:37Z";
        String dtStart3 = "2010-10-17T09:27:37Z";
        String dtStart4 = "2010-10-18T09:27:37Z";
        String dtStart5 = "2010-10-19T09:27:37Z";
        String dtStart6 = "2010-10-20T09:27:37Z";
        String dtStart7 = "2010-10-26T09:27:37Z";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

        try {
            RECORDS.add(new Record(1,format.parse(dtStart1),1,1,"1-1-1-0",3,PROGRAM,trainingDetail1));
            RECORDS.add(new Record(2,format.parse(dtStart2),1,1,"1-1-1-1",4,PROGRAM,trainingDetail1));
            RECORDS.add(new Record(3,format.parse(dtStart3),1,1,"3-1-1-1",6,PROGRAM,trainingDetail1));
            RECORDS.add(new Record(4,format.parse(dtStart4),1,1,"3-2-1-2",8,PROGRAM,trainingDetail1));
            RECORDS.add(new Record(5,format.parse(dtStart5),1,1,"3-2-1-3",9,PROGRAM,trainingDetail1));
            RECORDS.add(new Record(6,format.parse(dtStart6),1,1,"3-2-1-4",10,PROGRAM,trainingDetail2));
            RECORDS.add(new Record(7,format.parse(dtStart7),1,1,"3-2-1-4",10,PROGRAM,trainingDetail3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
