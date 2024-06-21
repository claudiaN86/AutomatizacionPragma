package com.pragma.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class AddingProductCartStepDefinitions {

    @Given("that I access the home page")
    public void thatIAccessTheHomePage() {

    }
    @When("I add a {string} to the cart")
    public void iAddAToTheCart(String string) {

    }

    @When("I add several times the same {string} to the cart")
    public void iAddSeveralTimesTheSameToTheCart(String string) {

    }

    @When("I add multiple products to the cart")
    public void iAddMultipleProductsToTheCart(List<Map<String, String>> products) {
   // public void iAddMultipleProductsToTheCart(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        for (Map<String, String> product : products) {
            String productName = product.get("product");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++"+productName);
        }


    }

    @When("I remove the products from the cart")
    public void iRemoveTheProductsFromTheCart() {

    }

    @Then("the product should be displayed many times in the cart")
    public void theProductShouldBeDisplayedManyTimesInTheCart() {

    }

    @Then("I should see all the different products in the cart")
    public void iShouldSeeAllTheDifferentProductsInTheCart() {

    }

    @Then("the product should be displayed in the cart")
    public void theProductShouldBeDisplayedInTheCart() {

    }
    @Then("I should not see the products")
    public void iShouldNotSeeTheProducts() {

    }
    @Then("I should see the respective price of the product")
    public void iShouldSeeTheRespectivePriceOfTheProduct() {

    }

    @Then("I should see the corresponding total price of the products")
    public void iShouldSeeTheCorrespondingTotalPriceOfTheProducts() {

    }





}
