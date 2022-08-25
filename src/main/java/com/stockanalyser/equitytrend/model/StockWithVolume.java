package com.stockanalyser.equitytrend.model;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class StockWithVolume {
	
	@Field(name = "name")
	private String name;
	
	@Field(name = "volume")
	private int volume;

}
