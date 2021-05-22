"use strict";
const Coffee = function() {
    return {
        Cappuccino: function(name, description, unitPrice, intensity, size) {
            return {
                name,
                description,
                unitPrice,
                price: unitPrice,
                intensity,
                size,
                toString: () => `A Cappuccino | Unit Price : ${unitPrice}€ | Extra : `
            }
        },
        Espresso: function(name, description, unitPrice, intensity, size) {
            return {
                name,
                description,
                unitPrice,
                price: unitPrice,
                intensity,
                size,
                toString: () => `A Espresso | Unit Price : ${unitPrice}€ | Extra : `
            }
        },
        Macchiato: function(name, description, unitPrice, intensity, size) {
            return {
                name,
                description,
                unitPrice,
                price: unitPrice,
                intensity,
                size,
                toString: () => `A Macchiato | Unit Price : ${unitPrice}€ | Extra : `
            }
        },
    }
}

export { Coffee };