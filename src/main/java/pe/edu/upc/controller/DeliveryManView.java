package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.business.crud.DeliveryManService;
import pe.edu.upc.model.entity.DeliveryMan;

@Named("deliveryManView")
@ViewScoped
public class DeliveryManView implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<DeliveryMan> deliveryMans;
	private DeliveryMan deliveryManSelected;
	private List<DeliveryMan> deliveryMansSelected;
	
	@Inject
	private DeliveryManService deliveryManService;
	
	@PostConstruct
	public void init() {
		deliveryMansSelected = new ArrayList<>();
		try {
			deliveryMans = deliveryManService.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean hasdeliveryMansSelected() {
		if(deliveryMansSelected.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public boolean hasdeliveryManSelected() {
		if(deliveryMansSelected.size()==1) {
			return true;
		}
		return false;
	}

	public List<DeliveryMan> getDeliveryMans() {
		return deliveryMans;
	}

	public void setDeliveryMans(List<DeliveryMan> deliveryMans) {
		this.deliveryMans = deliveryMans;
	}

	public DeliveryMan getDeliveryManSelected() {
		return deliveryManSelected;
	}

	public void setDeliveryManSelected(DeliveryMan deliveryManSelected) {
		this.deliveryManSelected = deliveryManSelected;
	}

	public List<DeliveryMan> getDeliveryMansSelected() {
		return deliveryMansSelected;
	}

	public void setDeliveryMansSelected(List<DeliveryMan> deliveryMansSelected) {
		this.deliveryMansSelected = deliveryMansSelected;
	}

	public DeliveryManService getDeliveryManService() {
		return deliveryManService;
	}

	public void setDeliveryManService(DeliveryManService deliveryManService) {
		this.deliveryManService = deliveryManService;
	}
	
}