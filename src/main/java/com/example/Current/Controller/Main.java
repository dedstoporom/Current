package com.example.Current.Controller;

import com.example.Current.Model.Currency;
import com.example.Current.Service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Main {
    @Autowired
    CurrencyService currencyService;

    @GetMapping("/")
    public ResponseEntity main(@RequestParam(required = false) String type,
                                                   @RequestParam(required = false) String date, Map<String, Object> model) {
        Iterable<Currency> currencies;
        try{
        currencies = currencyService.currencyList(type, date);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        model.put("curr", currencies);
        return ResponseEntity.ok().body(currencies);
    }
    }


