"use strict";
export const twoDigit = (number) => {
    return parseFloat(number).toFixed(2);
}

export const colorForConsole = () => {
    let $consoleLog = console.log;
    console.log = function($message, $color) {
        $consoleLog('%c' + $message, 'color:' + $color + ';font-weight:bold;');
    }
}

export const displayInfoCoffee = (coffee) => {
    return `${coffee} | Amount : ${twoDigit(coffee.price)} €`;

}