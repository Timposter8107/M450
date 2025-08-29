package org.example;

public class TestDriver {
    public static boolean test_calculate_price(){
        double price = PriceCalculator.calculatePrice(54, 19,20, 4, 10.5);
        boolean test_ok = false;

        if(price != 0){
            test_ok = true;
            System.out.println(price);

        }

        return test_ok;
    }
}
