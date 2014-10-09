/**
 * 
 */
package ch.InvoiceManager.app.model.entities;

/**
 * @author Oliver
 *
 */
public class Inovice {

	
	int id;
	Service<List> service;
	Customer customer;
	double amount;
	
	
	public Service<List> getService() {
		return service;
	}
	public void setService(Service<List> service) {
		this.service = service;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	
}
