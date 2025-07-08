package main.java.com.project.productapi.core.usecases;

import main.java.com.project.productapi.application.result.CheckStockResult;

public interface CheckProductStockUseCase {
	CheckStockResult execute(Long id);
}
