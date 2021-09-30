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
@Table(name = "PaymentType",
			indexes= {@Index(columnList="NPaymentType", name="PaymentType_index_NPaymentType")})
@SequenceGenerator(name = "PaymentType_paymentType_id_seq", initialValue = 1, allocationSize = 1)
public class PaymentType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "PaymentType_paymentType_id_seq")
    @Column(name = "CPaymentType",columnDefinition = "NUMERIC(6)")
    private Integer id;

    @Column(name = "NPaymentType",length = 50)
    private String name;

    @OneToMany(mappedBy = "paymentTye", fetch = FetchType.LAZY)
	private List<Sale> sales;

    
    public PaymentType() {
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


	public List<Sale> getSales() {
		return sales;
	}


	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}
    
    
}

