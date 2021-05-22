"use strict";
const Payment = function() {
    return {
        PaypalPayment: (username, password) => {
            return {
                username,
                password,
                transfer: (amount) => {
                    if (username == "admin" && password == "1234") {
                        console.log(`The amount of ${amount} EUR was paid via Paypal\n`, 'green');
                        return true;
                    }
                    throw new Error("Account doesn't exist !\n");
                }
            }
        },
        BancontactPayment: (cardNumber, expDate) => {
            return {
                cardNumber,
                expDate,
                transfer: (amount) => {
                    if (cardNumber == "67051422554321" && expDate == "05/26") {
                        console.log(`The amount of ${amount} EUR was paid via Bancontact\n`, 'green');
                        return true;
                    }
                    throw new Error("Account doesn't exist, please contact your bank\n");
                }
            }
        }
    }
}
export { Payment };