package com.stockanalyser.equitytrend.controller;

import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockanalyser.equitytrend.dao.UptrendStocksRepository;
import com.stockanalyser.equitytrend.model.StockCategories;
import com.stockanalyser.equitytrend.request.TrendStockRequest;
import com.stockanalyser.equitytrend.response.TrendStockResponse;
import com.stockanalyser.equitytrend.service.UptrendStocksImpls;
import com.stockanalyser.equitytrend.util.TrendStockPicker;

@RestController
public class UptrendStocksController {

	//	@Autowired
	//	private UptrendStocksRepository stocksRepo;

	@Autowired
	private UptrendStocksImpls uptrendStocksImpls;
	
	
	//Get mapping using path variable
	@GetMapping("/trendstocks/{fromDate}/{toDate}")
	public ResponseEntity<TrendStockResponse> getAllStocksPathVar(@PathVariable String fromDate, @PathVariable String toDate ) {


		//		for(StockCategories stockList : stocksRepo.findAll()){
		//			System.out.println(stockList);
		//		}

		//		System.out.println(stocksRepo.findById("612cbc366ff8c01593325596"));

		//		LocalDate locald = LocalDate.of(2022, 8, 22);
		//		Date date = new Date(locald)
		//		System.out.println(date);

		Date startDate = null, endDate= null;
		try {
			startDate = new SimpleDateFormat("dd-MM-yyyy").parse(fromDate);
			endDate = new SimpleDateFormat("dd-MM-yyyy").parse(toDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(startDate);

		//System.out.println(uptrendStocksImpls.getByDate(startDate));

		List<StockCategories> stocksList = uptrendStocksImpls.getBetweenDates(startDate,endDate);
		TrendStockResponse response = new  TrendStockResponse();
		response.setTrendStocks(TrendStockPicker.getTrendStocks(stocksList));
		response.setNoOfResults(stocksList.size());
		return new ResponseEntity<TrendStockResponse>(response, HttpStatus.OK);
	}
	//Getmappiing using Request params
	@GetMapping("/trendstocks/")
	public ResponseEntity<?> getAllStocksReqParam(@RequestParam String fromdate, @RequestParam String todate ) {

		Date startDate = null, endDate= null;
		try {
			startDate = new SimpleDateFormat("dd-MM-yyyy").parse(fromdate);
			endDate = new SimpleDateFormat("dd-MM-yyyy").parse(todate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		List<StockCategories> stocksList = uptrendStocksImpls.getBetweenDates(startDate,endDate);
			TrendStockResponse response = new  TrendStockResponse();
			response.setTrendStocks(TrendStockPicker.getTrendStocks(stocksList));
			response.setNoOfResults(stocksList.size());
			return new ResponseEntity<TrendStockResponse>(response, HttpStatus.OK);
	}
	
	@GetMapping("/trendstocks/requestbody")
	public ResponseEntity<?> getAllStocksRequestBody(@RequestBody TrendStockRequest request ) {

		Date startDate = null, endDate= null;
		try {
			startDate = new SimpleDateFormat("dd-MM-yyyy").parse(request.getFromDate());
			endDate = new SimpleDateFormat("dd-MM-yyyy").parse(request.getToDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		List<StockCategories> stocksList = uptrendStocksImpls.getBetweenDates(startDate,endDate);
			TrendStockResponse response = new  TrendStockResponse();
			response.setTrendStocks(TrendStockPicker.getTrendStocks(stocksList));
			response.setNoOfResults(stocksList.size());
			return new ResponseEntity<TrendStockResponse>(response, HttpStatus.OK);
	}

}
