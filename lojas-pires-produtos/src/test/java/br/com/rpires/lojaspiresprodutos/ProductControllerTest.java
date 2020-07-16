package br.com.rpires.lojaspiresprodutos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import br.com.rpires.lojaspiresprodutos.config.H2JpaConfig;
import br.com.rpires.lojaspiresprodutos.domain.Product;

@SpringBootApplication
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = {LojasPiresProdutosApplicationTests.class, H2JpaConfig.class})
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@ActiveProfiles("test")
public class ProductControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	private static String requestMapping = "/product";
	
	public String getURL() {
		return "http://localhost:" + port + requestMapping;
	}
	
	@Test
	public void save() {
		Product product = createProduct();
		ResponseEntity<Product> response = this.restTemplate.postForEntity(getURL(), product, Product.class);
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	private Product createProduct() {
		Product product = new Product();
		product.setAmount(10L);
		product.setBarCode("105");
		product.setCode(15L);
		product.setName("Teste");
		product.setValue(10.0);
		return product;
	}
}
