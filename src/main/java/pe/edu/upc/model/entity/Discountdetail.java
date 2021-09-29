package pe.edu.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Discountdetail")
@IdClass(value = DiscountdetailId.class)
public class Discountdetail {
    @Id
    @Column(name="PerDiscount" )
    private int perDiscount;

    @Id
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name="CDiscount",columnDefinition="NUMERIC(4)")
    private Discount discount;

    @Id
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name="CProduct",columnDefinition="NUMERIC(4)")
    private Product product;

    @Id
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name="CSeller",columnDefinition="NUMERIC(4)")
    private Seller seller;
}
