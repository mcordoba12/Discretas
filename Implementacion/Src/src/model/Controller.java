package model;

public class Controller{
    private HashTable<String, Agenda> agenda;

    public Controller() {
        agenda = new HashTable<String, Agenda>(100);
    }

    public void addTask(String Id, String name, String description, String dateLimit, int priority) {
        Task task = new Task(Id, name, description, dateLimit, priority);
        agenda.insert(Id, task);

    }

    public void addReminder(String Id, String name, String description, String dateLimit, int priority) {
        Reminder reminder = new Reminder(Id, name, description, dateLimit, priority);
        agenda.insert(Id, reminder);
    }


}







