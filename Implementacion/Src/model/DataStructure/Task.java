package Model.DataStructure;

import Model.DataStructure.Agenda;

public class Task extends Agenda {
    private boolean completed;

    public Task(String id, String name, String description, String dateLimit, int priority) {
        super(id, name, description, dateLimit, priority);
        completed = false;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
