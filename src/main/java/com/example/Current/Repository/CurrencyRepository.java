package com.example.Current.Repository;

import com.example.Current.Model.Currency;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CurrencyRepository extends CrudRepository<Currency, Long> {

    @Query(value = "SELECT value FROM Currency where type=:type and date=:date", nativeQuery = true)
    String findTypeDate(@Param("type") String type, @Param("date") String date);

    @Query(value = "SELECT * FROM Currency where type=:type and date=:date", nativeQuery = true)
    List<Currency> findListTypeDate(@Param("type") String type, @Param("date") String date);

    @Query(value = "SELECT * FROM Currency where type=:type", nativeQuery = true)
    List<Currency> findType(@Param("type") String type);

    @Query(value = "SELECT * FROM Currency where date=:date", nativeQuery = true)
    List<Currency> findDate(@Param("date") String date);

    @Transactional
    @Modifying
    @Query(value = "update Currency set value=:value where type=:type and date=:date", nativeQuery = true)
    void updateType(@Param("value") String value, @Param("type") String type, @Param("date") String date);
}
