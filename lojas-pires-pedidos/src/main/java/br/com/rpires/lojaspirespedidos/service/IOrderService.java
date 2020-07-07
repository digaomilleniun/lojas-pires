/**
 * 
 */
package br.com.rpires.lojaspirespedidos.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.rpires.lojaspirespedidos.domain.Order;

/**
 * @author Rodrigo Pires
 *
 */
public interface IOrderService {

	public void save(Order order);
	
	public List<Order> findAll();
	
	public Page<Order> findAll(Pageable pageable);
	
	public Order findById(Long id);

	Order update(Order customer);
	
}
