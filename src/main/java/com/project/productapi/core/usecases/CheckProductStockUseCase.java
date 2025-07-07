package main.java.com.project.productapi.core.usecases;

public interface CheckProductStockUseCase {
	CheckStockResult execute(Long productId);
}
