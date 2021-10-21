import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class test1 extends basetest{

    @Test
    @Order(1)
    public void click_login(){
        driver.findElement(By.xpath("//a[@href='https://www.lcwaikiki.com/tr-TR/TR/giris']")).click();
        driver.findElement(By.id("LoginEmail")).sendKeys("meltemhtopcu@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("pantolon1");
        driver.findElement(By.id("loginLink")).click();

        Assertions.assertTrue(driver.findElement(By.className("dropdown-label")).getText().contentEquals("Hesabım"),
                "Did not log in!");
    }

    @Test
    @Order(2)
    public void search_a_product() {
        homepage.search("pantolon");
        homepage.scrollDown();
        homepage.clickMore();
    }

    @Test
    @Order(3)
    public void select_a_product(){
        homepage.selectProduct(1);

    }

    @Test
    @Order(4)
    public void add_a_product_to_cart(){
        homepage.addToCart();

    }

    @Test
    @Order(5)
    public void go_to_cart() {
        homepage.goToCart();

    }
    @Test
    @Order(6)
    public void check_product_price() {
        Assertions.assertTrue(homepage.selectedPrice==homepage.getCartPrice(),
                "prices are not same");

    }
    @Test
    @Order(7)
    public void increase_product_account() {
        homepage.increaseProduct();
        Assertions.assertTrue(homepage.getProductQuantity().contentEquals("2"),
                "did not increase quantity");

    }
    @Test
    @Order(8)
    public void empty_product() {
        homepage.emptyProduct();
        Assertions.assertTrue(homepage.isEmptyCart(),
                "did not empty cart");

    }

    }

