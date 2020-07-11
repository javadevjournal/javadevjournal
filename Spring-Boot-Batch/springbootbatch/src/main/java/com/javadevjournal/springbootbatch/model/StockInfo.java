package com.javadevjournal.springbootbatch.model;

import lombok.Data;
import java.util.List;

@Data
public class StockInfo {
    private String stockId;
    private String stockName;
    private double stockPrice;
    private double yearlyHigh;
    private double yearlyLow;
    private String address;
    private String sector;
    private String market;
}
