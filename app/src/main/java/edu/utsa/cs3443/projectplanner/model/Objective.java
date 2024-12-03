package edu.utsa.cs3443.projectplanner.model;

import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import edu.utsa.cs3443.projectplanner.MainActivity;

public class Objective {
    private int id;
    private String name;
    private String timelineFile;
    private String budgetFile;
    //timeline variables
    public ArrayList<timeline> timelines;//note one timeline is one timeline event, not the whole timeline this arraylist will be the full timeline

    public Objective(String name,int id, String fileName, MainActivity activity){
        this.id=id;
        this.name=name;
        this.timelines=new ArrayList<timeline>();
        AssetManager manager = activity.getAssets();
        Scanner scan = null;

        try {
            //open obj file and collect the names of the bdg and timeline file
            InputStream file = manager.open(fileName);
            scan= new Scanner(file);
            this.name=scan.nextLine();//this line will consume the first line
            this.timelineFile=scan.nextLine();
            this.budgetFile=scan.nextLine();
            scan.close();

            System.out.println(this.timelineFile);


            //collect input from the timeline file
            file=manager.open(this.timelineFile);

            int n=0;
            String toSplit;
            for(scan = new Scanner(file); scan.hasNext(); )
            {
                //splits input from the .tl file and turns it into a timeline object

                ++n;
                toSplit = scan.nextLine();

                String [] data = toSplit.split(",");

                timeline t = new timeline(data[0],data[1],data[2],Boolean.parseBoolean(data[3]));

                timelines.add(t);

            }


            System.out.println(timelines.get(0).getName());
            //collect input from the BUDGET file



            scan.close();


        }
        catch (IOException e) {
            System.out.println("FILE EXCEPTION");
        }

    }
    public String getName(){
        return this.name;
    }
    public String getBudgetFile(){
        return this.budgetFile;
    }
}
