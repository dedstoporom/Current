package com.example.Current.Service;

import com.example.Current.Model.Currency;
import com.example.Current.Repository.CurrencyRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
/**
 * Проверка на повтор в таблице и внесение изменений при наличии
 * */
@Component
public class GetService {
    @Autowired
    CurrencyRepository currencyRepository;
     @Transactional
    @Scheduled(fixedDelay = 1800000)
    public void load()  {
        String url = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";
        Document page = null;
        try {
            page = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
         Elements x = page.getElementsByAttribute("currency");
         String time = page.getElementsByAttribute("time").attr("time");
         for (Element t : x) {
             if (currencyRepository.findTypeDate(t.attr("currency"), time) == null) {
                 currencyRepository.save(new Currency(t.attr("currency"), t.attr("rate"), time));
             } else if (!currencyRepository.findTypeDate(t.attr("currency"), time).equals(t.attr("rate"))) {
                 currencyRepository.updateType(t.attr("rate"), t.attr("currency"), time);
             }
         }

     }
}
