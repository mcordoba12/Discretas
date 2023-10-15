package model.Objects;

import java.util.Date;

public class Agenda {
    private String id;
    private String name;
    private String description;
    private Date dateLimit;
    private int priority;


    public Agenda(String id, String name, String description, Date dateLimit, int priority) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateLimit = dateLimit;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateLimit() {
        return dateLimit;
    }

    public void setDateLimit(Date dateLimit) {
        this.dateLimit = dateLimit;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
