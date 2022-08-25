package com.stockanalyser.equitytrend.dao;

import java.util.Date;
import java.util.List;

import com.stockanalyser.equitytrend.model.StockCategories;

public interface UptrendStocksCustomRepo {
	
	public List<StockCategories> getBetweenDates(Date startDate, Date endDate);
	
	public StockCategories getByDate(Date date);

}
