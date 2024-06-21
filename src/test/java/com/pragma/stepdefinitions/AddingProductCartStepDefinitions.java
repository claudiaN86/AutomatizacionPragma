package com.pragma.stepdefinitions;

import com.pragma.userinterfaces.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    @When("I add a {string} to the cart")
    public void iAddAToTheCart(String product) {

    }

    @When("I add several times the same {string} to the cart")
    public void iAddSeveralTimesTheSameToTheCart(String product) {

    }

    @When("I add multiple products to the cart")
    public void iAddMultipleProductsToTheCart(List<Map<String, String>> products) {
        for (Map<String, String> product : products) {
            String productName = product.get("product");

        }
    }

    @When("I remove the products in the cart")
    public void iRemoveTheProductsInTheCart() {

    }

    @Then("the product should be displayed many times in the cart")
    public void theProductShouldBeDisplayedManyTimesInTheCart() {

    }

    @Then("I should see the products in the cart")
    public void iShouldSeeTheProductsInTheCart() {

    }
    @Then("I should not see the products in the cart")
    public void iShouldNotSeeTheProductsInTheCart() {

    }
    @Then("I should see the respective price of the product in the cart")
    public void iShouldSeeTheRespectivePriceOfTheProductInTheCart() {

    }

    @Then("I should see the sum of the total price of the products in the cart")
    public void iShouldSeeTheSumOfTheTotalPriceOfTheProductsInTheCart() {

    }





}
