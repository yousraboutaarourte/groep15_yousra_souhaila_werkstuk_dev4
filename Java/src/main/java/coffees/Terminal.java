package coffees;

import java.util.List;

public class Terminal {
    public boolean payOne(Coffee coffee, Payment paymentStrategy){
        if(paymentStrategy==null){
            throw new IllegalArgumentException("There is no payment method");
        }
        return paymentStrategy.transfer(coffee.getPrice());
    }

    public boolean payAll(List<Coffee> coffees, Payment paymentStrategy){
        if(paymentStrategy==null){
            throw new IllegalArgumentException("There is no payment method");
        }
        return paymentStrategy.transfer(coffees.stream().mapToDouble(Coffee::getPrice).sum());
    }
}
