package todo;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckTodoCategoriesTest extends BaseTest{

    @Test
    public void shouldReturnAllTodoCategories() throws NoSuchElementException {
        todo.create("Read Book");
        todo.create("Do your homework");
        todo.markCompleted("Read Book");

        Assert.assertEquals(todo.list.size(), 2);
    }

    @Test
    public void shouldReturnActiveTodoCategories() throws NoSuchElementException {
        todo.create("Read Book");
        todo.create("Do your homework");
        todo.markCompleted("Read Book");
        todo.selectActiveTodos();

        Assert.assertEquals(todo.list.size(), 1);
        Assert.assertTrue(todo.list.get(0).getText().contains("Do your homework"));
    }

    @Test
    public void shouldReturnCompleteTodoCategories() throws NoSuchElementException {
        todo.create("Read Book");
        todo.create("Do your homework");
        todo.markCompleted("Read Book");
        todo.selectCompletedTodos();

        Assert.assertEquals(todo.list.size(), 1);
        Assert.assertTrue(todo.list.get(0).getText().contains("Read Book"));
    }
}
