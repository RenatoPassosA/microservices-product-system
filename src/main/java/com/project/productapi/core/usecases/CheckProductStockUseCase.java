package com.project.productapi.core.usecases;

import com.project.productapi.application.result.CheckStockResult;

public interface CheckProductStockUseCase {
	CheckStockResult execute(Long id);
}
