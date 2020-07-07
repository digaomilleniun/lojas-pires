/**
 * 
 */
package br.com.rpires.lojaspiresprodutos.service.impl;

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

import br.com.rpires.lojaspiresprodutos.domain.Product;
import br.com.rpires.lojaspiresprodutos.repository.IProductRepository;
import br.com.rpires.lojaspiresprodutos.service.IProductService;

/**
 * @author Rodrigo Pires
 *
 */
@Service
public class ProductService implements IProductService {
	
	@Autowired
    private MongoTemplate mongoTemplate;

	@Autowired
	private IProductRepository clienteRepository;

	@Override
	public void save(Product cliente) {
		clienteRepository.save(cliente);
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return clienteRepository.findAll(pageable);
	}

	@Override
	public List<Product> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Product update(Product product) {
		Query query = new Query(Criteria.where("code").is(product.getCode()));
        Update update = new Update();
        update.set("name", product.getName());
        update.set("barCode", product.getBarCode());
        update.set("amount", product.getAmount());
        
        return mongoTemplate.findAndModify(
				query, update,
				new FindAndModifyOptions().returnNew(true), Product.class);
	}

	@Override
	public Product findByCode(String code) {
		return clienteRepository.findByCode(code);
	}

}
