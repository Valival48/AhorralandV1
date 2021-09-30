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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DeliveryMan",
indexes= {@Index(columnList="NDeliveryMan", name="DeliveryMan_index_NDeliveryMan")})
@SequenceGenerator(name = "DeliveryMan_deliveryMan_id_seq", initialValue = 1, allocationSize = 1)
public class DeliveryMan{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "DeliveryMan_deliveryMan_id_seq")
	@Column(name = "CDeliveryMan", columnDefinition = "NUMERIC(5)")
	private Integer id;
	
	@Column(name = "NDeliveryMan", length = 50, nullable = false)
	private String nDeliveryMan;
	
	@OneToMany(mappedBy = "deliveryman", fetch = FetchType.LAZY)
	private List<Shipping> shipping;
	
	// -- Constructor, Getter y Setter
	public DeliveryMan() {
		shipping=new ArrayList<Shipping>();
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getnDeliveryMan() {
		return nDeliveryMan;
	}


	public void setnDeliveryMan(String nDeliveryMan) {
		this.nDeliveryMan = nDeliveryMan;
	}


	public List<Shipping> getShipping() {
		return shipping;
	}


	public void setShipping(List<Shipping> shipping) {
		this.shipping = shipping;
	}
	
	
}

