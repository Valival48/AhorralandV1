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
@Table(name="Shipping",
		indexes= {@Index(columnList="TDestinationAdress", name="Shipping_index_TDestinationAdress")})
@SequenceGenerator(name = "Shipping_shipping_id_seq", initialValue = 1, allocationSize = 1)
public class Shipping {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "Shipping_shipping_id_seq")
    @Column (name="Shipping",columnDefinition="NUMERIC(4)")
    private Integer idShipping;

    @Column (name="DShipping")
    @Temporal(TemporalType.DATE)
    private Date shippedDate;

    @Column (name="TDestinationAdress",length=50,nullable=false)
    private String direction;

    @ManyToOne
    @JoinColumn(name="CDeliveryMan",nullable=false)
    private DeliveryMan deliveryman;

	public Integer getIdShipping() {
		return idShipping;
	}

	public void setIdShipping(Integer idShipping) {
		this.idShipping = idShipping;
	}

	public Date getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public DeliveryMan getDeliveryman() {
		return deliveryman;
	}

	public void setDeliveryman(DeliveryMan deliveryman) {
		this.deliveryman = deliveryman;
	}

    
    


}