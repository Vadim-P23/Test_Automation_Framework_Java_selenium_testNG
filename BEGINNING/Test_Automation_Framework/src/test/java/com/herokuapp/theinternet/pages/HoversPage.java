package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HoversPage extends BasePageObject {

    public HoversPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    private By hovers = By.xpath("//a[.='Hovers']");
    private By usersAvatars = By.xpath("//div[@class='figure']/img");
    private By viewProfiles = By.xpath("//a[.='View profile']");

    public void openHoversPage() {
        click(hovers);
    }

    public void openUserProfile(int i) {
        List<WebElement> avatars = findAll(usersAvatars);
        hoverOverElement(avatars.get(i - 1));
        List<WebElement> profiles = findAll(viewProfiles);
        profiles.get(i - 1).click();
    }
}
