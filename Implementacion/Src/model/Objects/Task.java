package model.Objects;

import java.util.Date;

public class Task extends Agenda {

    public Task(String id, String name, String description, Date dateLimit, int priority) {
        super(id, name, description, dateLimit, priority);
    }

    public Task(Agenda agenda) {
        super(agenda.getId(), agenda.getName(), agenda.getDescription(), agenda.getDateLimit(), agenda.getPriority());
    }

    public String toString(){
        return "Id: " + this.getId() + "\n" +
                "Name: " + this.getName() + "\n" +
                "Description: " + this.getDescription() + "\n" +
                "DateLimit: " + this.getDateLimit() + "\n" +
                "Priority: " + this.getPriority() + "\n";
    }


    /**
     * The function overrides the equals method to compare the ID of the current object with the ID of
     * the given object.
     *
     * @param obj The "obj" parameter is an object that is being compared to the current object for
     * equality.
     * @return The method is returning a boolean value.
     */
    @Override
    public boolean equals(Object obj) {
        return this.getId().equals(obj);
    }


}
