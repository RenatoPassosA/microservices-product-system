package com.project.productapi.core.usecases;

import com.project.productapi.core.domain.Product;

import com.project.productapi.application.command.CreateProductCommand;

public interface CreateProductUseCase {
	Product execute(CreateProductCommand command);
}
