package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import pe.edu.upc.business.crud.ShippingService;
import pe.edu.upc.model.entity.Shipping;




@Named("shippingView")
@ViewScoped
public class ShippingView  implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private List<Shipping> shippings;
	private Shipping shippingSelected;
	private List<Shipping> shippingsSelected;
	private Shipping shippingSearch;
	
	@Inject
	private ShippingService shippingService;
	
	@PostConstruct
	public void init() {
		shippingsSelected= new ArrayList<>();
		shippingSearch= new Shipping();
		getAllShipping();
	}
		
	public boolean hasShippingsSelected() {
		if(shippingsSelected.isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean hasCategorySelected() {
		if(shippingsSelected.size()==1) {
			return true;
		}
		return false;
	}
	
	public void createNew() {
		shippingSelected=new Shipping();
	}
	
	public void editCategorySelected() {
		shippingSelected = shippingsSelected.get(0);
	}
	
	public void saveShipping() {
		try {
			if (shippingSelected.getIdShipping() == null) {
				shippingService.create(shippingSelected);
				shippings.add(shippingSelected);
			} 
			else {
				shippingService.update(shippingSelected);
			}			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('shippingDialog').hide()");
        PrimeFaces.current().ajax().update("shippingDataTable");
	}
	
	public void deleteShipping() {
		try {
			this.shippings.remove(shippingSelected);
			shippingService.deleteById(this.shippingSelected.getIdShipping());
			this.shippingSelected = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "Item Removed"));
		//PrimeFaces.current().ajax().update("form:messages", "regionDataTable");
	}
	public void searchShipping() {
		try {
			shippings = shippingService.findByCity(shippingSearch.getDirection());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public void getAllShipping() {
		try {
			shippings = shippingService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	public List<Shipping> getShippings() {
		return shippings;
	}

	public void setShippingService(ShippingService shippingService) {
		this.shippingService = shippingService;
	}

	public Shipping getShippingSelected() {
		return shippingSelected;
	}

	public void setShippingSelected(Shipping shippingSelected) {
		this.shippingSelected = shippingSelected;
	}

	public List<Shipping> getShippingsSelected() {
		return shippingsSelected;
	}

	public void setShippingsSelected(List<Shipping> shippingsSelected) {
		this.shippingsSelected = shippingsSelected;
	}

	public Shipping getCategorySearch() {
		return shippingSearch;
	}

	public void setShippingSearch(Shipping shippingSearch) {
		this.shippingSearch = shippingSearch;
	}
	
	
}
