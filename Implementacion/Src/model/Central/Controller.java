package Model.Central;
import Model.DataStructure.*;
import Model.DataStructure.DataStructureInterfaces.IPriorityQueue;
import Model.Objects.*;


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

    /**
     * The addTask function adds a new task to a queue or priority queue based on its priority level.
     *
     * @param id The unique identifier for the task.
     * @param name The name parameter is a String that represents the name of the task.
     * @param description The "description" parameter is a String that represents the description of the
     * task. It provides additional details or information about the task.
     * @param dateLimit The "dateLimit" parameter is a string that represents the deadline or due date
     * for the task.
     * @param priority The priority parameter is an integer value representing the priority level of the
     * task. It is used to determine where the task should be inserted in the queue or priorityTasks data
     * structures.
     * @return The method is returning a string that says "Se agrego correctamente" followed by a new
     * line character and the string representation of the task that was added.
     */
    public String addTask(String id, String name, String description, String dateLimit, int priority) {
        Task task = new Task(id, name, description, dateLimit, priority);

        if (task.getPriority() == 0) {
            queue.add(task);
            agenda.insert(task.getId(),task);
        } else {
            priorityTasks.insert(task.getPriority(), task);
            agenda.insert(task.getId(),task);
        }
        userAction(0, task);
        return "Se agrego correctamente" + "\n" + task.toString();
    }

    /**
     * The function adds a reminder to an agenda and returns a success message.
     *
     * @param id The unique identifier for the reminder.
     * @param name The name of the reminder. It is a string value.
     * @param description The "description" parameter is a string that represents the description of the
     * reminder. It provides additional information or details about the reminder.
     * @param dateLimit The "dateLimit" parameter is a string that represents the deadline or due date for
     * the reminder. It could be in any format that is suitable for your application, such as "yyyy-MM-dd"
     * or "dd/MM/yyyy".
     * @param priority The priority parameter is an integer that represents the priority level of the
     * reminder. It is used to determine the importance or urgency of the reminder.
     * @return The method is returning the string "Se agrego correctamente"
     */
    public String addReminder(String id, String name, String description, String dateLimit, int priority) {
        Reminder reminder = new Reminder(id, name, description, dateLimit, priority);
        agenda.insert(id, reminder);
        userAction(0, reminder);
        return "Se agrego correctamente";
    }

    /**
     * The function searches for an Agenda object with a specific ID.
     *
     * @param id The id parameter is a string that represents the unique identifier of the agenda item that
     * you want to search for.
     * @return The method is returning an object of type "Agenda".
     */
    public Agenda search(String id) {
        return agenda.search(id);
    }

    /**
     * The deleteTask function deletes a task from the agenda, either from the queue or the priorityTasks
     * list, and returns a success message.
     *
     * @param id The id parameter is a String that represents the unique identifier of the task that needs
     * to be deleted.
     * @return The method is returning the string "Se elimino correctamente", which means "Successfully
     * deleted" in Spanish.
     */
    public String deleteTask(String id) {
        Task task = (Task) agenda.search(id);
        agenda.delete(task.getId());
        if (task.getPriority() == 0) {
            queue.delete(task);
        } else {
            priorityTasks.delete(task);
        }
        userAction(1, task);
        return "Se elimino correctamente";
    }

    /**
     * The function modifies a specific attribute of an Agenda object based on the given parameters and
     * returns a success message.
     *
     * @param modify The value that needs to be modified in the agenda (e.g., name, description,
     * dateLimit, priority).
     * @param id The id parameter is a String that represents the unique identifier of the agenda item
     * that needs to be modified.
     * @param m The parameter "m" is a string that represents the field to be modified in the agenda. It
     * can have the following values: "name", "description", "dateLimit", or "priority".
     * @return The method is returning a string that represents the modified agenda. The string includes
     * the modified agenda's details and a message indicating that the modification was successful.
     */
    public String modify(String modify, String id, String m) {
        Agenda agendaToModify = agenda.search(id);
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
        return  toString() + "Se modifico correctamente";
    }

    /**
     * The userAction function takes an action and an agenda, creates a UserAction object with the given
     * action and agenda, and pushes it onto a userActionsStack.
     *
     * @param action An integer representing the index of the desired UserActionType in the UserActionType
     * enum.
     * @param agenda An instance of the Agenda class, which represents a collection of tasks or events.
     */
    public void userAction(int action, Agenda agenda){
        UserAction userAction = new UserAction(UserActionType.values()[action], agenda);
        userActionsStack.push(userAction);
    }

    /**
     * The "undone" function undoes the last user action by either deleting a task, adding a task, or
     * modifying a task.
     *
     * @return The method is returning a String that represents the result of the undone action.
     */
    public String undone(){
        String undone = "";
        if (userActionsStack.isEmpty()) {
            return "No hay acciones para deshacer";
        }
        UserAction userAction = userActionsStack.pop();
        switch (userAction.getAction()){
            case ADD:
                deleteTask(userAction.getTaskDetails().getId());
                undone = "Se elimino la ultima accion";
                break;
            case DELETE:
                addTask(userAction.getTaskDetails().getId(), userAction.getTaskDetails().getName(), userAction.getTaskDetails().getDescription(), userAction.getTaskDetails().getDateLimit(), userAction.getTaskDetails().getPriority());
                undone = "Se agrego la ultima accion";
                break;
            case MODIFY:
                deleteTask(userAction.getTaskDetails().getId());
                addTask(userAction.getTaskDetails().getId(), userAction.getTaskDetails().getName(), userAction.getTaskDetails().getDescription(), userAction.getTaskDetails().getDateLimit(), userAction.getTaskDetails().getPriority());
                undone = "se deshizo la ultima accion";
                break;
        }
        return undone;

    }
    /**
     * The function "mostrarEstadoTareas" returns a string representation of the last user action
     * performed.
     *
     * @return The method is returning a string that represents the last action performed by the user.
     */
    public String mostrarEstadoTareas() {

        UserAction userAction = userActionsStack.peek();

        StringBuilder estadoTareas = new StringBuilder();

        if (userActionsStack.isEmpty()){
            estadoTareas.append("No hay acciones para deshacer");
        } else {
               estadoTareas.append(userAction.toString());
        }

        return "La ultima accion fue \n"+ estadoTareas.toString();
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
