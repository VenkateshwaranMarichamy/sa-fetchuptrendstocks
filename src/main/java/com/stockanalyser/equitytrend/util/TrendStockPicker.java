package com.stockanalyser.equitytrend.util;

import java.util.ArrayList;
import java.util.List;

import com.stockanalyser.equitytrend.model.StockCategories;
import com.stockanalyser.equitytrend.model.TrendStocks;
import com.stockanalyser.equitytrend.model.TrendStocksType;

public class TrendStockPicker {
	
	public static List<TrendStocks> getTrendStocks(List<StockCategories> stockList) {
		
		List<TrendStocks> response = new ArrayList<TrendStocks>();
		
//		List<StockCategories> tmpList = stockList.stream().map(stock -> {
//			TrendStockResponse tr = new TrendStockResponse();
//			tr.setDate(stock.getAnalysisDate());
//			tr.setNiftyUptrend(stock.getIndexStocks().getUptrend().get(1));
//			tr.setNiftyUptrendWithVolume(stock.getIndexStocks().getVolumeBasedStocks().get(1).getName());
//			tr.setNonNiftyUptrend(stock.getIndexStocks().getUptrend().get(1));
//			tr.setNonNiftyUptrendWithVolume(stock.getIndexStocks().getVolumeBasedStocks().get(1).getName());
//			response.add(tr);
//		}).collect();
		
		for (StockCategories stock : stockList) {
			TrendStocks tr = new TrendStocks();
			tr.setDate(stock.getAnalysisDate());
			tr.setNiftyUptrend(stock.getIndexStocks().getUptrend().get(0));
			tr.setNiftyUptrendWithVolume(stock.getIndexStocks().getVolumeBasedStocks().get(0).getName());
			tr.setNonNiftyUptrend(stock.getNonindexStocks().getUptrend().get(0));
			tr.setNonNiftyUptrendWithVolume(stock.getNonindexStocks().getVolumeBasedStocks().get(0).getName());
			response.add(tr);
		}
		
		return response;
	}

}
