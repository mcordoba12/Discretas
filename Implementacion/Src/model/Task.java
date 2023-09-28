package Model;

public class Task extends Agenda{
    private String completed;

    public Task(String id, String name, String description, String dateLimit, int priority) {
        super(id, name, description, dateLimit, priority);
        completed = "No";
    }


}
