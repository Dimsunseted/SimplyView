package edu.utsa.cs3443.projectplanner.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.utsa.cs3443.projectplanner.R;
import edu.utsa.cs3443.projectplanner.model.BudgetItem;

public class BudgetAdapter extends RecyclerView.Adapter<BudgetAdapter.BudgetViewHolder> {

    private final List<BudgetItem> budgetItems;

    public BudgetAdapter(List<BudgetItem> budgetItems) {
        this.budgetItems = budgetItems;
    }

    @NonNull
    @Override
    public BudgetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                                   .inflate(R.layout.budget_item, parent, false);
        return new BudgetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BudgetViewHolder holder, int position) {
        BudgetItem item = budgetItems.get(position);

        holder.categoryTextView.setText(item.getCategory());
        holder.nameTextView.setText(item.getName());
        holder.costTextView.setText(String.format("$%.2f", item.getCost()));

        // Display extra fields as a single string
        String extras = String.join(", ", item.getExtraFields());
        holder.extrasTextView.setText(extras.isEmpty() ? "No additional info" : extras);
    }

    @Override
    public int getItemCount() {
        return budgetItems.size();
    }

    static class BudgetViewHolder extends RecyclerView.ViewHolder {
        private final TextView categoryTextView;
        private final TextView nameTextView;
        private final TextView costTextView;
        private final TextView extrasTextView;

        public BudgetViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTextView = itemView.findViewById(R.id.budget_item_category);
            nameTextView = itemView.findViewById(R.id.budget_item_name);
            costTextView = itemView.findViewById(R.id.budget_item_cost);
            extrasTextView = itemView.findViewById(R.id.budget_item_extras);
        }
    }
}
