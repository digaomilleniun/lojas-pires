/**
 * 
 */
package br.com.rpires.lojaspiresprodutos.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Rodrigo Pires
 *
 */
@Document(collection = "products")
public class Product implements Serializable {

	private static final long serialVersionUID = -999063020499632531L;

	private Long code;
	
	private String name;
	
	private String barCode;
	
	private Long amount;
	
	private Double value;

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
}
