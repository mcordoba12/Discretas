package Model.Test;
import static org.junit.Assert.*;
import Model.DataStructure.HashTable;
import Model.DataStructure.Task;
import org.junit.Before;
import org.junit.Test;
public class HashTest {

    private HashTable<String, Task> hashTable;

    @Before
    public void setupStage1() {
        hashTable = new HashTable<>();
    }

    @Test
    public void testInsertAndSearch() {
        // Creamos objetos de tipo Tarea con claves no nulas
        Task task1 = new Task("1", "Tarea 1", "importante", "20/22/23", 8);
        Task tarea2 = new Task("2", "Tarea 4", " no importante", "20/21/23", 2);
        Task tarea3 = new Task("3", "Tarea 3", "importante", "20/12/23", 5);

        // Insertamos las tareas en la tabla hash
        hashTable.insert(task1.getId(), task1);
        hashTable.insert(tarea2.getId(), tarea2);
        hashTable.insert(tarea3.getId(), tarea3);

        // Verificamos que las tareas se puedan buscar correctamente
        assertEquals(task1, hashTable.search(task1.getId()));
        assertEquals(tarea2, hashTable.search(tarea2.getId()));
        assertEquals(tarea3, hashTable.search(tarea3.getId()));

        // Verificamos que una clave que no está presente devuelva null
        assertNull(hashTable.search("4")); // Key not present
    }


    @Test
    public void testDelete() {
        // Creamos objetos de tipo Tarea
        Task tarea1 = new Task("1", "Tarea 1", "importante", "20/22/23",8);
        Task tarea2 = new Task("12", "Tarea 4", " no importante", "20/21/23",2);
        Task tarea3 = new Task("13", "Tarea 3", "importante", "20/12/23",5);

        // Insertamos las tareas en la tabla hash
        hashTable.insert(tarea1.getId(), tarea1);
        hashTable.insert(tarea2.getId(), tarea2);
        hashTable.insert(tarea3.getId(), tarea3);

        // Eliminamos una tarea por su clave
        hashTable.delete(tarea2.getId());

        // Verificamos que la eliminación se realizó correctamente
        assertEquals(tarea1, hashTable.search(tarea1.getId()));
        assertNull(hashTable.search(tarea2.getId())); // Deleted key
        assertEquals(tarea3, hashTable.search(tarea3.getId()));
    }
}


