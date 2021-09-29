package pe.edu.upc.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Discount")
@SequenceGenerator(name = "Discount_discount_id_seq", initialValue = 1, allocationSize = 1)
public class Discount {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="Discount_discount_id_seq")
	@Column(name="CDiscount", columnDefinition = "NUMERIC (4)")
	private Integer id;
	
	@Column(name="Dstart")
	@Temporal(TemporalType.DATE)
	private Date start;
	
	@Column(name="Dend")
	@Temporal(TemporalType.DATE)
	private Date end;

	//getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
	
	
	
	
	
}
