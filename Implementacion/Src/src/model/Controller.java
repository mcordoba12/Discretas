package model;

public class Controller{
    private HashTable<String, Agenda> agenda;

    public Controller() {
        agenda = new HashTable<String, Agenda>(100);
        
    }

    public void addTask(String Id, String name, String description, String dateLimit, int priority) {
        Task task = new Task(Id, name, description, dateLimit, priority);
        agenda.insert(Id, task);
        if (task.getPriority() == 0) {
            

            
        } else{

        }

    }

    public void addReminder(String Id, String name, String description, String dateLimit, int priority) {
        Reminder reminder = new Reminder(Id, name, description, dateLimit, priority);
        agenda.insert(Id, reminder);
         if (reminder.getPriority() == 0) {

            
        } else{
            
        }

    }

    public Agenda search(String Id) {
        return agenda.search(Id);
    }

    public String delete(String Id) {
        agenda.delete(Id);
        return "Se elimino correctamente";
    }

    public String modify(String modify, String Id, String m){
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







