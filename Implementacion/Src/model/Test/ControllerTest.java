package model.Test;

import model.Central.Controller;
import model.DataStructure.Stack;
import model.Objects.Agenda;
import model.Objects.Task;
import model.Objects.UserAction;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
    private Controller controller;
    private Date date1;
    private Date date2;
    private Date date3;

    @Before
    public void setUp() {

        controller = new Controller();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date1 = dateFormat.parse("2023-10-15");
            date2 = dateFormat.parse("2023-10-20");
            date3 = dateFormat.parse("2023-10-10");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUndoneAddAction() {
        // Agregar una tarea
        String result = controller.addTask("1", "Tarea 1", "Descripción 1", "2023-10-10", 1);

        // Deshacer la acción de agregar
        controller.undone();

        // Verificar que la tarea se eliminó
        assertNull(controller.search("1"));
    }

    @Test
    public void testUndoneDeleteAction() {
        // Agregar una tarea
        controller.addTask("1", "Tarea 1", "Descripción 1", "2023-10-10", 1);

        // Eliminar la tarea
        String result = controller.deleteTask("1");

        // Deshacer la acción de eliminar
        controller.undone();

        // Verificar que la tarea se volvió a agregar
        assertNotNull(controller.search("1"));
    }


    @Test
    public void testUserActionAdd() {
        // Crear una tarea
        Task task = new Task("1", "Tarea 1", "Descripción 1", date1, 1);

        // Agregar la tarea utilizando el método addTask
        String result = controller.addTask("1", "Tarea 1", "Descripción 1", "2023-10-10", 1);

        // Llamar a userAction para agregar la tarea
        controller.userAction(0, task);

        // Verificar que la tarea se agregó a la agenda
        Agenda agenda = controller.search("1");
        assertEquals("Tarea 1", agenda.getName());
    }


    @Test
    public void testUserActionDelete() {
        // Crear una tarea
        Task task = new Task("1", "Tarea 1", "Descripción 1", date1, 1);

        // Agregar la tarea
        controller.addTask("1", "Tarea 1", "Descripción 1", "2023-10-10", 1);

        // Llamar a userAction para eliminar la tarea
        controller.userAction(1, task);

        // Verificar que la tarea se eliminó de la agenda
        Agenda agenda = controller.search("1");
        assertEquals("Tarea 1", agenda.getName());
    }

    @Test
    public void testUserActionModify() {
        // Crear una tarea
        Task task = new Task("1", "Tarea 1", "Descripción 1", date3, 1);

        // Agregar la tarea
        controller.addTask("1", "Tarea 1", "Descripción 1", "2023-10-10", 1);

        // Llamar a userAction para modificar la tarea
        controller.userAction(2, task);

        // Verificar que la tarea se modificó correctamente
        Agenda agenda = controller.search("1");
        assertEquals("Tarea 1", agenda.getName());
    }


}
