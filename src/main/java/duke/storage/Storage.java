package duke.storage;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * <h1>Storage</h1>
 * The Storage class deals with loading tasks from the file and saving tasks in the file.
 * <p>
 *
 * @author  Tang Yinxuan (Sophie)
 * @version 1.0
 * @since   2023-03-03
 */
public class Storage {
    protected static String filepath;
    public Storage(String filepath) {
        this.filepath = filepath;
        System.out.println(filepath);
    }


    /**
     * This method loads the tasks to the data file specified by the filepath or
     * creates a new file if it does not already exist.
     *
     * @param Nothing
     * @return Nothing
     * @exception IOException On input error
     */
    public static void loadTasksToFile() throws IOException {
        // @@author tangphi-reused
        // Reused from www.w3schools.com/java/java_files_create.asp
        // with minor modifications

        try {
            File file = new File(filepath);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            }
            Scanner reader = new Scanner(file);
            FileWriter myWriter = new FileWriter(filepath);
            while (reader.hasNextLine()){
                String line = reader.nextLine();
                myWriter.write(line);
            }
        } catch (IOException e) {
            System.out.println("An IO Exception error occurred");
            e.printStackTrace();
        }

    }

    /**
     * This method writes and saves the tasks in the given arraylist to the data file specified by the filepath.
     *
     * @param Arraylist of tasks
     * @return Nothing
     * @exception IOException On input error, ClassNotFoundException
     */
    public static void writeTasksToFile(ArrayList tasks) throws IOException, ClassNotFoundException {

        try {
            FileWriter myWriter = new FileWriter(filepath);

            for (int i = 0; i < tasks.size(); i++ ) {

                Task task = (Task) tasks.get(i);

                if (task instanceof Todo) {
                    myWriter.write(task.getDescription() + "\n");
                }
                else if (task instanceof Event) {
                    myWriter.write(task.getDescription() + "\n");
                }
                else if (task instanceof Deadline) {
                    myWriter.write(task.getDescription() + "\n");
                }
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An IO Exception error occurred");
            e.printStackTrace();
        }
    }
    // @@author
}
