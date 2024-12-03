package edu.utsa.cs3443.projectplanner.model;

import java.util.List;

public class BudgetItem {
    private String category;
    private String name;
    private double cost;
    private List<String> extraFields; // Additional fields beyond mandatory ones

    public BudgetItem(String name, double cost) {

        this.name = name;
        this.cost = cost;

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<String> getExtraFields() {
        return extraFields;
    }

    public void setExtraFields(List<String> extraFields) {
        this.extraFields = extraFields;
    }
}
