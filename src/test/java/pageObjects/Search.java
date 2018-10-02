package pageObjects;

import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Search {
    public String pageURL;
    protected WebDriver driver;

    @FindBy(how = How.NAME, using = "search")
    private WebElement searchBar;
    @FindBy(how = How.CLASS_NAME, using = "btn-default")
    private WebElement searchButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"description\"]")
    private WebElement descriptionCheckBox;
    @FindBy(how = How.CLASS_NAME, using = "product-grid")
    private WebElement productGrid;
    @FindBy(how = How.CLASS_NAME, using = "btn-primary")
    private WebElement primarySearchButton;
    @FindBy(how = How.ID, using = "input-search")
    private WebElement criteriaSearchBox;


    public Search() throws Exception {
        pageURL = System.getProperty("baseUrl");
    }


    public void setDriver(WebDriver driverValue) {
        driver = driverValue;
    }

    @Step("Open homepage")
    public void openHomePage() throws IOException {
        driver.get(pageURL);
    }

    @Step("Navigate to page with base url + extension: {0}")
    public void navigateTo(String URL) throws IOException {
        driver.navigate().to(pageURL + URL);
    }

    @Step("Search this: {0}")
    public void searchInformation(@NotNull String searchInput) throws InterruptedException {
        searchBar.clear();
        searchBar.sendKeys(searchInput);
        searchButton.click();
    }

    @Step("Search this: {0} in Search Criteria section")
    public void searchInformationInCriteriaSection(String searchedInformation) {
        criteriaSearchBox.clear();
        criteriaSearchBox.sendKeys(searchedInformation);
        primarySearchButton.click();
    }

    @Step("Validate search results text: {0}")
    public void validateSearchResults(@NotNull String searchedString) {
        String firstSearchResult = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4/a")).getText();
        assertThat(firstSearchResult.contains(searchedString));
    }

    @Step("Click checkbox to search product descriptions")
    public void clickCheckBoxToSearchProductDescriptions() {
        descriptionCheckBox.click();
    }

    @Step("Verify search bar is displayed")
    public void validateSearchBarIsDisplayed() {
        assert searchBar.isDisplayed();
    }

    @Step("Product description contains searched string: {0}")
    public void productDescriptionContainsSearchedString(@NotNull String searchedString) {
        assertThat(productGrid.getText().contains(searchedString));
    }


}
