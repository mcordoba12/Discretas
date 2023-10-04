package Model.Objects;

public class Task extends Agenda {

    public Task(String id, String name, String description, String dateLimit, int priority) {
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
