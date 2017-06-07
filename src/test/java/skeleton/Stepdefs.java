package skeleton;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {
    Belly belly;

    @Given("^I have (\\d+) cukes in my belly$")
    public void I_have_cukes_in_my_belly(int cukes) throws Throwable {
        belly = new Belly();
        belly.eat(cukes);
    }

    @When("^I wait (\\d+) hour$")
    public void i_wait_hour(int hours) throws Throwable {
        belly.starve(hours * 60);
    }

    @Then("^my belly should growl$")
    public void my_belly_should_growl() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if (!belly.starving()) {
            throw new Exception("Belly still full!");
        }
    }

    @Then("^my belly should still be full$")
    public void my_belly_should_be_full() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if (belly.starving()) {
            throw new Exception("Belly empty!");
        }
    }

    @Then("^my belly growling would be (.+)$")
    public void my_belly_growling_truefalse(Boolean status) throws Throwable {
        if (belly.starving() != status) {
            throw new Exception("Belly does not argue with you!");
        }
    }
}
