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
@Table(name="IdentificationTypes",
indexes= {@Index(columnList="NIdentificationType", name="IdentificationType_index_NIdentificationType")})
@SequenceGenerator(name = "IdentificationTypes_identificationTypes_id_seq", initialValue = 1, allocationSize = 1)
public class IdentificationType{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "IdentificationTypes_identificationTypes_id_seq")
	@Column(name = "CIdentificationType", columnDefinition = "NUMERIC(5)")
	private Integer cIdentificationType;

	@Column(name = "NIdentificationType", length = 50, nullable = false)
	private String nIdentificationType;

	@OneToMany(mappedBy = "identificationType", fetch = FetchType.LAZY)
	private List<Seller> sellers;
	
	public IdentificationType() {
		sellers= new ArrayList<Seller>();
	}

	public Integer getcIdentificationType() {
		return cIdentificationType;
	}

	public void setcIdentificationType(Integer cIdentificationType) {
		this.cIdentificationType = cIdentificationType;
	}

	public String getnIdentificationType() {
		return nIdentificationType;
	}

	public void setnIdentificationType(String nIdentificationType) {
		this.nIdentificationType = nIdentificationType;
	}

	public List<Seller> getSellers() {
		return sellers;
	}

	public void setSellers(List<Seller> sellers) {
		this.sellers = sellers;
	}
	
	
}