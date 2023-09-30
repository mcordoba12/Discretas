<<<<<<< HEAD:Implementacion/Src/model/Task.java
package Model;
public class Task extends Agenda{
=======
package Model.DataStructure;

import Model.DataStructure.Agenda;

public class Task extends Agenda {
>>>>>>> 7e7908d3045be2a47d9654ac9acc6a241ab92b35:Implementacion/Src/model/DataStructure/Task.java
    private String completed;

    public Task(String id, String name, String description, String dateLimit, int priority) {
        super(id, name, description, dateLimit, priority);
        completed = "No";
    }


}
