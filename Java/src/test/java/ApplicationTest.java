import coffees.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import coffees.BancontactPayment;
import coffees.PaypalPayment;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {
    Coffee cappuccino;
    Coffee macchiato;
    Coffee espresso;
    Terminal terminal;
    @BeforeEach
    void setUp() {
        this.terminal = new Terminal();
        IBuilder<Cappuccino> cappuccinoBuilder =  Cappuccino.makeMeACoffee();
        this.cappuccino = cappuccinoBuilder.name("Cappuccino")
                .description("A delicious Cappuccino")
                .price(2)
                .intensity(Intensity.LIGHT)
                .size(SizeCoffee.L)
                .build();
        IBuilder<Macchiato> macchiatoBuilder =  Macchiato.makeMeACoffee();
        this.macchiato = macchiatoBuilder.name("Macchiato")
                .description("A good Italian Macchiato coffee")
                .price(5)
                .intensity(Intensity.MEDIUM)
                .size(SizeCoffee.M)
                .build();
        IBuilder<Espresso> espressoBuilder =  Espresso.makeMeACoffee();
        this.espresso = espressoBuilder.name("Espresso")
                .description("An Espresso is never drunk alone, taste it and you will be satisfied.")
                .price(1.5)
                .intensity(Intensity.STRONG)
                .size(SizeCoffee.S)
                .build();
    }

    @Test
    void test_pattern_builder_name_price_not_indicated() {
        assertThrows(IllegalArgumentException.class, () -> Cappuccino.makeMeACoffee().build());
        assertThrows(IllegalArgumentException.class, () -> Macchiato.makeMeACoffee().name("Name test").build());
        assertThrows(IllegalArgumentException.class, () -> Espresso.makeMeACoffee().price(25).build());
    }

    @Test
    void test_pattern_builder_name_price_and_intensity() {
        assertEquals("Cappuccino", this.cappuccino.getName());
        assertEquals("Macchiato", this.macchiato.getName());
        assertEquals("Espresso", this.espresso.getName());
        assertEquals(2, this.cappuccino.getPrice());
        assertEquals(5, this.macchiato.getPrice());
        assertEquals(1.5, this.espresso.getPrice());
        assertEquals(Intensity.LIGHT, this.cappuccino.getIntensity());
        assertEquals(Intensity.MEDIUM, this.macchiato.getIntensity());
        assertEquals(Intensity.STRONG, this.espresso.getIntensity());
    }


    @Test
    void test_pattern_decorator_price_when_decorated_with_milk() {
        Coffee coffee = new Milk(cappuccino);//50 cent le lait
        assertNotEquals(2, coffee.getPrice());
        assertEquals( 2.5, coffee.getPrice());
    }

    @Test
    void test_pattern_decorator_with_all_extras() {
        Coffee coffee = new Sugar(new Water(new Cream(new Milk(espresso))));
        assertNotEquals(1.5,coffee.getPrice());
        assertEquals(3.1,coffee.getPrice());
    }


    @Test
    void test_pattern_strategy_without_payment() {
        Coffee coffee = new Sugar(new Cream(new Water(macchiato)));
        assertEquals(6.1,coffee.getPrice() );
        assertThrows(IllegalArgumentException.class, () -> terminal.payOne(coffee,null));
    }

    @Test
    void test_pattern_strategy_payment_bancontact_with_correct_data() {
        Coffee coffee = new Sugar(new Cream(new Water(macchiato)));
        assertEquals(6.1,coffee.getPrice());
        assertTrue(terminal.payOne(coffee,new BancontactPayment("67051422554321", "11/30")));
    }

    @Test
    void test_pattern_strategy_payment_bancontact_with_incorrect_data() {
        Coffee coffee = new Sugar(new Cream(new Water(macchiato)));
        assertEquals(6.1,coffee.getPrice());
        assertThrows(IllegalArgumentException.class, () -> terminal.payOne(coffee,new BancontactPayment("14555454454545", "11/25")));
    }


    @Test
    void test_pattern_strategy_payment_paypal_with_correct_data() {
        Coffee coffee = new Sugar(new Cream(new Water(macchiato)));
        assertEquals(6.1,coffee.getPrice());
        assertTrue(terminal.payOne(coffee,new PaypalPayment("admin", "1234")));
    }

    @Test
    void test_pattern_strategy_payment_paypal_with_incorrect_data() {
        Coffee coffee = new Sugar(new Cream(new Water(macchiato)));
        assertEquals(6.1,coffee.getPrice());
        assertThrows(IllegalArgumentException.class, () -> terminal.payOne(coffee,new PaypalPayment("admin", "12345")));
    }


    @Test
    void test_pattern_strategy_payment_paypal_multiple_coffees() {
        Coffee coffeeMacchiato = new Sugar(new Cream(new Water(macchiato)));
        Coffee coffeeCappuccino = new Sugar(new Cream(new Water(cappuccino)));
        Coffee coffeeEspresso = new Sugar(new Cream(new Water(espresso)));
        List<Coffee> coffees = Arrays.asList(coffeeCappuccino,coffeeEspresso,coffeeMacchiato);
        assertTrue(terminal.payAll(coffees,new PaypalPayment("admin", "1234")));
    }

    @Test
    void test_pattern_strategy_payment_bancontact_multiple_coffees() {
        Coffee coffeeMacchiato = new Cream(new Water(macchiato));
        Coffee coffeeCappuccino = new Sugar(new Cream(new Water(cappuccino)));
        Coffee coffeeEspresso =(new Water(espresso));
        List<Coffee> coffees = Arrays.asList(coffeeCappuccino,coffeeEspresso,coffeeMacchiato);
        assertTrue(terminal.payAll(coffees,new BancontactPayment("67051422554321", "11/30")));
    }
}
