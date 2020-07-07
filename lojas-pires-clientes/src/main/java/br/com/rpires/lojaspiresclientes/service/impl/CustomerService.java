/**
 * 
 */
package br.com.rpires.lojaspiresclientes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import br.com.rpires.lojaspiresclientes.domain.Customer;
import br.com.rpires.lojaspiresclientes.repository.ICustomerRepository;
import br.com.rpires.lojaspiresclientes.service.ICustomerService;

/**
 * @author Rodrigo Pires
 *
 */
@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
    private MongoTemplate mongoTemplate;

	@Autowired
	private ICustomerRepository clienteRepository;

	@Override
	public void save(Customer cliente) {
		clienteRepository.save(cliente);
	}

	@Override
	public Page<Customer> findAll(Pageable pageable) {
		return clienteRepository.findAll(pageable);
	}

	@Override
	public List<Customer> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Customer update(Customer customer) {
		Query query = new Query(Criteria.where("cpf").is(customer.getCpf()));
        
		Update update = new Update();
		update.set("name", customer.getName());
		update.set("rg", customer.getRg());
		
		return mongoTemplate.findAndModify(
				query, update,
				new FindAndModifyOptions().returnNew(true), Customer.class);
		
	}

	@Override
	public Customer findByCustomer(String cpf) {
		return clienteRepository.findByCpf(cpf);
	}

}
