package Model;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
public class Controller {
    private HashTable<String, Agenda> agenda;

    private PriorityQueue<Integer, Task> prioritizedTasks; // Usar la cola de prioridad para tareas prioritarias
    private Queue<Task> nonPrioritizedTasks; 

    public Controller() {
        agenda = new HashTable<String, Agenda>(100);

        nonPrioritizedTasks = new LinkedList<Task>();

    }

    public void addTask(String Id, String name, String description, String dateLimit, int priority) {
        Task task = new Task(Id, name, description, dateLimit, priority);
        if (task.getPriority() == 0) {
            // Si la tarea no tiene prioridad, agrégala a la cola FIFO (No prioritaria)
            nonPrioritizedTasks.offer(task);
        } else {
            // Si la tarea tiene prioridad, agrégala a la cola de prioridades (Prioritaria)
            prioritizedTasks.insert(priority, task);
    
            // Después de agregar una tarea prioritaria, aplicamos heapSort para mantenerlas ordenadas
            prioritizedTasks.heapSort();
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
}
