package edu.utsa.cs3443.projectplanner.controller;

import android.content.Intent;
import android.content.res.AssetManager;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.utsa.cs3443.projectplanner.MainActivity;
import edu.utsa.cs3443.projectplanner.ObjectiveActivity;
import edu.utsa.cs3443.projectplanner.R;
import edu.utsa.cs3443.projectplanner.model.Objective;

public class MainController {
    MainActivity view;
    ArrayList<Objective> objectives;
    Intent intent;
    int selectedID;
    public MainController(MainActivity activity) throws IOException {
        this.view=activity;

         this.objectives= new ArrayList<Objective>();
        //loops through all asset files and
        AssetManager manager = activity.getAssets();
        Scanner scan = null;
        String fileList[] = manager.list("");
        int i=0;
        for (String fileName : fileList) {
            //.prj files are the main file for any project
            if (fileName.endsWith(".prj")){
                //open the file read the name, create Objective object and add to arraylist
                scan = new Scanner(fileName);
                Objective o = new Objective(scan.nextLine(),i,fileName,activity);
                objectives.add(o);
                //assign button text to title;

            }

        }
        setupButtons();

    }
    void setupButtons(){
        Button obj0=this.view.findViewById(R.id.obj0);
        Button obj1=this.view.findViewById(R.id.obj1);
        Button obj2=this.view.findViewById(R.id.obj2);
        Button obj3=this.view.findViewById(R.id.obj3);
        Button[] buttons ={obj0,obj1,obj2,obj3};
        int i=0;
        for (Objective objective: this.objectives) {

            buttons[i].setText(objective.getName());
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //change view to the "objective" page and change the text based on the objective selected
                    ObjectiveActivity.setObjective(objective);
                    intent = new Intent(view, ObjectiveActivity.class);
                    view.startActivity(intent);

                }
            });

            i++;
            if(i>=4){
                break;
            }
        }


    }
}
