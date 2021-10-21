import org.openqa.selenium.*;

import java.util.List;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class HomePage {
    WebDriver driver;
    String selectedPrice=null;


    public HomePage(WebDriver driver) {
    this.driver = driver;
    }

    public boolean isOnHomePage() {
        return driver.findElement(By.className("header-text-bold-span")).isDisplayed();
    }

    public void search(String input) {
        driver.findElement(By.id("search_input")).clear();
        driver.findElement(By.id("search_input")).sendKeys(input+ Keys.ENTER);


    }

    public void scrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void clickMore() {
        driver.findElement(By.className("lazy-load-button")).click();
        
    }


    public void selectProduct(int i) {
        driver.findElements(By.className("a_model_item")).get(i).click();
    }

    public void addToCart() {
        List<WebElement> sizes = driver.findElement(By.id("option-size")).findElements(By.xpath("./child::*"));
        WebElement selectedSize = null;
        for (WebElement size: sizes) {
            if (size.getAttribute("data-stock") != "0") {
                selectedSize = size;
            }
        }
        selectedSize.click();
        driver.findElement(By.id("pd_add_to_cart")).click();
        selectedPrice = driver.findElement(By.xpath("//span[@class='price']")).getText();
    }

    public void goToCart() {
        driver.findElement(By.className("header-cart")).click();
    }

    public String getCartPrice() {
        return driver.findElement(By.xpath("//span[@class='rd-cart-item-price mb-15']")).getText();
    }

    public void increaseProduct() {
        driver.findElement(By.xpath("//a[@class='oq-up plus']")).click();
    }

    public String getProductQuantity() {
        return driver.findElement(By.xpath("//input[@class='item-quantity-input ignored']")).getAttribute("value");
    }

    public void emptyProduct() {
        driver.findElement(By.xpath("//a[@class='cart-square-link']")).click();
        try {
                TimeUnit.SECONDS.sleep(2l);
        }catch(Exception e) {

        }
        driver.findElement(By.xpath("//a[@class='inverted-modal-button sc-delete ins-init-condition-tracking']")).click();

    }

    public boolean isEmptyCart() {
        return driver.findElement(By.xpath("//a[@class='homepage-link mt-20']")).isDisplayed();

    }
}
