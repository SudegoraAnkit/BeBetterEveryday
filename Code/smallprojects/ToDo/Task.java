package smallprojects.ToDo;

import java.sql.Time;
import java.time.LocalTime;

public class Task {
    private String taskName;
    private String taskStatus;
    private LocalTime taskTime;

    public Task(String taskName, String taskStatus, LocalTime taskTime) {
        this.taskName = taskName;
        this.taskStatus = taskStatus;
        this.taskTime = taskTime;
    }

    public String getTaskName(){
        return taskName;
    }

    public String getTaskStatus(){
        return taskStatus;
    }

    public Time getTaskTime(){
        return taskTime;
    }

    public void setTaskStatus(String status){
        this.taskStatus = status;
    }

    public void setTaskName(String taskName){
        this.taskName=taskName;
    }
}
