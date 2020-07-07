/**
 * 
 */
package br.com.rpires.lojaspiresclientes.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.rpires.lojaspiresclientes.domain.Customer;

/**
 * @author Rodrigo Pires
 *
 */
public interface ICustomerService {

	public void save(Customer cliente);
	
	public Customer update(Customer cliente);
	
	public Page<Customer> findAll(Pageable pageable);
	
	public List<Customer> findAll();
	
	public Customer findByCustomer(String cpf);
}
