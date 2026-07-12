package smallprojects.ToDo;


import java.time.LocalTime;

public interface ToDo {
    void addTask(String task, LocalTime time);
    void removeTask(String task);
    void markTaskAsCompleted(String task);
    void displayTasks();
    void editTask(String oldTask, String newTask);
}