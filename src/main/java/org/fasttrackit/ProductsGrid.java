package org.fasttrackit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsGrid {

    @FindBy(css = "h2.product-name a")
    private List<WebElement> productNames;

    @FindBy(xpath = "//select[@title='Sort By']")
    private WebElement sortBy;


    @FindBy(className = "price")
    private List<WebElement> productPrices;

    public List<WebElement> getProductNames() {
        return productNames;
    }

    public Select getSortBy() {
        return new Select(sortBy);
    }

    public List<WebElement> getProductPrices() {
        return productPrices;
    }

}


