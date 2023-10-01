package Model.DataStructure;

public class UserAction {
    private String action;
    private String taskDetails;

    public UserAction(String action, String taskDetails) {
        this.action = action;
        this.taskDetails = taskDetails;
    }

    public String getAction() {
        return action;
    }

    public String getTaskDetails() {
        return taskDetails;
    }
}
