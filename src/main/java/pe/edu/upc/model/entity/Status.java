package pe.edu.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name="Status",
		indexes = {@Index(columnList="NStatus", name = "Status_index_NStatus" )})
public class Status {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name="CStatus",nullable = false)
    private Integer id;

    @Column (name="NStatus")
    private String nombrestatus;
    
    //getter and setter

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombrestatus() {
		return nombrestatus;
	}

	public void setNombrestatus(String nombrestatus) {
		this.nombrestatus = nombrestatus;
	}
    
 
    
}
