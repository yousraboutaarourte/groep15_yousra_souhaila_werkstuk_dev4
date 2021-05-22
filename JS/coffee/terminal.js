import { twoDigit } from "../util/util.js";

const UNIT_PRICE = "unitPrice";

export const payOne = (methodPayment, coffee, callbackStrategy) => {
    callbackStrategy(methodPayment, twoDigit(coffee.price));
}


export const payAll = (methodPayment, coffees = [], callbackStrategy) => {
    let amount = coffees.reduce((a, b) => a + b.price, 0);
    callbackStrategy(methodPayment, twoDigit(amount));
}