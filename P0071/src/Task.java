/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Strongest
 */
class Task {
    int id;
    private static int autoIncrease = 1;
    String RequirementName;
    int TaskTypeID;
    String Date;
    double from;
    double to;
    String Assignee;
    String Reviewer;
    double time;

    public Task() {
    }

    public Task(String RequirementName, int TaskTypeID, String Date, double from, double to, String Assignee, String Reviewer) {
        this.id = autoIncrease++;
        this.RequirementName = RequirementName;
        this.TaskTypeID = TaskTypeID;
        this.Date = Date;
        this.from = from;
        this.to = to;
        this.Assignee = Assignee;
        this.Reviewer = Reviewer;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return RequirementName;
    }

    public void setName(String Name) {
        this.RequirementName = RequirementName;
    }

    public int getTaskTypeID() {
        return TaskTypeID;
    }

    public void setTaskTypeID(int TaskTypeID) {
        this.TaskTypeID = TaskTypeID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public String getAssignee() {
        return Assignee;
    }

    public void setAssignee(String Assignee) {
        this.Assignee = Assignee;
    }

    public String getReviewer() {
        return Reviewer;
    }

    public void setReviewer(String Reviewer) {
        this.Reviewer = Reviewer;
    }

    public double getTime() {
        return to - from;
    }
    public String getTaskName() {
        String taskName = null;
        switch (TaskTypeID) {
            case 1:
                taskName = "Code";
                break;
            case 2:
                taskName = "Test";
                break;
            case 3:
                taskName = "Design";
                break;
            case 4:
                taskName = "Review";
                break;
        }
        return taskName;
    }    
    public String toString() {
        return String.format("%-5s %-15s %-15s %-15s %-10s %-15s %-15s", getId(), 
                getName(),getTaskName(), getDate(),getTime(), getAssignee(),
                getReviewer());
    }    
}
