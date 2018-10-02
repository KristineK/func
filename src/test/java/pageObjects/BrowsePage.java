package pageObjects;

import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static helpers.CategoriesSubCategoriesAndProducts.getCategoryValue;
import static helpers.CategoriesSubCategoriesAndProducts.getSubCategoryValue;

public class BrowsePage {
    public String pageURL;
    protected WebDriver driver;

    public BrowsePage() throws Exception {
        pageURL = System.getProperty("baseUrl") + "/index.php?route=product/category&path=";
    }

    public void setDriver(WebDriver driverValue) {
        driver = driverValue;
    }

    @Step("Open browse page for category {0}")
    public void openBrowserPageForCategory(@NotNull String aCategory) throws IOException {
        driver.get(pageURL + getCategoryValue(aCategory));
    }

    @Step("Open browse page for sub-category {0} in category {1}")
    public void openBrowserPageForSubCategoryInCategory(@NotNull String aSubCategory, @NotNull String aCategory) throws IOException {
        driver.get(pageURL + getCategoryValue(aCategory) + "_" + getSubCategoryValue(aSubCategory));
    }
}
