package Model.DataStructure;

import Model.DataStructure.Agenda;

public class Task extends Agenda {
    private boolean completed;

    public Task(String id, String name, String description, String dateLimit, int priority) {
        super(id, name, description, dateLimit, priority);
        completed = false;
    }

    public Task(Agenda agenda) {
        super(agenda.getId(), agenda.getName(), agenda.getDescription(), agenda.getDateLimit(), agenda.getPriority());
        completed = false;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


    /***
     *
     * Ahora se compara ids, el tipo de clave es crucial.
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return this.getId().equals(obj);
    }


}
