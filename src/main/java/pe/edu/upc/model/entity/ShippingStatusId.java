package pe.edu.upc.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ShippingStatusId implements Serializable {
    
	private static final long serialVersionUID = 1L;
     
	private Integer status;    
    private Integer shipping;
    private Date startStatus;
    private Date endStatus;
    
    

    public ShippingStatusId() {
		super();
	}
	public ShippingStatusId(Integer status, Integer shipping, Date startStatus, Date endStatus) {
		super();
		this.status = status;
		this.shipping = shipping;
		this.startStatus = startStatus;
		this.endStatus = endStatus;
	}
	
	// Getter y Setter
	
	
    public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getShipping() {
		return shipping;
	}
	public void setShipping(Integer shipping) {
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
	
	@Override
    public int hashCode() {
    	return Objects.hash(status,shipping,startStatus,endStatus);
    }
	@Override
    public boolean equals (Object obj) {
    	if(this==obj)
    		return true;
    	if (obj == null || this.getClass() != obj.getClass())
			return false;
    	ShippingStatusId shippingStatusId =(ShippingStatusId)obj;
		if (this.status !=shippingStatusId.status)
			return false;
		if(this.shipping!=shippingStatusId.shipping)
			return false;
		if(this.startStatus!=shippingStatusId.startStatus)
			return false;
		if(this.endStatus!=shippingStatusId.endStatus)
			return false;
		return true;
    }
    
}
