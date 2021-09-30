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
@Table(name = "Consumer",
	indexes= {@Index(columnList="NName", name="Consumer_index_NName"),
			 @Index(columnList="NLastname", name="Consumer_index_NLastname")})
@SequenceGenerator(name = "Consumer_consumer_id_seq", initialValue = 1, allocationSize = 1)
public class Consumer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Consumer_consumer_id_seq")
    @Column(name = "CConsumer",columnDefinition = "NUMERIC(6)")
    private Integer id;

    @Column(name = "NName",length = 50)
    private String name; //Lower camel case

    @Column(name = "NLastname",length = 25)
    private String lastName;

    @Column(name = "CIdentification", columnDefinition = "NUMERIC(8)")
    private Integer identification;

    @Column(name = "TEmail",length = 50,nullable = false)
    private String email;

    @Column(name = "NumTelephone",length = 20,nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "consumer", fetch = FetchType.LAZY)
	private List<Sale> sales;

	// -- Constructor, Getter y Setter
    public Consumer() {
    	sales= new ArrayList<Sale>();
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getIdentification() {
		return identification;
	}

	public void setIdentification(Integer identification) {
		this.identification = identification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}
    
}

