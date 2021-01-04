package todo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClearCompleteTodoTest extends BaseTest {

    @Test
    public void shouldClearCompleteTodoItem() throws Exception {
        todo.create("Read Book");

        todo.markCompleted("Read Book");

        todo.clearCompleted();

        Assert.assertFalse(todo.isElementPresent(".count"));
        Assert.assertFalse(todo.isElementPresent(".main"));
        Assert.assertFalse(todo.isElementPresent(".footer"));

    }
}
