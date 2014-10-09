/**
 * 
 */
package ch.InvoiceManager.app.model.entities;

/**
 * @author Oliver
 *
 */
public class Service {

	
	int id;
	int describtion;
	double price;
	
	
	public int getDescribtion() {
		return describtion;
	}
	public void setDescribtion(int describtion) {
		this.describtion = describtion;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	
	
}
