package com.stockanalyser.equitytrend.response;

import java.util.List;

import com.stockanalyser.equitytrend.model.TrendStocks;

import lombok.Data;

@Data
public class TrendStockResponse {
	
	private int noOfResults;
	
	private List<TrendStocks> trendStocks;
	

}
