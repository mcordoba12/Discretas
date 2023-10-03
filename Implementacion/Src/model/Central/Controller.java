package Model.Central;
import Model.DataStructure.*;
import Model.DataStructure.DataStructureInterfaces.IPriorityQueue;


public class Controller {
    private HashTable<String, Agenda> agenda;
    private Queue <Agenda> queue;
    private IPriorityQueue<Integer, Task> priorityTasks  = new Heap<>();
    private Stack<UserAction> userActionsStack;

    public Controller() {
        agenda = new HashTable<String, Agenda>();
        queue = new Queue<>();
        userActionsStack = new Stack<>();
    }
    public String addTask(String Id, String name, String description, String dateLimit, int priority) {
        Task task = new Task(Id, name, description, dateLimit, priority);

        if (task.getPriority() == 0) {
            queue.add(task);
            agenda.insert(task.getId(),task);
        } else {
            priorityTasks.insert(task.getPriority(), task);
            agenda.insert(task.getId(),task);
        }
        userAction(0, task);
        return "Se agrego correctamente";
    }

    public String addReminder(String Id, String name, String description, String dateLimit, int priority) {
        Reminder reminder = new Reminder(Id, name, description, dateLimit, priority);
        agenda.insert(Id, reminder);
        return "Se agrego correctamente";
    }

    public Agenda search(String Id) {
        return agenda.search(Id);
    }


    public String deleteTask(String Id) {
        Task task = (Task) agenda.search(Id);
        agenda.delete(task.getId());
        if (task.getPriority() == 0) {
            queue.delete(task);
        } else {
            priorityTasks.delete(task);
        }
        userAction(1, task);
        return "Se elimino correctamente";
    }

    public String modify(String modify, String Id, String m) {
        Agenda agendaToModify = agenda.search(Id);
        Agenda copy = new Task(agendaToModify);
        switch (m) {
            case "name":
                agendaToModify.setName(modify);

                break;
            case "description":
                agendaToModify.setDescription(modify);

                break;
            case "dateLimit":
                agendaToModify.setDateLimit(modify);

                break;
            case "priority":
                agendaToModify.setPriority(Integer.parseInt(modify));
                break;

            default:
                break;
        }
        userAction(2, copy);
        return "Se modifico correctamente";
    }


    public void userAction(int action, Agenda agenda){
        UserAction userAction = new UserAction(UserActionType.values()[action], agenda);
        userActionsStack.push(userAction);
    }

    public void undone(){
        UserAction userAction = userActionsStack.pop();
        switch (userAction.getAction()){
            case ADD:
                deleteTask(userAction.getTaskDetails().getId());
                break;
            case DELETE:
                addTask(userAction.getTaskDetails().getId(), userAction.getTaskDetails().getName(), userAction.getTaskDetails().getDescription(), userAction.getTaskDetails().getDateLimit(), userAction.getTaskDetails().getPriority());
                break;
            case MODIFY:
                deleteTask(userAction.getTaskDetails().getId());
                addTask(userAction.getTaskDetails().getId(), userAction.getTaskDetails().getName(), userAction.getTaskDetails().getDescription(), userAction.getTaskDetails().getDateLimit(), userAction.getTaskDetails().getPriority());
                break;
        }


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
