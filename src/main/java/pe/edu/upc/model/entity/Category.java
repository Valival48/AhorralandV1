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
@Table(name = "Category",
	indexes= {@Index(columnList="NType", name="Category_index_NType")})
@SequenceGenerator(name = "Category_category_id_seq", initialValue = 1, allocationSize = 1)
public class Category {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Category_category_id_seq")
    @Column(name = "CCategory",columnDefinition = "NUMERIC(4)")
    private Integer id;

    @Column(name = "NType", length= 25, nullable=false)
    private String type;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Product> productos;
    
    public Category() {
    	productos= new ArrayList<Product>();
    }
	// -- Constructor, Getter y Setter

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Product> getProductos() {
		return productos;
	}

	public void setProductos(List<Product> productos) {
		this.productos = productos;
	}
    
}
