package com.example.Current.Service;


import com.example.Current.Model.Currency;
import com.example.Current.Repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;

    public Iterable<Currency> currencyList(String type, String date) {
        if ((type == null || type == "") && (date == null || date == "")) {
            return (Iterable<Currency>) currencyRepository.findAll();
        } else if ((type != null && type != "") && (date == null || date == ""))
            return (Iterable<Currency>) currencyRepository.findType(type);
        else if ((date != null && date != "") && (type == null || type == ""))
            return (Iterable<Currency>) currencyRepository.findDate(date);
        else
            return (Iterable<Currency>) currencyRepository.findListTypeDate(type, date);
    }
}
