package edu.utsa.cs3443.projectplanner.model;

import android.content.res.AssetManager;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Budget {

	private final String budgetFile;
	private final ArrayList<BudgetItem> budgetItem;

	public Budget(String budgetFile, AssetManager assetManager){
		this.budgetFile = budgetFile;
		this.budgetItem = new ArrayList<BudgetItem>();
		loadBudgetFromFile(assetManager);
	}

	private void loadBudgetFromFile (AssetManager assetManager){
		try{
			InputStream inputStream = assetManager.open(budgetFile);
			Scanner scanner = new Scanner(inputStream);

			while (scanner.hasNextLine()){
				String line = scanner.nextLine();
				String[] parts = line.split(",");

				//Ensure at least 3 fields (category, name, cost)
				BudgetItem i = new BudgetItem(parts[0],Double.parseDouble(parts[1]));
				this.budgetItem.add(i);
			}
				scanner.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//Get all budget items
	public ArrayList<BudgetItem> getBudgetItems() {
        	return budgetItem;
    	}

    	
	// Calculate the total cost of all budget items
	public double getTotalBudget() {
        	double total = 0.0;
       		for (BudgetItem item : budgetItem) {
            		total += item.getCost();
        	}
       		return total;
    	}

}