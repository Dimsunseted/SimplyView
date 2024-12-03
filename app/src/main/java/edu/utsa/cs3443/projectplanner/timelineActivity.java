package edu.utsa.cs3443.projectplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import edu.utsa.cs3443.projectplanner.controller.ObjectController;
import edu.utsa.cs3443.projectplanner.controller.TimelineController;
import edu.utsa.cs3443.projectplanner.model.Objective;
import edu.utsa.cs3443.projectplanner.model.timeline;

public class timelineActivity extends AppCompatActivity {
    static Objective objective;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_timeline);
        TimelineController controller = new TimelineController(objective,this);
    }
    public static void setObjective(Objective o){
        objective=o;
    }
    public void setup(ArrayList<timeline> timelines){
        int i=0;
        for(timeline t : timelines){
            i++;

            //assign text 1, assign due date, assign completion
            String id = "tlTxt"+Integer.toString(i);
            int resID = getResources().getIdentifier(id, "id", this.getPackageName());
            TextView title=this.findViewById(resID);
            title.setText(t.getName());

            id = "tlDue"+Integer.toString(i);
            resID = getResources().getIdentifier(id, "id", this.getPackageName());
            title=this.findViewById(resID);
            title.setText(t.getDue());


            id = "tlC"+Integer.toString(i);
            resID = getResources().getIdentifier(id, "id", this.getPackageName());
            title=this.findViewById(resID);
            title.setText(t.getC());



        }
    }
}
