package pe.edu.upc.model.entity;

import java.io.Serializable;
import java.util.Objects;


public class CartId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer sale;
	private Integer product;
	private Integer seller;
	private int quantity;
	private int partialPrice;

	
	public CartId() {
		super();
	}
	public CartId(Integer sale, Integer product, Integer seller, int quantity, int partialPrice) {
		super();
		this.sale = sale;
		this.product = product;
		this.seller = seller;
		this.quantity = quantity;
		this.partialPrice = partialPrice;
	}
	public Integer getSale() {
		return sale;
	}
	public void setSale(Integer sale) {
		this.sale = sale;
	}
	public Integer getProduct() {
		return product;
	}
	public void setProduct(Integer product) {
		this.product = product;
	}
	public Integer getSeller() {
		return seller;
	}
	public void setSeller(Integer seller) {
		this.seller = seller;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPartialPrice() {
		return partialPrice;
	}
	public void setPartialPrice(int partialPrice) {
		this.partialPrice = partialPrice;
	}
	@Override
    public int hashCode() {
    	return Objects.hash(sale,product,seller,quantity,partialPrice);
    }
	@Override
    public boolean equals (Object obj) {
    	if(this==obj)
    		return true;
    	if (obj == null || this.getClass() != obj.getClass())
			return false;
    	CartId cartId =(CartId)obj;
		if (this.sale !=cartId.sale)
			return false;
		if(this.product!=cartId.product)
			return false;
		if(this.seller!=cartId.seller)
			return false;
		if(this.quantity!=cartId.quantity)
			return false;
		if(this.partialPrice!=cartId.partialPrice)
			return false;
		return true;
    }

}
