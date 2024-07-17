package com.sitinuraisha.belibarang.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sitinuraisha.belibarang.model.Item;

@Service
public class PembelianService {
    private final List<Item> items = Arrays.asList(
        new Item("Keyboard", Arrays.asList(25000, 40000, 60000)),
        new Item("Mouse", Arrays.asList(12000, 20000, 35000))
    );

    public List<Item> getItems() {
        return items;
    }

    public Map<String, Integer> purchaseItems(int money) {
        Map<String, Integer> purchases = new HashMap<>();
        int remainingMoney = money;

        for (Item item : items) {
            String itemName = item.getName();
            List<Integer> prices = item.getPrices();
            
            int bestPrice = findBestPrice(prices, remainingMoney);
            
            purchases.put(itemName, bestPrice);
            remainingMoney -= bestPrice;
        }
        return purchases;
    }

    private int findBestPrice(List<Integer> prices, int money) {
        int bestPrice = 0;
        for (int price : prices) {
            if (price <= money && price > bestPrice) {
                bestPrice = price;
            }
        }
        return bestPrice;
    }
}
