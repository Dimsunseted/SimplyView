package edu.utsa.cs3443.projectplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.utsa.cs3443.projectplanner.controller.BudgetController;
import edu.utsa.cs3443.projectplanner.model.Budget;
import edu.utsa.cs3443.projectplanner.model.BudgetItem;
import edu.utsa.cs3443.projectplanner.model.Objective;
import edu.utsa.cs3443.projectplanner.model.timeline;

public class BudgetActivity extends AppCompatActivity {
    static Objective o;
    public static void setObjective(Objective objective) {
        o=objective;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);



        // Load budget data from the file
        Budget budget = new Budget(o.getBudgetFile(), getAssets());
        ArrayList<BudgetItem> budgetItems = budget.getBudgetItems();
        //setup the buttons
        int i=0;
        for(BudgetItem t : budgetItems){
            i++;

            //assign text 1, assign due date, assign completion
            String id = "budgetItem"+Integer.toString(i);
            int resID = getResources().getIdentifier(id, "id", this.getPackageName());
            TextView title=this.findViewById(resID);
            title.setText(t.getName());

            id = "cost"+Integer.toString(i);
            resID = getResources().getIdentifier(id, "id", this.getPackageName());
            title=this.findViewById(resID);
            title.setText("$"+t.getCost());




        }
        TextView title=this.findViewById(R.id.totalCost);
        title.setText("$"+budget.getTotalBudget());
        BudgetController controller = new BudgetController(this);

    }
}
