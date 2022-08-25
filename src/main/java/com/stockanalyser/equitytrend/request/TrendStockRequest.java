package com.stockanalyser.equitytrend.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TrendStockRequest {
	
	private String fromDate;
	
	private String toDate;

}
