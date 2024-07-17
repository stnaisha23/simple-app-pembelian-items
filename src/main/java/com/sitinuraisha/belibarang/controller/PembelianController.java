package com.sitinuraisha.belibarang.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sitinuraisha.belibarang.model.Item;
import com.sitinuraisha.belibarang.services.PembelianService;

@RestController
@RequestMapping("/pembelian")
public class PembelianController {

    @Autowired
    private PembelianService pembelianService;

    @GetMapping("/items")
    public List<Item> getAvailableItems() {
        return pembelianService.getItems();
    }

    @PostMapping("/beli")
    public Map<String, Integer> purchaseItems(@RequestParam int money) {
        return pembelianService.purchaseItems(money);
    }
}

