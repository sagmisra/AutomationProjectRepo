package pages;

import base.BasePage;

public class HomePage extends BasePage {

    String newCarMenu = "xpath=//*[normalize-space(text())='NEW CARS']";
    String exploreNewCarBtn = "xpath=//*[normalize-space(text())='Explore New Cars']";

    public void exploreNewCars(){

        moveToElement(newCarMenu);
        click(exploreNewCarBtn);
    }

}
