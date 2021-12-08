package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.ProductDetailsPage;
import pages.YourStorePage;

public class YourStorePageStepdefs {
    YourStorePage yourStorePage = new YourStorePage();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    @Given("Your Store Page is opened")
    public void yourStorePageIsOpened() {
        yourStorePage.clickYourStorePage();
    }

    @Then("The carousel is displayed")
    public void theCarouselIsDisplayed() {
        Assertions.assertThat(yourStorePage.isProductCarouselDisplayed()).as("Carousel is not displayed").isEqualTo(true);
    }


    @When("The user clicks add to cart of first product")
    public void theUserClicksAddToCartOfFirstProduct() throws InterruptedException {
        yourStorePage.addToCartFirst();
//        Thread.sleep(3000);
    }

    @And("The user clicks add to cart of second product")
    public void theUserClicksAddToCartOfSecondProduct() throws InterruptedException {
        yourStorePage.addToCartSecond();
//        Thread.sleep(3000);
    }

    @Then("Two items are indicated on the minicart button")
    public void twoItemsAreIndicatedOnTheMinicartButton() {
        int qty = yourStorePage.getCartQty();
        Assertions.assertThat(qty).isEqualTo(2);
    }

    @And("Sum of first and second products are indicated on the minicart button")
    public void sumOfFirstAndSecondProductsAreIndicatedOnTheMinicartButton() {
        Assertions.assertThat(yourStorePage.getCartTotal()).isEqualTo(yourStorePage.getPriceOfFirst() + yourStorePage.getPriceOfSecond());
    }

    @And("First product is in the minicart")
    public void firstProductIsInTheMinicart() {
        Assertions.assertThat(yourStorePage.isFirstProductVisibleInMinicart()).isEqualTo(true);
    }

    @And("Second product is in the minicart")
    public void secondProductIsInTheMinicart() {
        Assertions.assertThat(yourStorePage.isSecondProductVisibleInMinicart()).isEqualTo(true);
    }

    @And("The user opens minicart")
    public void theUserOpensMinicart() {
        yourStorePage.clickOnMinicartButton();
    }

    @When("The user clicks add to wishlist for the Third product")
    public void theUserClicksAddToWishlistForTheThirdProduct() throws InterruptedException {
        yourStorePage.addToWishlistThird();
        Thread.sleep(2000);
    }

    @And("The user clicks add to wishlist for the Forth product")
    public void theUserClicksAddToWishlistForTheForthProduct() throws InterruptedException {
        yourStorePage.addToWishlistForth();
        Thread.sleep(2000);
    }

    @Then("Successful add to wishlist message is displayed")
    public void successfulAddToWishlistMessageIsDisplayed() throws InterruptedException {
        Assertions.assertThat(yourStorePage.isWishlistMessageShown()).isEqualTo(true);
        Thread.sleep(2000);
    }

    @And("{int} products are indicated in a Wishlist at the Header")
    public void productsAreIndicatedInAWishlistAtTheHeader(int quantity) throws InterruptedException {
        Assertions.assertThat(yourStorePage.getHeaderComponent().WishlistButtonIndicator()).isEqualTo(quantity);
        Thread.sleep(2000);
    }

    @When("The user clicks compare of the fisrt product")
    public void theUserClicksCompareOfTheFisrtProduct() throws InterruptedException {
        yourStorePage.compareFirst();
        Thread.sleep(3000);
    }

    @Then("First product was added to comparison")
    public void firstProductWasAddedToComparison() {
        Assertions.assertThat(yourStorePage.getCompareMessage().contains(yourStorePage.getProductTitleFirst())).isEqualTo(true);
    }

    @When("The user clicks compare of the second product")
    public void theUserClicksCompareOfTheSecondProduct() throws InterruptedException {
        yourStorePage.compareSecond();
        Thread.sleep(3000);
    }

    @Then("Second product was added to comparison")
    public void secondProductWasAddedToComparison() {
        Assertions.assertThat(yourStorePage.getCompareMessage().contains(yourStorePage.getProductTitleSecond())).isEqualTo(true);
    }

    @When("The user clicks on the first product title")
    public void theUserClicksOnTheFirstProductTitle() {
        yourStorePage.clickOnTitleFirst();
    }

    @Then("The first product PDP is opened")
    public void theFirstProductPDPIsOpened() {
        Assertions.assertThat(productDetailsPage.isProductDetailsPageOpened()).isEqualTo(true);

    }
}
