package smallprojects.ToDo;


import java.time.LocalTime;

public class ToDoUser {
    public static void main(String[] args) {
        ToDo myTodo = new ToDoImpl();
        System.out.println("calling add task \n");
        myTodo.addTask("Push the chnage to github", LocalTime.now());
         System.out.println("\ncalling displayTasks \n");
        myTodo.displayTasks();
         System.out.println("calling edittask \n");
        myTodo.editTask("Push the chnage to github","Push the changes to Github repo");
         System.out.println("calling marktask \n");
        myTodo.markTaskAsCompleted("Push the chnage to github");
         System.out.println("calling marktask 2 \n");
        myTodo.markTaskAsCompleted("Push the changes to Github repo");
         System.out.println("calling remove \n");
        myTodo.removeTask("Push the changes to Github repo");
         System.out.println("calling displayTasks \n");
        myTodo.displayTasks();
    }
}
