package com.htwkbews2022.product_backend;

import com.htwkbews2022.product_backend.core.domain.model.Category;
import com.htwkbews2022.product_backend.core.domain.model.Currency;
import com.htwkbews2022.product_backend.core.domain.model.Product;
import com.htwkbews2022.product_backend.core.interfaces.ProductRepoInterface;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;

@SpringBootApplication
public class ProductBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductBackendApplication.class, args);
	}

/*	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/product").allowedOrigins("http://localhost:8080");
				registry.addMapping("/product").allowedOrigins("http://localhost:3000");
			}
		};
	}*/


	@Bean
	public FilterRegistrationBean simpleCorsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		// *** URL below needs to match the Vue client URL and port ***
		config.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
		config.setAllowedMethods(Collections.singletonList("*"));
		config.setAllowedHeaders(Collections.singletonList("*"));
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean<>(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
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
					.description("high intensive dark smoked weed")
					.picUrl("https://cdn.pixabay.com/photo/2019/09/21/15/40/marijuana-4494190_960_720.jpg")
					.count(4)
					.build());
			foodRepository.save(Product
					.builder()
					.title("hawaiaien")
					.currency(Currency.EURO)
					.category(Category.DOPE)
					.price(9.50d)
					.count(4)
					.description("Fancy visionary light dope")
					.picUrl("https://cdn.pixabay.com/photo/2019/09/21/15/40/marijuana-4494190_960_720.jpg")
					.build());
			foodRepository.save(Product
					.builder()
					.title("purpleHase")
					.currency(Currency.EURO)
					.category(Category.DOPE)
					.price(11.50d)
					.description("classic purple dope")
					.picUrl("https://cdn.pixabay.com/photo/2019/09/21/15/40/marijuana-4494190_960_720.jpg")
					.count(4)
					.build());
			foodRepository.save(Product
					.builder()
					.title("Lolipop")
					.currency(Currency.EURO)
					.category(Category.PROCESSED)
					.price(2.50d)
					.description("Sweet lolipopp with 1g thc")
					.picUrl("https://cdn.pixabay.com/photo/2019/09/21/15/40/marijuana-4494190_960_720.jpg")
					.count(2)
					.build());
			foodRepository.save(Product
					.builder()
					.title("orangeBudd")
					.currency(Currency.EURO)
					.category(Category.DOPE)
					.description("the classic dope")
					.picUrl("https://cdn.pixabay.com/photo/2019/09/21/15/40/marijuana-4494190_960_720.jpg")
					.price(13.50d)
					.count(7)
					.build());
			foodRepository.save(Product
					.builder()
					.title("Love And Peace Cup")
					.currency(Currency.EURO)
					.category(Category.NON_DOPE)
					.price(3.50d)
					.description("a cup, a f*** cup")
					.picUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSIXS93Vb0IKHbrv4qGhLV4S0m637GXzaAXieRiAePatOhjl9G_1xjHjy0gCUiUFrUwEEo&usqp=CAU")
					.count(7)
					.build());
		};
	}


}
