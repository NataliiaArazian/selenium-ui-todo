package todo;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateTodoTest extends BaseTest {

    @Test
    public void createTodo() {
        todo.create("Read Book");

        Assert.assertEquals(1, todo.list.size());
        Assert.assertTrue(todo.list.get(0).getText().contains("Read Book"));
        Assert.assertTrue(todo.count().getText().contains("1 item left"));
    }
}
