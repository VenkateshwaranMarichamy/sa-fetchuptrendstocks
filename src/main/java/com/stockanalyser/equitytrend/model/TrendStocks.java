package com.stockanalyser.equitytrend.model;

import lombok.Data;

@Data
public class TrendStocks {
	
	
	private String date;
	
	private String niftyUptrend;
	private String niftyUptrendWithVolume;
	
	private String nonNiftyUptrend;
	private String nonNiftyUptrendWithVolume;
	
	

}
