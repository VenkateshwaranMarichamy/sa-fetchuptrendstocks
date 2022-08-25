package com.stockanalyser.equitytrend.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
public class TrendStocksType {
	
	@Field(name = "uptrend")
	private List<String> uptrend;
	
	@Field(name = "vol_based")
	private List<StockWithVolume> volumeBasedStocks;
	

}
