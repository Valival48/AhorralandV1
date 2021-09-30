package pe.edu.upc.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Product",
		indexes= {@Index(columnList="NProduct", name= "Product_index_NProduct")})
@SequenceGenerator(name = "Product_product_id_seq", initialValue = 1, allocationSize = 1)
public class Product {

	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Product_product_id_seq")
	@Column(name="CProduct",columnDefinition ="NUMERIC(4)")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="CSeller",nullable = false)
	private Seller seller;
	
	@Column(name="NProduct", length= 50, nullable=false)
	private String name;
	
	@Column(name="MPrice")
	private int price;
	
	@Column(name="DExpiration")
	@Temporal(TemporalType.DATE)
	private Date expiration;
	
	@ManyToOne
	@JoinColumn(name="DCategory",nullable = false)
	private Category category;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
