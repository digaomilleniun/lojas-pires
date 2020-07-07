/**
 * 
 */
package br.com.rpires.lojaspirespedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rpires.lojaspirespedidos.domain.Order;
import br.com.rpires.lojaspirespedidos.service.IOrderService;
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
@RequestMapping(value = "/Order")
@Api(value = "Order", tags = {"Order"})
public class OrderController {
	
	@Autowired
	private IOrderService OrderService;

	@ApiOperation(value = "Order", notes = "Register Order")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operation performed successfully"),
			@ApiResponse(code = 401, message = "Not authorized to view"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping
	public ResponseEntity<Order> save(Order cliente) {
		OrderService.save(cliente);
		return new ResponseEntity<>(cliente, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Order", notes = "Update Order")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operation performed successfully"),
			@ApiResponse(code = 401, message = "Not authorized to view"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PutMapping
	public ResponseEntity<Order> update(Order cliente) {
		return new ResponseEntity<Order>(OrderService.update(cliente), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Order", notes = "Find All Order")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operation performed successfully"),
			@ApiResponse(code = 401, message = "Not authorized to view"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = OrderService.findAll();
		return new ResponseEntity<>(list, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Order", notes = "Find Order by ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operation performed successfully"),
			@ApiResponse(code = 401, message = "Not authorized to view"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/id/{id}")
	public ResponseEntity<Order> findByCPF(@PathVariable(name = "id") Long id) {
		Order Order = OrderService.findById(id);
		return new ResponseEntity<>(Order, HttpStatus.CREATED);
	}
}
