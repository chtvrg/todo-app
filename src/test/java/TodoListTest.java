import org.example.TodoList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

public class TodoListTest {
    @Test
    void addAndList() {
        TodoList t = new TodoList();
        t.add(" task1 ");
        assertEquals(1, t.size());
        assertEquals("task1", t.getAll().getFirst());
    }

    @Test
    void remove() {
        TodoList t = new TodoList();
        t.add("a");
        t.add("b");
        assertTrue(t.remove(0));
        assertEquals(1, t.size());
        assertFalse(t.remove(10));
    }

    @Test
    void addEmptyIgnored() {
        TodoList t = new TodoList();
        t.add(" ");
        assertEquals(0, t.size());
    }

    @Test
    void clear() {
        TodoList t = new TodoList();
        t.add("task1");
        t.add("task2");
        assertEquals(2, t.size());
        t.clear();
        assertEquals(0, t.size());
        assertTrue(t.getAll().isEmpty());
    }

    @Test
    void markDone() {
        TodoList t = new TodoList();
        t.add("task1");
        t.add("task2");
        assertTrue(t.markDone(0));
        assertFalse(t.markDone(10));
    }

    @Test
    void search() {
        TodoList t = new TodoList();
        t.add("Buy milk");
        t.add("Read book");
        t.add("Milk shake");
        List<String> results = t.search("milk");
        assertEquals(2, results.size());
        assertTrue(results.contains("Buy milk"));
        assertTrue(results.contains("Milk shake"));
    }
}