/**
 * 
 */
package br.com.rpires.lojaspiresclientes.domain;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Rodrigo Pires
 *
 */
@Document(collection = "endereco")
public class Endereco {

	@Id
    private Long id;
	
	
	
}
