package com.project.productapi.core.usecases;

import com.project.productapi.core.domain.Product;

public interface FindProductByNameUseCase {
	Product execute(String name);
}

