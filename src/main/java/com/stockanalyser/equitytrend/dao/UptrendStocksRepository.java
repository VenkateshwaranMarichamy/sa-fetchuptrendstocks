package com.stockanalyser.equitytrend.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stockanalyser.equitytrend.model.StockCategories;


@Repository
public interface UptrendStocksRepository extends MongoRepository<StockCategories, String> {
	
}
