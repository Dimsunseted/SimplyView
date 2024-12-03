package edu.utsa.cs3443.projectplanner.controller;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.utsa.cs3443.projectplanner.MainActivity;
import edu.utsa.cs3443.projectplanner.ObjectiveActivity;
import edu.utsa.cs3443.projectplanner.R;
import edu.utsa.cs3443.projectplanner.model.Objective;
import edu.utsa.cs3443.projectplanner.model.timeline;
import edu.utsa.cs3443.projectplanner.timelineActivity;

public class TimelineController {
    Objective o;
    timelineActivity view;
    public TimelineController(Objective o, timelineActivity activity){
        this.view=activity;
        this.o=o;
        //assign timeline events to the timeline visual
        this.view.setup(this.o.timelines);
        Button b = this.view.findViewById(R.id.backButtontl);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(view, ObjectiveActivity.class);
                view.startActivity(intent);

            }
        });

    }

}
