package edu.utsa.cs3443.projectplanner;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.projectplanner.controller.ObjectController;
import edu.utsa.cs3443.projectplanner.model.Objective;

public class ObjectiveActivity extends AppCompatActivity {
    static Objective objective;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_objective);
        ObjectController controller= new ObjectController(this,objective);
    }
    public static void setObjective(Objective o){
        objective=o;
    }
}
