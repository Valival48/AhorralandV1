package pe.edu.upc.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ShippingStatus")
@IdClass(value = ShippingStatusId.class)
public class ShippingStatus {
    
	@Id
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name="CStatus", nullable=false)
    private Status status;
    
	@Id
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name="CShipping", nullable=false)
    private Shipping shipping;

	@Id
    @Column(name="DStartStatus")
    @Temporal(TemporalType.DATE)
    private Date startStatus;

	@Id
    @Column(name="DEndStatus")
    @Temporal(TemporalType.DATE)
    private Date endStatus;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public Date getStartStatus() {
		return startStatus;
	}

	public void setStartStatus(Date startStatus) {
		this.startStatus = startStatus;
	}

	public Date getEndStatus() {
		return endStatus;
	}

	public void setEndStatus(Date endStatus) {
		this.endStatus = endStatus;
	}

	
	
}
