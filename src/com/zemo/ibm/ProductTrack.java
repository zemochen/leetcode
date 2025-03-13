package com.zemo.ibm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A system for a retail platform is being developed to track the profit and loss of products based on transactions and price updates.
 * You are given an array, events of size n, where each event is categorized into one of the following:
 *  1. BUY <product> ‹quantity>: Indicates that the retail platform has purchased ‹quantity> units of ‹product> at the current price.
 *  2. SELL < product> quantity>: Indicates that the retail platform has sold ‹quantity> units of < product> at the current price.
 *  3. CHANGE <product> <price>: Indicates that the price of <product> has changed by <price> amount, which can be positive (price increase) or negative (price decrease).
 *  4. QUERY: Requests the net profit/loss from the start of all transactions and price changes up to the current point in time.
 * Implement a function that calculates the net portfolio profit/loss values for all "QUERY" events in the order they appear.
 * The function getNetProfit will take one input:
 *  • string events [n]: the events to process
 * The function should return an array of net portfolio profit/loss values for all "QUERY" events in the order they appear.
 * Example
 *  n = 7
 *  events = ["BUY headphones 20", "BUY laptop 50", "CHANGE headphones 6", "QUERY",
 *              "SELL laptop 10", "CHANGE laptop -2", "QUERY"]
 *  The answer is [120, 40].
 * Constraints
 *  • 1 s ns 10^5, where n is the size of the array events.
 *  • 1 ≤ | events[i] | ≤ 21
 *  • For a SELL event, it is guaranteed that the inventory contains enough units of the product.
 *  • 1 ≤ quantity < 10^3
 *  • The absolute value of a change in the price of any product at any event will not exceed 10^3.
 *  Input Format For Custom Testing
 *  The first line contains an integer, n, the number of elements in events.
 *  Each of the n subsequent lines contains an element of the array events.
 *  Sample Case 0
 *      Sample Input For Custom Testing
 *          2 - events [l size n = 2
 *          BUY hackr 2 → events = ["BUY hackr 2", "QUERY"]
 *          QUERY
 *      Sample Output
 *          0
 *      Explanation
 *          The retail platform purchased 2 products of hackr, then had a "QUERY" event. Since there is no change in product price, there is 0 profit so far. Hence the answer is [0].
 *  Sample Case 1
 *      Sample Input For Custom Testing
 *          6 → events] size n = 6
 *          BUY stock2 2 → events = ["BUY stock2 2", 2","BUY stock1 4", "CHANGE stock2 -8","SELL stock1 2","BUY stock3 3", "QUERY"]
 *          BUY stock1 4
 *          CHANGE stock2 -8
 *          SELL stock1 2
 *          BUY stock3 3
 *          QUERY
 *       Sample Output
 *          -16
 *       Explanation
 *          The price of 2 units of stock2 decreased by 8. Hence the answer is [-16].
 */
public class ProductTrack {

    public static void main(String[] args) {
        String[] events = {"BUY headphones 20", "BUY laptop 50", "CHANGE headphones 6", "QUERY",
            "SELL laptop 10", "CHANGE laptop -2","SELL laptop 10", "CHANGE laptop 10","QUERY"};
        List<Double> result = getNetProfit(events);
        for (Double i : result) {
            System.out.println(i);
        }
    }

    public static List<Double> getNetProfit(String[] events) {
        if (events == null) {
            return null;
        }
        Map<String, Integer> productMap = new HashMap<>();
        Map<String, Double> priceMap = new HashMap<>();

        List<Double> result = new ArrayList<>();

        Double profit = 0.0;

        for (String event : events) {

            String[] eventArr = event.split(" ");
            String command = eventArr[0];
            switch (command) {
                case "BUY":
                    if (eventArr.length >= 3) {
                        String product = eventArr[1];
                        Integer quantity = Integer.parseInt(eventArr[2]);
                        Integer currQuantity = productMap.getOrDefault(product, 0);
                        productMap.put(product, currQuantity + quantity);
                    }
                    break;
                case "SELL":
                    if (eventArr.length >= 3) {
                        String product = eventArr[1];
                        Integer quantity = Integer.parseInt(eventArr[2]);
                        Integer currQuantity = productMap.getOrDefault(product, 0);
                        productMap.put(product, currQuantity - quantity);
//                        profit += priceMap.getOrDefault(product, 0.0) * quantity;
                    }
                    break;
                case "CHANGE":
                    if (eventArr.length >= 3) {
                        String product = eventArr[1];
                        Double price = Double.parseDouble(eventArr[2]);
                        Double currPrice = priceMap.getOrDefault(product, 0.0);
                        priceMap.put(product, currPrice + price);
                        profit += productMap.getOrDefault(product, 0) * price;
                    }
                    break;
                case "QUERY":
                    result.add(profit);
                    break;
                default:
                    break;
            }
        }
        return result;
    }

}
