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

import pe.edu.upc.business.crud.ConsumerService;
import pe.edu.upc.model.entity.Consumer;

@Named("consumerView")
@ViewScoped
public class ConsumerView implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private List<Consumer>consumers;
	private Consumer consumerSelected;
	private List<Consumer> consumersSelected;
	private Consumer consumerSearch;

	@Inject
	private ConsumerService consumerService;

	@PostConstruct
	public void init(){
		consumersSelected = new ArrayList<>();
		consumerSearch= new Consumer();
		getAllConsumer();

	}

	public boolean hasConsumersSelected (){
		if(consumersSelected.isEmpty()){
			return false;
		}
		return true;
	}

	public boolean hasConsumerSelected (){
		if(consumersSelected.size()==1){
			return true;
		}
		return false;
	}
	
	
	public void createNew() {
		consumerSelected=new Consumer();
	}
	
	public void editConsumerSelected() {
		consumerSelected = consumersSelected.get(0);
	}
	
	public void saveConsumer() {
		try {
			if (consumerSelected.getId() == null) {
				consumerService.create(consumerSelected);
				consumers.add(consumerSelected);
			} 
			else {
				consumerService.update(consumerSelected);
			}			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('consumerDialog').hide()");
        PrimeFaces.current().ajax().update("consumerDataTable");
	}
	
	public void deleteConsumer() {
		try {
			this.consumers.remove(consumerSelected);
			consumerService.deleteById(this.consumerSelected.getId());
			this.consumerSelected = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "Item Removed"));
		//PrimeFaces.current().ajax().update("form:messages", "regionDataTable");
	}
	
	
	public void searchConsumer() {
		try {
			consumers = consumerService.findByNName(consumerSearch.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void getAllConsumer() {
		try {
			consumers = consumerService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	

	public Consumer getConsumerSearch() {
		return consumerSearch;
	}

	public void setConsumerSearch(Consumer consumerSearch) {
		this.consumerSearch = consumerSearch;
	}

	public ConsumerService getConsumerService() {
		return consumerService;
	}

	public void setConsumerSelected(Consumer consumerSelected) {
		this.consumerSelected = consumerSelected;
	}

	public List<Consumer>getConsumers() {
	return consumers;
	}
	public void setConsumerService (ConsumerService consumerService){
		this.consumerService =consumerService;
	}

	public Consumer getConsumerSelected (){
	return consumerSelected;
	}

	public List<Consumer> getConsumersSelected (){
		return consumersSelected;
	}

	public void setConsumersSelected(List<Consumer> consumersSelected){
		this.consumersSelected = consumersSelected;
	}
}