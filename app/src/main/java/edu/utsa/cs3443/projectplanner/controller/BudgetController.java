package edu.utsa.cs3443.projectplanner.controller;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import edu.utsa.cs3443.projectplanner.BudgetActivity;
import edu.utsa.cs3443.projectplanner.ObjectiveActivity;
import edu.utsa.cs3443.projectplanner.R;

public class BudgetController {
    BudgetActivity view;
    public BudgetController(BudgetActivity b){
        this.view=b;
        Button button = this.view.findViewById(R.id.backButtonbgt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(view, ObjectiveActivity.class);
                view.startActivity(intent);

            }
        });
    }
}
