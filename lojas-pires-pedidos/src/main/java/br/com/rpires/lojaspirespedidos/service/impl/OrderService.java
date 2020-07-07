/**
 * 
 */
package br.com.rpires.lojaspirespedidos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import br.com.rpires.lojaspirespedidos.domain.Order;
import br.com.rpires.lojaspirespedidos.repository.IOrderRepository;
import br.com.rpires.lojaspirespedidos.service.IOrderService;

/**
 * @author Rodrigo Pires
 *
 */
@Service
public class OrderService implements IOrderService {
	
	@Autowired
    private MongoTemplate mongoTemplate;

	@Autowired
	private IOrderRepository clienteRepository;

	@Override
	public void save(Order cliente) {
		clienteRepository.save(cliente);
	}

	@Override
	public Page<Order> findAll(Pageable pageable) {
		return clienteRepository.findAll(pageable);
	}

	@Override
	public List<Order> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Order update(Order customer) {
		Query query = new Query(Criteria.where("cpf").is(customer.getId()));
        
		Update update = new Update();
		update.set("amount", customer.getAmount());
		update.set("totalPurchaseAmount", customer.getTotalPurchaseAmount());
		
		return mongoTemplate.findAndModify(
				query, update,
				new FindAndModifyOptions().returnNew(true), Order.class);
		
	}

	@Override
	public Order findById(Long id) {
		Optional<Order> order = clienteRepository.findById(id);
		if (order.isPresent()) {
			return order.get();
		}
		return null;
	}

}
