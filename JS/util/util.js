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

export const sortSelection = (array, field) => {
    for (let i = 0; i < array.length - 1; i++) {
        let currMin = i;
        for (let j = i + 1; j < array.length; j++) {
            if (array[j][field] < array[currMin][field]) {
                currMin = j;
            }
        }
        swap(array, i, currMin);
    }
    return array;
}

const swap = (array, i, currMin) => {
    let tmp = array[i];
    array[i] = array[currMin];
    array[currMin] = tmp;
}