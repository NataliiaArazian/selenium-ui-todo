package todo;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompleteTodoTest extends BaseTest{

    @Test
    public void shouldMarkTodoItemAsCompleted() throws NoSuchElementException {
        todo.create("Read Book");
        todo.markCompleted("Read Book");

        Assert.assertTrue(todo.count().getText().contains("0 items left"));
        Assert.assertTrue(todo.list.stream().allMatch(el -> el.getAttribute("class").contains("completed")));
    }

}
