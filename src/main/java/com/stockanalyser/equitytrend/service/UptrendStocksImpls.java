package com.stockanalyser.equitytrend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.stockanalyser.equitytrend.dao.UptrendStocksCustomRepo;
import com.stockanalyser.equitytrend.model.StockCategories;

@Service
public class UptrendStocksImpls implements UptrendStocksCustomRepo {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<StockCategories> getBetweenDates(Date startDate, Date endDate) {
		Query query = new Query();
		query.addCriteria(Criteria.where("last_modified").gte(startDate).lte(endDate));
		List<StockCategories> stockList = mongoTemplate.find(query, StockCategories.class);
		return stockList;
	} 

	@Override
	public StockCategories getByDate(Date date) {
		Query query = new Query();
		query.addCriteria(Criteria.where("last_modified").lte(date));        
		StockCategories  stockCategories= mongoTemplate.findOne(query, StockCategories.class);

		return stockCategories;
	}

}
