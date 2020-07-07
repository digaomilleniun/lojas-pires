/**
 * 
 */
package br.com.rpires.lojaspirespedidos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.rpires.lojaspirespedidos.domain.Order;

/**
 * @author Rodrigo Pires
 *
 */
public interface IOrderRepository extends MongoRepository<Order, Long> {

}
