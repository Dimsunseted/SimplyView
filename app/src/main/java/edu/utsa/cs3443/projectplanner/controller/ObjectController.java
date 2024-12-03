package edu.utsa.cs3443.projectplanner.controller;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import edu.utsa.cs3443.projectplanner.BudgetActivity;
import edu.utsa.cs3443.projectplanner.MainActivity;
import edu.utsa.cs3443.projectplanner.ObjectiveActivity;
import edu.utsa.cs3443.projectplanner.R;
import edu.utsa.cs3443.projectplanner.model.Objective;
import edu.utsa.cs3443.projectplanner.timelineActivity;

public class ObjectController {
    //controller for the Objective page
    Objective o;
    ObjectiveActivity view;
    public ObjectController(ObjectiveActivity a, Objective objective){
        this.view=a;
        this.o=objective;
        TextView tittle=this.view.findViewById(R.id.objTitle);
        tittle.setText(this.o.getName());

        Button b = this.view.findViewById(R.id.timelineButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //change view to the "objective" page and change the text based on the objective selected
                timelineActivity.setObjective(objective);
                Intent intent = new Intent(view, timelineActivity.class);
                view.startActivity(intent);

            }
        });

        b = this.view.findViewById(R.id.bgtButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BudgetActivity.setObjective(objective);
                Intent intent = new Intent(view, BudgetActivity.class);
                view.startActivity(intent);

            }
        });
        b = this.view.findViewById(R.id.backButton1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(view, MainActivity.class);
                view.startActivity(intent);

            }
        });
    }
}
