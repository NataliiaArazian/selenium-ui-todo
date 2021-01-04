package todo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckTodoCategoriesTest extends BaseTest{

    @Test
    public void shouldReturnAllTodoCategories() throws Exception {
        todo.create("Read Book");
        todo.create("Do your homework");
        todo.markCompleted("Read Book");

        Assert.assertEquals(todo.list.size(), 2);
    }

    @Test
    public void shouldReturnActiveTodoCategories() throws Exception {
        todo.create("Read Book");
        todo.create("Do your homework");
        todo.markCompleted("Read Book");
        todo.selectActiveTodos();

        Assert.assertEquals(todo.list.size(), 1);
        Assert.assertTrue(todo.getList().get(0).getText().contains("Do your homework"));
    }

    @Test
    public void shouldReturnCompleteTodoCategories() throws Exception {
        todo.create("Read Book");
        todo.create("Do your homework");
        todo.markCompleted("Read Book");
        todo.selectCompletedTodos();

        Assert.assertEquals(todo.list.size(), 1);
        Assert.assertTrue(todo.getList().get(0).getText().contains("Read Book"));
    }
}
