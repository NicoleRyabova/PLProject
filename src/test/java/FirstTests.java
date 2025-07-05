import com.appflowy.core.BaseClass;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class FirstTests extends BaseClass {
   @BeforeMethod
    public void beforeMethod(){
        Selenide.open(productPage.getAddress());

    }
    @Test//Ищем текст на главной странице сайта
    public void test() {
        $("h1").shouldHave(text("Bring projects, wikis, and teams together"));
        $("span.text-primary").shouldHave(text("with AI"));
        $x("//div[@class='desc']").shouldHave(text("The AI workspace where you achieve more without losing control of your data"));

    }
    @Test
    public void findNavigationItemsTest(){
       /*$x("//button[@class='navigation-item navigation-item-product']").should(exist);
       $x("//button[@class='navigation-item navigation-item-download']").should(exist);
       $x("//button[@class='navigation-item navigation-item-community']").should(exist);
       $x("//button[@class='navigation-item navigation-item-resources']").should(exist);
       $x("//button[@class='navigation-item navigation-item-pricing']").should(exist);*/
        productPage.productNavigationButton.click(); // кликаем по 1 кнопке
        webdriver().shouldHave(url(productPage.getAddress())); // проверяем ссылку
        //Нажимаем на кнопку Download
        productPage.downloadNavigationButton.click();
        webdriver().shouldHave(url(productPage.getNavigationBarLink(0))); // проверяем ссылку на "https://appflowy.com/download"

        // Проверяем, что появилось выпадающее меню
        productPage.downloadNavigationButton.hover();
       productPage.downloadPopoverMenu.shouldBe(Condition.visible);

        // Для кнопки iOS & Android
        productPage.downloadPopoverMenuElements.get(0)
                .shouldBe(visible)
                .shouldHave(exactText("iOS & Android")).click();
        webdriver().shouldHave(url(productPage.getNavigationBarLink(1))); // проверяем ссылку на  "https://appflowy.com/download#ios-and-android"

        // Для кнопки macOS & Windows & Linux
        productPage.downloadNavigationButton.hover();
        productPage.downloadPopoverMenuElements.get(1)
                .shouldBe(visible)
                .shouldHave(exactText("macOS & Windows & Linux")).click();
        webdriver().shouldHave(url(productPage.getNavigationBarLink(2))); // проверяем ссылку на  "https://appflowy.com/download#macOS"

        productPage.pricingNavigationButton.click();
        webdriver().shouldHave(url(productPage.getNavigationBarLink(3))); // проверяем ссылку на  "https://appflowy.com/pricing"
    }

    @Test
    public void findButtonsForStartForFreeTest(){
       $x("//button[@class='download-btn download-free-btn']").should(exist);
        $("button.bg-primary").shouldHave(text("Download now"));
        $("button.bg-white").shouldHave(exactText("Start for free"));
    }

    @Test
    public void authorizationTest(){
       loginPage.startForFreeNavigation.click();
        webdriver().shouldHave(url(loginPage.getRegistrationAddress()));

        for (int i = 0; i <= 3; i++) {
            loginPage.continueWithElement.get(i)
                    .shouldHave(text(loginPage.expectedTextsOnLoginPageStartingElements[i]));
            if (i == 3){
                loginPage.continueWithElement.get(i).click();
                for (int k = 0; k<= 4; k++){
                    loginPage.continueWithElement.get(k)
                            .shouldHave(text(loginPage.expectedTextsOnLoginPageAllElements[k]));
                }
            }
        }
    }

    @Test
    public void emptyEmailTest(){
        loginPage.startForFreeNavigation.click();
        webdriver().shouldHave(url(loginPage.getRegistrationAddress()));
        loginPage.continueWithElement.get(0).click();
        $x("//section[@aria-label='Notifications alt+T']").shouldBe(visible);
    }
}
