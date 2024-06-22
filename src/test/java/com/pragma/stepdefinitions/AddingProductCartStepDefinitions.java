package com.pragma.stepdefinitions;

import com.pragma.interactions.DeleteProductAction;
import com.pragma.questions.ValidateNameProducts;
import com.pragma.questions.ValidatePriceProduct;
import com.pragma.questions.ValidateQuantity;
import com.pragma.tasks.AddOneProductTask;
import com.pragma.tasks.AddingMultipleProducts;
import com.pragma.tasks.DeleteProductTask;
import com.pragma.userinterfaces.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AddingProductCartStepDefinitions {

    @Given("I am on the homepage")
    public void iAamOnTheHomepage() {
        theActorInTheSpotlight().wasAbleTo(
                Open.browserOn().the(HomePage.class)
        );
    }

    @When("I add a {string} to the cart {string}")
    public void iAddAToTheCart(String product, String quantity) {
        theActorInTheSpotlight().attemptsTo(
                AddOneProductTask.withData(product, Integer.parseInt(quantity))
        );
    }

    @When("I add {string} times the same {string} to the cart")
    public void iAddSeveralTimesTheSameToTheCart(String quantity, String product) {
        theActorInTheSpotlight().attemptsTo(
                AddOneProductTask.withData(product, Integer.parseInt(quantity))
        );
    }

    @When("I add multiple products to the cart")
    public void iAddMultipleProductsToTheCart(List<Map<String, String>> products) {
        theActorInTheSpotlight().attemptsTo(
                AddingMultipleProducts.withData(products)
        );
    }

    @When("I remove the products in the cart")
    public void iRemoveTheProductsInTheCart() {
        theActorInTheSpotlight().attemptsTo(
                DeleteProductAction.withTheData()
        );
    }


    @Then("I should see the {string} in the cart")
    public void iShouldSeeTheProductInTheCart(String product) {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(ValidateNameProducts.verify(product))
        );

    }

    @Then("the {string} should be displayed {string} times in the cart")
    public void theProductShouldBeDisplayedManyTimesInTheCart(String product, String quantity) {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(ValidateQuantity.verify(product, Integer.parseInt(quantity)))
        );
    }

    @Then("I should see the products in the cart")
    public void iShouldSeeTheProductsInTheCart() {
        List<Map<String, String>> products = theActorInTheSpotlight().recall("listTable");

        for (Map<String, String> product : products) {
            String productName = product.get("product");
            int quantity = Integer.parseInt(product.get("quantity"));

            theActorInTheSpotlight().should(
                    GivenWhenThen.seeThat(ValidateQuantity.verify(productName, quantity)),
                    GivenWhenThen.seeThat(ValidateNameProducts.verify(productName))
            );
        }

    }

    @Then("I should not see the products in the cart")
    public void iShouldNotSeeTheProductsInTheCart() {
        theActorInTheSpotlight().attemptsTo(
                DeleteProductTask.withData()
        );
    }

    @Then("I should see the respective {string} of the {string} in the cart")
    public void iShouldSeeTheRespectivePriceOfTheProductInTheCart(String price, String product) {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(ValidatePriceProduct.verify(price, product))
        );

    }

    @Then("I should see the sum of the total price of the products in the cart")
    public void iShouldSeeTheSumOfTheTotalPriceOfTheProductsInTheCart() {

    }


}
