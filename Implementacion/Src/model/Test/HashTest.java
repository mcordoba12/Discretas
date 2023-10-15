package model.Test;
import static org.junit.Assert.*;
import model.DataStructure.HashTable;
import model.Objects.Task;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HashTest {

    private HashTable<String, Task> hashTable;
    private Date date1;
    private Date date2;
    private Date date3;

    @Before
    public void setupStage1() {
        hashTable = new HashTable<>();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date1 = dateFormat.parse("20-22-23");
            date2 = dateFormat.parse("20-21-23");
            date3 = dateFormat.parse("20-12-23");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert() {
        // Creamos objetos de tipo Tarea con claves no nulas
        Task task1 = new Task("1", "Tarea 1", "importante", date1, 8);
        Task tarea2 = new Task("2", "Tarea 4", " no importante", date2, 2);
        Task tarea3 = new Task("3", "Tarea 3", "importante", date3, 5);
        Task tarea4 = new Task("10", "Tarea 3", "importante", date3, 5);
        Task tarea5 = new Task("5", "Tarea 3", "importante", date2, 5);


        // Insertamos las tareas en la tabla hash
        hashTable.insert(task1.getId(), task1);
        hashTable.insert(tarea2.getId(), tarea2);
        hashTable.insert(tarea3.getId(), tarea3);
        hashTable.insert(tarea4.getId(), tarea4);
        hashTable.insert(tarea5.getId(), tarea5);
    }


    @Test
    public void testSearch(){
        // Creamos objetos de tipo Tarea
        Task tarea1 = new Task("1", "Tarea 1", "importante", date3,8);
        Task tarea2 = new Task("12", "Tarea 4", " no importante", date2,2);
        Task tarea3 = new Task("13", "Tarea 3", "importante", date1,5);

        // Insertamos las tareas en la tabla hash
        hashTable.insert(tarea1.getId(), tarea1);
        hashTable.insert(tarea2.getId(), tarea2);
        hashTable.insert(tarea3.getId(), tarea3);

        // Verificamos que la búsqueda se realizó correctamente
        assertEquals(tarea1.getId(), hashTable.search(tarea1.getId()).getId());
        assertEquals(tarea2.getId(), hashTable.search(tarea2.getId()).getId());
        assertEquals(tarea3.getId(), hashTable.search(tarea3.getId()).getId());

        // Verificamos que una clave que no está presente devuelva null
        assertNull(hashTable.search("4")); // Key not present
    }

    @Test
    public void testDelete(){
        Task tarea1 = new Task("1", "Tarea 1", "importante", date3,8);
        Task tarea2 = new Task("12", "Tarea 4", " no importante", date2,2);
        Task tarea3 = new Task("13", "Tarea 3", "importante", date1,5);


        // Insertamos las tareas en la tabla hash
        hashTable.insert(tarea1.getId(), tarea1);
        hashTable.insert(tarea2.getId(), tarea2);
        hashTable.insert(tarea3.getId(), tarea3);

        // Eliminamos una tarea por su clave
        hashTable.delete(tarea2.getId());

        // Verificamos que la eliminación se realizó correctamente
        assertEquals("Tarea 1", hashTable.search(tarea1.getId()).getName());
        assertNull(hashTable.search(tarea2.getId())); // Deleted key
        assertEquals("Tarea 3", hashTable.search(tarea3.getId()).getName());
    }
}


