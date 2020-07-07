/**
 * 
 */
package br.com.rpires.lojaspiresclientes.controller;

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

import br.com.rpires.lojaspiresclientes.domain.Customer;
import br.com.rpires.lojaspiresclientes.service.ICustomerService;
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
@RequestMapping(value = "/customer")
@Api(value = "Customer", tags = {"Customer"})
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;

	@ApiOperation(value = "Customer", notes = "Register Customer")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operation performed successfully"),
			@ApiResponse(code = 401, message = "Not authorized to view"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping
	public ResponseEntity<Customer> save(@RequestBody Customer cliente) {
		customerService.save(cliente);
		return new ResponseEntity<>(cliente, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Customer", notes = "Update Customer")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operation performed successfully"),
			@ApiResponse(code = 401, message = "Not authorized to view"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PutMapping
	public ResponseEntity<Customer> update(@RequestBody Customer cliente) {
		return new ResponseEntity<Customer>(customerService.update(cliente), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Customer", notes = "Find All Customer")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operation performed successfully"),
			@ApiResponse(code = 401, message = "Not authorized to view"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping
	public ResponseEntity<List<Customer>> findAll() {
		List<Customer> list = customerService.findAll();
		return new ResponseEntity<>(list, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Customer", notes = "Find Customer by CPF")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operation performed successfully"),
			@ApiResponse(code = 401, message = "Not authorized to view"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<Customer> findByCPF(@PathVariable(name = "cpf") String cpf) {
		Customer customer = customerService.findByCustomer(cpf);
		return new ResponseEntity<>(customer, HttpStatus.CREATED);
	}
}
