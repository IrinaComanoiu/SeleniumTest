package org.fasttrackit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


@RunWith(Parameterized.class)
public class AscendingOrderTest extends TestBase {

    private String searchKeyword;

    public AscendingOrderTest(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }


    @Parameterized.Parameters
    public static List<String> data() {
        return Arrays.asList("hat", "pants");
    }

    @Test
    public void verifyAscendingOrder() {

        openHomepage();

        Header header = PageFactory.initElements(driver, Header.class);

        header.search(searchKeyword);

        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);

        productsGrid.getSortBy().selectByVisibleText("Price");


        List<Double> prices = new ArrayList<>();


        for (WebElement productPrice : productsGrid.getProductPrices()) {
            String priceText = productPrice.getText();

            double price = Double.parseDouble(priceText.split(" ")[0].replace(",", "."));
            prices.add(price);
        }

        List<Double> sortedList = new ArrayList<>(prices);

        sortedList.sort(Comparator.<Double>naturalOrder());

        assertThat("The products are not in ascending order", prices, equalTo(sortedList));


            }

        }







