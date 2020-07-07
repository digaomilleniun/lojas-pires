/**
 * 
 */
package br.com.rpires.lojaspiresclientes.domain;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Rodrigo Pires
 *
 */
@Document(collection = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = -5165243182353318885L;

	@Id
	private String cpf;
	
	private String name;
	
	private String rg;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
}
