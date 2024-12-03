package edu.utsa.cs3443.projectplanner.model;

public class timeline {
    private String eventName;
    private String dueDate;
    private String description;
    private boolean completion;

    timeline(String e, String due, String d, boolean c){
        this.eventName=e;
        this.dueDate=due;
        this.description=d;
        this.completion=c;

    }
    public String getName(){
        return this.eventName;
    }

    public String getDue() {
        return "Due: "+this.dueDate;
    }
    public String getC(){
        if(completion){
            return "Completed";
        }else{
            return "Not Completed";
        }
    }
}
