package todo;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Todo {

    public WebDriver driver;
    public Todo(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".new-todo")
    private WebElement newTodo;

    @FindBy(css = ".clear-completed")
    private WebElement clearCompleted;

    @FindBy(css = ".todo-list li")
    public List<WebElement> list;

    public void create(String title) {
        newTodo.sendKeys(title + Keys.ENTER);
    }

    public WebElement count(){
        return driver.findElement(By.cssSelector(".todo-count"));
    }

    public void markCompleted(String title) throws Exception {

        WebElement todoWithText = list.stream().filter(el -> el.getText().contains(title))
                .findFirst().orElseThrow(() -> new Exception("Element not found - " + title));
        WebElement parent = (WebElement) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].parentNode;", todoWithText);

        parent.findElement(By.cssSelector(".toggle")).click();
    }

    public void clearCompleted() {
        clearCompleted.click();
    }

    public boolean isElementPresent(String cssSelector) {
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            driver.findElement(By.cssSelector(cssSelector));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } finally{
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    public void toggleAll() {
        driver.findElement(By.cssSelector("#toggle-all+label")).click();
    }

    public  void selectActiveTodos() {
        driver.findElement(By.cssSelector("a[href*=\"active\"]")).click();
    }

    public  void selectCompletedTodos() {
        driver.findElement(By.cssSelector("a[href*=\"completed\"]")).click();
    }
}
