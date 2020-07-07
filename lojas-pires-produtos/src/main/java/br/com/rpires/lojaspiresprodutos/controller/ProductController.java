/**
 * 
 */
package br.com.rpires.lojaspiresprodutos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rpires.lojaspiresprodutos.domain.Product;
import br.com.rpires.lojaspiresprodutos.service.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Rodrigo Pires
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/product")
@Api(value = "Product", tags = {"Product"})
public class ProductController {

	@Autowired
	private IProductService productService;

	@ApiOperation(value = "Product", notes = "Register Product")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operation performed successfully"),
			@ApiResponse(code = 401, message = "Not authorized to view"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping
	public ResponseEntity<Product> save(@RequestBody Product product) {
		productService.save(product);
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Product", notes = "Update Product")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operation performed successfully"),
			@ApiResponse(code = 401, message = "Not authorized to view"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PutMapping
	public ResponseEntity<Product> update(@RequestBody Product product) {
		return new ResponseEntity<>(productService.update(product), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Product", notes = "Find All Product")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operation performed successfully"),
			@ApiResponse(code = 401, message = "Not authorized to view"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = productService.findAll();
		return new ResponseEntity<>(list, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Product", notes = "Find Product by code")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operation performed successfully"),
			@ApiResponse(code = 401, message = "Not authorized to view"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/code/{code}")
	public ResponseEntity<Product> findByCode(@PathVariable(name = "code") String code) {
		Product product = productService.findByCode(code);
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}
}
