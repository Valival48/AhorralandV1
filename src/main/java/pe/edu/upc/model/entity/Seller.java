package pe.edu.upc.model.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Sellers",
indexes= {@Index(columnList="NSeller", name="Seller_index_NSeller"),
		  @Index(columnList="NLastname", name="Seller_index_NLastname")})
@SequenceGenerator(name = "Seller_seller_id_seq", initialValue = 1, allocationSize = 1)
public class Seller{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Seller_seller_id_seq")
	@Column(name = "CSeller", columnDefinition = "NUMERIC(5)")
	private Integer cSeller;

	@Column(name = "NSeller", length = 50, nullable = false)
	private String nSeller;

	@Column(name = "NLastname", length = 50, nullable = false)
	private String nLastName;
	
	//--RELACION CON CODIGO DE IdentificationType--

	@ManyToOne
	@JoinColumn(name = "CIdentificationType", nullable=false)
	private IdentificationType identificationType;
	
	@OneToMany(mappedBy = "seller", fetch = FetchType.LAZY)
	private List<Product> product;
	
	public Seller() {
		product=new ArrayList<Product>();
	}

	public Integer getcSeller() {
		return cSeller;
	}

	public void setcSeller(Integer cSeller) {
		this.cSeller = cSeller;
	}

	public String getnSeller() {
		return nSeller;
	}

	public void setnSeller(String nSeller) {
		this.nSeller = nSeller;
	}

	public String getnLastName() {
		return nLastName;
	}

	public void setnLastName(String nLastName) {
		this.nLastName = nLastName;
	}

	public IdentificationType getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(IdentificationType identificationType) {
		this.identificationType = identificationType;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	
}

