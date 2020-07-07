/**
 * 
 */
package br.com.rpires.lojaspiresprodutos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.rpires.lojaspiresprodutos.domain.Product;

/**
 * @author Rodrigo Pires
 *
 */
public interface IProductRepository extends MongoRepository<Product, Long> {

	public Product findByCode(String code);
}
