package pe.edu.upc.model.entity;

import java.io.Serializable;
import java.util.Objects;


public class DiscountdetailId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private Integer discount;
	private Integer product;
	private Integer seller;
	private int perDiscount;
	
	
	
	public DiscountdetailId() {
		super();
	}
	public DiscountdetailId(Integer discount, Integer product, Integer seller, int perDiscount) {
		super();
		this.discount = discount;
		this.product = product;
		this.seller = seller;
		this.perDiscount = perDiscount;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
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
	public int getPerDiscount() {
		return perDiscount;
	}
	public void setPerDiscount(int perDiscount) {
		this.perDiscount = perDiscount;
	}
	@Override
    public int hashCode() {
    	return Objects.hash(perDiscount,discount,product,seller);
    }
	@Override
    public boolean equals (Object obj) {
    	if(this==obj)
    		return true;
    	if (obj == null || this.getClass() != obj.getClass())
			return false;
    	DiscountdetailId discountdetailId =(DiscountdetailId)obj;
		if (this.perDiscount !=discountdetailId.perDiscount)
			return false;
		if(this.discount!=discountdetailId.discount)
			return false;
		if(this.product!=discountdetailId.product)
			return false;
		if(this.seller!=discountdetailId.seller)
			return false;
		return true;
    }
    

}
