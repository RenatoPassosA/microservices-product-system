package com.project.productapi.application.result;

public class CheckStockResult {
	Long	id;
	String	name;
	Integer	stock;

	public CheckStockResult(Long id, String name, Integer stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getStock() {
        return stock;
    }	
}
