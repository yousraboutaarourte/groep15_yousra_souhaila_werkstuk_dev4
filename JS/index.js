"use strict";
import { Coffee } from "./coffee/coffee.js";
import { Sugar, Milk, Cream, Water } from "./coffee/extra.js";
import { Payment } from "./coffee/payment.js";
import { payAll, payOne, sortCoffeeByUnitPrice} from "./coffee/terminal.js";
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
console.log("************************************************", 'purple')

//buy all coffees with just one bank card
let cap = new Coffee().Cappuccino("Cappuccino", "A delicious Cappuccino", 1.5, "Light", "Small");
cap = Sugar(Water(cap));

let mac1 = new Coffee().Macchiato("Macchiato", "A good Italian Macchiato coffee", 6.5, "Strong", "Medium");
mac1 = Cream(Milk(mac1));

let mac2 = new Coffee().Macchiato("Macchiato", "A good Italian Macchiato coffee", 5, "Medium", "Medium");
mac2 = Cream(Water(mac2));

let esp1 = new Coffee().Espresso("Espresso", "An Espresso is never drunk alone, taste it and you will be satisfied.", 1.5, "Light", "Small");
esp1 = Sugar(Cream(esp1));

let esp2 = new Coffee().Espresso("Espresso", "An Espresso is never drunk alone, taste it and you will be satisfied.", 1.7, "Medim", "Small");
esp2 = Cream(Water(esp2));

let esp3 = new Coffee().Espresso("Espresso", "An Espresso is never drunk alone, taste it and you will be satisfied.", 2, "Strong", "Small");
esp3 = Water(esp3);

let coffees = [cap, mac1, mac2, esp1, esp2, esp3];


console.log("The list of ordered coffees sorted by unit price :", 'blue')
let coffeesSorted = sortCoffeeByUnitPrice(coffees);
coffeesSorted.forEach(coffee => {
    console.log(coffee, 'orange');
})
console.log("************************************************", 'purple')
console.log("Buying coffees :", 'blue')
try {
    payAll(viaBancontact, coffees, (payment, amount) => {
        if (payment == null) {
            throw new Error("There is no payment method\n")
        }
        return payment.transfer(amount);
    });
} catch (ex) {
    console.log(ex.message, 'red')
}

//Add sugar in macchiato
mac2 = Sugar(mac2);

try {
    payAll(viaPaypal, [...coffees, mac2], (payment, amount) => {
        if (payment == null) {
            throw new Error("There is no payment method\n")
        }
        return payment.transfer(amount);
    });
} catch (ex) {
    console.log(ex.message, 'red');
}