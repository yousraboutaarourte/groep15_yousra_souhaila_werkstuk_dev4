"use strict";
import { Coffee } from "./coffee/coffee.js";
import { Sugar, Milk, Cream, Water } from "./coffee/extra.js";
import { Payment } from "./coffee/payment.js";
import { payAll, payOne} from "./coffee/terminal.js";
import { colorForConsole, displayInfoCoffee } from "./util/util.js";

colorForConsole();

//Cappuccino
let cappuccino = new Coffee().Cappuccino("Cappuccino", "A delicious Cappuccino", 2, "Light", "Large");
cappuccino = Sugar(Milk(cappuccino));

console.log(displayInfoCoffee(cappuccino));
const viaPaypal = new Payment().PaypalPayment("admin", "1234");

try {
    payOne(viaPaypal, cappuccino, (payment, amount) => {
        if (payment == null) {
            throw new Error("There is no payment method\n")
        }
        return payment.transfer(amount);
    });
} catch (ex) {
    console.log(ex.message, 'red')
}

//Espresso
let espresso = new Coffee().Espresso("Espresso", "An Espresso is never drunk alone, taste it and you will be satisfied.", 1.5, "Strong", "Small");
espresso = Sugar(Water(espresso));

console.log(displayInfoCoffee(espresso));

const viaBancontact = new Payment().BancontactPayment("67051422554321", "05/26");
try {
    payOne(viaBancontact, espresso, (payment, amount) => {
        if (payment == null) {
            throw new Error("There is no payment method\n")
        }
        return payment.transfer(amount);
    });
} catch (ex) {
    console.log(ex.message, 'red')
}

//Macchiato
let macchiato = new Coffee().Macchiato("Macchiato", "A good Italian Macchiato coffee", 5, "Medium", "Medium");
macchiato = Cream(Milk(Sugar(Water(macchiato))));

console.log(displayInfoCoffee(macchiato));

try {
    payOne(null, macchiato, (payment, amount) => {
        if (payment == null) {
            throw new Error("There is no payment method\n")
        }
        return payment.transfer(amount);
    });
} catch (ex) {
    console.log(ex.message, 'red')
}
