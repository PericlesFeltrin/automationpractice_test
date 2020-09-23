package com.periclesfeltrin.web;

import com.periclesfeltrin.web.base.BaseTest;
import com.periclesfeltrin.web.page.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Cenarios extends BaseTest {

    @Test(description = "Adiciona item no carrinho com sucesso.")
    public void validarAdicaoDeItemNoCarrinho() {
        String item = "Faded Short Sleeve T-shirts";
        String quantity_wanted = "2";
        String size = "M";
        String color = "Blue";
        double preco_item;
        double preco_total;

        Home pg_home = new Home(driver);
        SearchResult searchResult = pg_home.buscarItem(item);
        Item pg_item = searchResult.selecionarItem(item);

        preco_item = pg_item.getPrice();

        CartSummary pg_cart_summary = pg_item.adicionarItemEIrParaOCarrinho(quantity_wanted, size, color);

        Assert.assertEquals(item, pg_cart_summary.getProductName());
        String corTamanho = String.format("Color : %s, Size : %s", color, size);
        Assert.assertEquals(corTamanho, pg_cart_summary.getColorSize());
        preco_total = preco_item * Double.parseDouble(quantity_wanted);
        Assert.assertEquals(preco_total, pg_cart_summary.getTotalProducts());
    }

    @Test(description = "Realiza uma compra com sucesso.")
    public void validarCompra() {
        String item = "Faded Short Sleeve T-shirts";
        String quantity_wanted = "2";
        String size = "M";
        String color = "Blue";
        double preco_item;
        double preco_total;

        String email = "test@automation.com";
        String password = "123456";
        String address = "577 Flatbush Ave, Brooklyn";
        String city = "New York";
        String state = "New York";
        String postcode = "11226";
        double preco_frete;

        Home pg_home = new Home(driver);
        SearchResult searchResult = pg_home.buscarItem(item);
        Item pg_item = searchResult.selecionarItem(item);

        preco_item = pg_item.getPrice();
        preco_total = preco_item * Double.parseDouble(quantity_wanted);

        CartSummary pg_cart_summary = pg_item.adicionarItemEIrParaOCarrinho(quantity_wanted, size, color);

        pg_cart_summary.clickOnProceedToCheckout();

        SingInAuthentication pg_singin_aut = new SingInAuthentication(driver);
        pg_singin_aut.login(email, password);

        Address pg_address = new Address(driver);

        Assert.assertEquals(address, pg_address.getDeliveryAddress());
        String cep = String.format("%s, %s %s", city, state, postcode);
        Assert.assertEquals(cep, pg_address.getDeliveryCityStatePostcode());
        Assert.assertEquals(address, pg_address.getBillingAddress());
        Assert.assertEquals(cep, pg_address.getBillingCityStatePostcode());

        pg_address.clickOnProcessAddress();

        Shipping pg_shipping = new Shipping(driver);
        pg_shipping.setTerms();
        preco_frete = pg_shipping.getPriceShipping();
        pg_shipping.clickOnProcessCarrier();

        Payment pg_payment = new Payment(driver);

        Assert.assertEquals(preco_total, pg_payment.getTotalProducts());
        Assert.assertEquals(preco_frete, pg_payment.getTotalShipping());
        Double preco_total_com_frete = preco_total + preco_frete;
        Assert.assertEquals(preco_total_com_frete, pg_payment.getTotalPrice());
        pg_payment.clickOnPayByBankWire();

        pg_payment.clickOnConfirmOrder();

        Assert.assertEquals("Your order on My Store is complete.", pg_payment.getConfirmation());
    }

}
