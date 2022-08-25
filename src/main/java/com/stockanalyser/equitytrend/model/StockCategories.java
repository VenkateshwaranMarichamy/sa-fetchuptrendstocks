package com.stockanalyser.equitytrend.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@Document(collection = "uptrend")
public class StockCategories {
	@Id
	private String id;
	
	@Field(name = "nifty")
	private TrendStocksType indexStocks;
	
	@Field(name = "non_nifty")
	private TrendStocksType nonindexStocks;
	
	@Field(name = "date")
	private String analysisDate;

}
