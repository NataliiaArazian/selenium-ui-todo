package todo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectUnselectAllTodoTest extends BaseTest {

    @Test
    public void selectAllTodo() {
        todo.create("Read Book");
        todo.toggleAll();

        Assert.assertTrue(todo.count().getText().contains("0 items left"));
        Assert.assertTrue(todo.getList().stream().allMatch(el -> el.getAttribute("class").contains("completed")));
    }

    @Test
    public void unselectAllTodo() {
        todo.create("Read Book");
        todo.create("Do your homework");
        todo.toggleAll();
        todo.toggleAll();

        Assert.assertTrue(todo.count().getText().contains("2 items left"));
        Assert.assertTrue(todo.getList().stream().noneMatch(el -> el.getAttribute("class").contains("completed")));
    }
}
