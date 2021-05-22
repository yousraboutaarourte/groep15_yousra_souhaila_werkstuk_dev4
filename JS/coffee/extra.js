"use strict";
const Cream = (coffee) => {
    return {
        unitPrice: coffee.unitPrice,
        price: 0.75 + coffee.price,
        toString: () => coffee + " cream" //arrow functions 
    }
};

const Sugar = (coffee) => {
    return {
        unitPrice: coffee.unitPrice,
        price: 0.25 + coffee.price,
        toString: function() { return coffee + " sugar" }
    }
}

const Water = (coffee) => {
    return {
        unitPrice: coffee.unitPrice,
        price: 0.10 + coffee.price,
        toString: () => coffee + " water"
    }
}

const Milk = (coffee) => {
    return {
        unitPrice: coffee.unitPrice,
        price: 0.5 + coffee.price,
        toString: () => coffee + " milk"
    }
}


export { Cream, Sugar, Water, Milk };