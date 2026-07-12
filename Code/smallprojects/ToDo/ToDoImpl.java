package smallprojects.ToDo;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ToDoImpl implements ToDo {
    private final List<Task> tasks = new ArrayList<>();

    @Override
    public void addTask(String taskname, LocalTime time) {
        if(taskname == null || taskname.isEmpty()){
            throw new RuntimeException("Invalid Input");
        }
        Task task = new Task(taskname, "ToDo", time);
        tasks.add(task);
        System.out.println("Task Added successfully.");
    }

    @Override
    public void removeTask(String taskname) {
        Optional<Task> task = tasks.stream().filter(tasks -> tasks.getTaskName().equals(taskname)).findFirst();
        if(task.isPresent()){
            tasks.remove(task.get());
            System.out.println("removed task "+ task.get().getTaskName());
            return;
        }
        System.out.println("No task found");
    }

    @Override
    public void markTaskAsCompleted(String taskname) {
        Optional<Task> task = tasks.stream().filter(tasks -> tasks.getTaskName().equals(taskname)).findFirst();
        if(task.isPresent()){
            task.get().setTaskStatus("Completed");

            System.out.println("updated status of task "+ task.get().getTaskName()+" to "+task.get().getTaskStatus());
            return;
        }
        System.out.println("No task found");
    }

    @Override
    public void displayTasks() {
        tasks.stream().forEach(
            task -> {
                String name = task.getTaskName();
                String status = task.getTaskStatus();
                String time = task.getTaskTime().toString();
                System.out.println("Task: "+name+" Status: "+status+" Time: "+time);
            }
        );
        return;
    }

    @Override
    public void editTask(String oldTaskname, String newTaskname) {
         Optional<Task> task = tasks.stream().filter(tasks -> tasks.getTaskName().equals(oldTaskname)).findFirst();
        if(task.isPresent()){
            task.get().setTaskName(newTaskname);
            System.out.println("updated name of task "+ oldTaskname+" to "+task.get().getTaskName());
            return;
        }
        System.out.println("No task found");
    }
    
}
