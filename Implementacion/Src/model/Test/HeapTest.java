package Model.Test;
import Model.DataStructure.DataStructureInterfaces.IPriorityQueue;
import Model.DataStructure.Heap;
import Model.Objects.Task;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class HeapTest {

    private IPriorityQueue<Integer, Task> priorityTasks;

    @Before
    public void setUp() {
        priorityTasks = new Heap<>();
    }

    @Test
    public void testInsertAndGetMaxPriority() {
        priorityTasks.insert(5, new Task("1", "Task 1", "Important task", "2023-10-15", 5));
        priorityTasks.insert(3, new Task("2", "Task 2", "Less important task", "2023-10-20", 3));
        priorityTasks.insert(7, new Task("3", "Task 3", "Very important task", "2023-10-10", 7));

        int maxPriority = priorityTasks.getmaX();

        assertEquals(7, maxPriority);
    }


    @Test
    public void testIncreaseKey() {
        Task task1 = new Task("1", "Task 1", "Important task", "2023-10-15", 5);
        Task task2 = new Task("2", "Task 2", "Less important task", "2023-10-20", 3);

        // Inserta las tareas en el montículo
        priorityTasks.insert(5, task1);
        priorityTasks.insert(3, task2);

        // Aumenta la prioridad de "Task 1" a 8
        priorityTasks.increaseKey(0, 8);

        // Obtiene la máxima prioridad después del aumento
        int maxPriority = priorityTasks.getmaX();

        // Verifica que la máxima prioridad sea 8
        assertEquals(8, maxPriority);
    }

    @Test
    public void testHeapExtractMax() {
        // Inserta tareas en el montículo
        priorityTasks.insert(5, new Task("1", "Task 1", "Important task", "2023-10-15", 5));
        priorityTasks.insert(3, new Task("2", "Task 2", "Less important task", "2023-10-20", 3));

        // Extrae la máxima prioridad
        int maxPriority = priorityTasks.heapExtractMax();

        // Verifica que la máxima prioridad sea 5 (el valor máximo en este caso)
        assertEquals(5, maxPriority);

        // También puedes verificar que el tamaño del montículo se haya reducido en uno
        assertEquals(1, priorityTasks.getHeapSize());
    }

    @Test
    public void testDelete(){
        // Inserta tareas en el montículo
        priorityTasks.insert(5, new Task("1", "Task 1", "Important task", "2023-10-15", 5));
        priorityTasks.insert(3, new Task("2", "Task 2", "Less important task", "2023-10-20", 3));
        priorityTasks.insert(7, new Task("3", "Task 3", "Very important task", "2023-10-10", 7));

        // Elimina la tarea con prioridad 7
        priorityTasks.delete(new Task("3", "Task 3", "Very important task", "2023-10-10", 7));

    }

}
