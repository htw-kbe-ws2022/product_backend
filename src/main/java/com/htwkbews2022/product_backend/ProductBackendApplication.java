package com.htwkbews2022.product_backend;

import com.htwkbews2022.product_backend.core.domain.model.Category;
import com.htwkbews2022.product_backend.core.domain.model.Currency;
import com.htwkbews2022.product_backend.core.domain.model.Product;
import com.htwkbews2022.product_backend.core.interfaces.ProductRepoInterface;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductBackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductRepoInterface foodRepository) {
		return (args) -> {

			foodRepository.save(Product
					.builder()
					.title("Chicken Boneless Burner")
					.currency(Currency.EURO)
					.category(Category.DOPE)
					.price(12.50d)
					.count(4)
					.build());
			foodRepository.save(Product
					.builder()
					.title("hawaiaien")
					.currency(Currency.EURO)
					.category(Category.DOPE)
					.price(9.50d)
					.count(4)
					.build());
			foodRepository.save(Product
					.builder()
					.title("orangeBudd")
					.currency(Currency.EURO)
					.category(Category.DOPE)
					.price(13.50d)
					.count(7)
					.build());
		};
	}


}
