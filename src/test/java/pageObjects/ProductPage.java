package pageObjects;

import helpers.CategoriesSubCategoriesAndProducts;
import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;
import java.util.List;

import static helpers.Driver.waitForElementPresent;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductPage {
    public String pageURL;
    protected WebDriver driver;
    protected CategoriesSubCategoriesAndProducts categoriesSubCategoriesAndProducts = new CategoriesSubCategoriesAndProducts();

    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement name;
    @FindBy(how = How.CSS, using = ".thumbnails img")
    private WebElement image;
    @FindBy(how = How.CSS, using = ".col-sm-4 h2")
    private WebElement price;
    @FindBy(how = How.XPATH, using = "//*[@class=\"nav nav-tabs\"]//a[text()=\"Specification\"]")
    private WebElement specificationTab;
    @FindBy(how = How.XPATH, using = "//*[@class=\"nav nav-tabs\"]//a[contains(text(),\"Reviews\")]")
    private WebElement reviewTab;
    @FindBy(how = How.ID, using = "input-name")
    private WebElement reviewName;
    @FindBy(how = How.ID, using = "input-review")
    private WebElement reviewText;
    @FindBy(how = How.CSS, using = "[name=rating]")
    private List<WebElement> reviewScore;
    @FindBy(how = How.ID, using = "button-review")
    private WebElement reviewSubmit;
    @FindBy(how = How.CLASS_NAME, using = "alert-success")
    private WebElement successMessage;
    @FindBy(how = How.XPATH, using = "//*[@class=\"fa fa-exchange\"]/..")
    private WebElement compare;
    @FindBy(how = How.ID, using = "button-cart")
    private WebElement addToCard;

    public ProductPage() throws Exception {
        pageURL = System.getProperty("baseUrl") + "/index.php?route=product/product";
    }

    public void setDriver(WebDriver driverValue) {
        driver = driverValue;
    }

    @Step("Open browse page for product {0}")
    public void openProductPage(@NotNull String product) throws IOException {
        driver.get(pageURL + "&product_id=" + categoriesSubCategoriesAndProducts.getProductValue(product));
    }

    @Step("Open browse page for product {0} in category {1}")
    public void openProductPageInCategory(@NotNull String product, @NotNull String aCategory) throws IOException {
        driver.get(pageURL + "&path=" + categoriesSubCategoriesAndProducts.getCategoryValue(aCategory) + "&product_id=" + categoriesSubCategoriesAndProducts.getProductValue(product));
    }

    @Step("Open browse page product {0} in category {1} with sub-category {2}")
    public void openProductPageInCategoryWithSubCategory(@NotNull String product, @NotNull String aSubCategory, @NotNull String aCategory) throws IOException {
        driver.get(pageURL + "&path=" + categoriesSubCategoriesAndProducts.getCategoryValue(aCategory) + "_" + categoriesSubCategoriesAndProducts.getSubCategoryValue(aSubCategory) + "&product_id=" + categoriesSubCategoriesAndProducts.getProductValue(product));
    }

    @Step("Add a product to the card")
    public void addProductToTheCard() throws IOException {
        addToCard.click();
    }

    @Step("Write review for product")
    public void writeReviewForProduct(@NotNull String name, @NotNull String comment, int score) throws IOException {
        reviewTab.click();
        reviewName.clear();
        reviewName.sendKeys(name);
        reviewText.clear();
        reviewText.sendKeys(comment);
        reviewScore.get(score - 1).click();
        reviewSubmit.click();
    }

    @Step("Check success review message")
    public void checkSuccessReviewMessage() {
        waitForElementPresent(successMessage);
        assertThat(successMessage.getText()).isEqualToIgnoringCase("Thank you for your review. It has been submitted to the webmaster for approval.");
    }

    @Step("Click to compare")
    public void clickOnCompare() {
        compare.click();
    }

    @Step("Check success comparison message for product {0}")
    public void checkSuccessComparisonMessage(@NotNull String product) {
        waitForElementPresent(successMessage);
        assertThat(successMessage.getText()).startsWith("Success: You have added " + product + " to your product comparison!");
    }

    @Step("User can see product name {0}, price {1}, image and specification")
    public void userCanSeeProductNamePriceImageAndSpecification(@NotNull String productName, @NotNull String productPrice) {
        assertThat(name.isDisplayed()).isTrue();
        assertThat(price.isDisplayed()).isTrue();
        assertThat(image.isDisplayed()).isTrue();
        assertThat(specificationTab.isDisplayed()).isTrue();
        assertThat(reviewTab.isDisplayed()).isTrue();
        assertThat(addToCard.isDisplayed()).isTrue();
        assertThat(name.getText()).isEqualTo(productName);
        assertThat(price.getText()).startsWith(productPrice);
    }
}
