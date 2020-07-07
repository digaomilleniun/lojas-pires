/**
 * 
 */
package br.com.rpires.lojaspiresprodutos.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.rpires.lojaspiresprodutos.domain.Product;

/**
 * @author Rodrigo Pires
 *
 */
public interface IProductService {

	public void save(Product cliente);
	
	public Product update(Product cliente);
	
	public Page<Product> findAll(Pageable pageable);
	
	public List<Product> findAll();
	
	public Product findByCode(String code);
}
