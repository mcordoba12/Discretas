package Model.DataStructure;

public class UserAction {
    private UserActionType action;
    private Agenda taskDetails;


    public UserAction(UserActionType action, Agenda taskDetails) {
        this.action = action;
        this.taskDetails = taskDetails;
    }

    public UserActionType getAction() {
        return action;
    }

    public void setAction(UserActionType action) {
        this.action = action;
    }

    public Agenda getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(Agenda taskDetails) {
        this.taskDetails = taskDetails;
    }




}
