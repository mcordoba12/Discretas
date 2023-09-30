package Model.Central;
import Model.DataStructure.*;
import Model.DataStructure.DataStructureInterfaces.IPriorityQueue;


public class Controller {
    private HashTable<String, Agenda> agenda;
    private Queue <Agenda> queue;
    private IPriorityQueue<Integer, Task> priorityTasks  = new Heap<>();
    public Controller() {
        agenda = new HashTable<String, Agenda>();
        queue = new Queue<>();
    }
    public void addTask(String Id, String name, String description, String dateLimit, int priority) {
        Task task = new Task(Id, name, description, dateLimit, priority);

        if (task.getPriority() == 0) {
            queue.add(task);
            agenda.insert(task.getId(),task);
        } else {
            priorityTasks.insert(task.getPriority(), task);
            agenda.insert(task.getId(),task);
        }

    }

    public void addReminder(String Id, String name, String description, String dateLimit, int priority) {
        Reminder reminder = new Reminder(Id, name, description, dateLimit, priority);
        agenda.insert(Id, reminder);

    }

    public Agenda search(String Id) {
        return agenda.search(Id);
    }

    public String delete(String Id) {
        agenda.delete(Id);
        return "Se elimino correctamente";
    }

    public String modify(String modify, String Id, String m) {
        agenda.search(Id);
        switch (m) {
            case "name":
                agenda.search(Id).setName(modify);

                break;
            case "description":
                agenda.search(Id).setDescription(modify);

                break;
            case "dateLimit":
                agenda.search(Id).setDateLimit(modify);

                break;
            case "priority":
                agenda.search(Id).setPriority(Integer.parseInt(modify));

                break;

            default:
                break;
        }
        return "Se modifico correctamente";
    }

    public HashTable<String, Agenda> getAgenda() {
        return agenda;
    }

    public void setAgenda(HashTable<String, Agenda> agenda) {
        this.agenda = agenda;
    }

    public Queue<Agenda> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Agenda> queue) {
        this.queue = queue;
    }

    public IPriorityQueue<Integer, Task> getPriorityTasks() {
        return priorityTasks;
    }

    public void setPriorityTasks(IPriorityQueue<Integer, Task> priorityTasks) {
        this.priorityTasks = priorityTasks;
    }
}
