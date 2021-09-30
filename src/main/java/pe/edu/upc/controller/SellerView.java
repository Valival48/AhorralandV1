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

import pe.edu.upc.business.crud.SellerService;
import pe.edu.upc.model.entity.Seller;

@Named("sellerView")
@ViewScoped
public class SellerView implements Serializable {

private static final long serialVersionUID = 1L;
	
	private List<Seller>sellers;
	private Seller sellerSelected;
	private List<Seller> sellersSelected;
	private Seller sellerSearch;

	@Inject
	private SellerService sellerService;

	@PostConstruct
	public void init(){
		sellersSelected = new ArrayList<>();
		sellerSearch= new Seller();
		getAllSeller();

	}

	public boolean hasSellersSelected (){
		if(sellersSelected.isEmpty()){
			return false;
		}
		return true;
	}

	public boolean hasSellerSelected (){
		if(sellersSelected.size()==1){
			return true;
		}
		return false;
	}
	
	
	public void createNew() {
		sellerSelected=new Seller();
	}
	
	public void editSellerSelected() {
		sellerSelected = sellersSelected.get(0);
	}
	
	public void saveSeller() {
		try {
			if (sellerSelected.getcSeller() == null) {
				sellerService.create(sellerSelected);
				sellers.add(sellerSelected);
			} 
			else {
				sellerService.update(sellerSelected);
			}			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('sellerDialog').hide()");
        PrimeFaces.current().ajax().update("sellerDataTable");
	}
	
	public void deleteSeller() {
		try {
			this.sellers.remove(sellerSelected);
			sellerService.deleteById(this.sellerSelected.getcSeller());
			this.sellerSelected = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "Item Removed"));
		//PrimeFaces.current().ajax().update("form:messages", "regionDataTable");
	}
	
	
	public void searchSeller() {
		try {
			sellers = sellerService.findByNSeller(sellerSearch.getnSeller());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void getAllSeller() {
		try {
			sellers = sellerService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	

	public Seller getSellerSearch() {
		return sellerSearch;
	}

	public void setSellerSearch(Seller sellerSearch) {
		this.sellerSearch = sellerSearch;
	}

	public SellerService getSellerService() {
		return sellerService;
	}

	public void setSellerSelected(Seller sellerSelected) {
		this.sellerSelected = sellerSelected;
	}

	public List<Seller>getSellers() {
	return sellers;
	}
	public void setSellerService (SellerService sellerService){
		this.sellerService =sellerService;
	}

	public Seller getSellerSelected (){
	return sellerSelected;
	}

	public List<Seller> getSellersSelected (){
		return sellersSelected;
	}

	public void setSellersSelected(List<Seller> sellersSelected){
		this.sellersSelected = sellersSelected;
	}
}