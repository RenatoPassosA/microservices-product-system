package com.project.productapi.core.usecases;

import com.project.productapi.application.command.UpdateProductCommand;

import com.project.productapi.core.domain.Product;

public interface UpdateProductUseCase {
	Product execute(UpdateProductCommand command);
}
