/**
 * 
 */
package br.com.rpires.lojaspirespedidos.domain;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Rodrigo Pires
 *
 */
@Document(collection = "order")
public class Order {

	@Id
	private Long id;
	
	private String cpfCustomer;
	
	private Long codeProduct;
	
	private Integer amount;
	
	private Double totalPurchaseAmount;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpfCustomer() {
		return cpfCustomer;
	}

	public void setCpfCustomer(String cpfCustomer) {
		this.cpfCustomer = cpfCustomer;
	}

	public Long getCodeProduct() {
		return codeProduct;
	}

	public void setCodeProduct(Long codeProduct) {
		this.codeProduct = codeProduct;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getTotalPurchaseAmount() {
		return totalPurchaseAmount;
	}

	public void setTotalPurchaseAmount(Double totalPurchaseAmount) {
		this.totalPurchaseAmount = totalPurchaseAmount;
	}
	
}
