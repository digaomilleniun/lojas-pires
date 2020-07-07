/**
 * 
 */
package br.com.rpires.lojaspiresclientes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.rpires.lojaspiresclientes.domain.Customer;

/**
 * @author Rodrigo Pires
 *
 */
public interface ICustomerRepository extends MongoRepository<Customer, String> {

	public Customer findByCpf(String cpf);
}
