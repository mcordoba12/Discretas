package Model.Test;

import Model.Central.Controller;
import Model.DataStructure.Stack;
import Model.Objects.Agenda;
import Model.Objects.Task;
import Model.Objects.UserAction;
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
    public void testUndoneModifyAction() {
        // Agregar una tarea
        controller.addTask("1", "Tarea 1", "Descripción 1", "2023-10-10", 1);

        // Modificar la tarea
        String result = controller.modify("Tarea modificada", "1", "name");

        // Deshacer la acción de modificar
        controller.undone();

        // Verificar que la tarea volvió a su estado anterior
        Agenda agenda = controller.search("1");
        assertEquals("Tarea 1", agenda.getName());
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

    @Test
    public void testModifyTaskPriority() {
        // Crear una tarea inicial
        controller.addTask("1", "Tarea 1", "Descripción 1", "2023-10-10", 1);

        // Modificar la prioridad de la tarea
        String result = controller.modify("2", "1", "priority");

        // Verificar que la modificación fue exitosa
        assertEquals("Se modifico correctamente", result);

        // Buscar la tarea modificada
        Task modifiedTask = (Task) controller.search("1");

        // Verificar que la prioridad de la tarea se ha actualizado
        assertEquals(2, modifiedTask.getPriority());
    }
}
