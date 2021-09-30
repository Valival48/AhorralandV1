package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import pe.edu.upc.business.crud.IdentificationTypeService;
import pe.edu.upc.model.entity.IdentificationType;

@Named("identificationTypeView")
@ViewScoped
public class IdentificationTypeView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<IdentificationType> identificationTypes;
	private IdentificationType identificationTypeSelected;
	private List<IdentificationType> identificationTypesSelected;
	
	@Inject
	private IdentificationTypeService identificationTypeService;
	
	@PostConstruct
	public void init() {
		identificationTypesSelected = new ArrayList<>();
		try {
			identificationTypes = identificationTypeService.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean hasidentificationTypesSelected() {
		if(identificationTypesSelected.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public boolean hasidentificationTypeSelected() {
		if(identificationTypesSelected.size()==1) {
			return true;
		}
		return false;
	}
	
	public void saveIdentificationType() {
		try {
			identificationTypeService.create(identificationTypeSelected);
			identificationTypes.add(identificationTypeSelected);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('identificationTypeDialog'.hide()");
		PrimeFaces.current().ajax().update("form:identificationTypeDataTable");
	}

	public List<IdentificationType> getIdentificationTypes() {
		return identificationTypes;
	}

	public void setIdentificationTypes(List<IdentificationType> identificationTypes) {
		this.identificationTypes = identificationTypes;
	}

	public IdentificationType getIdentificationTypeSelected() {
		return identificationTypeSelected;
	}

	public void setIdentificationTypeSelected(IdentificationType identificationTypeSelected) {
		this.identificationTypeSelected = identificationTypeSelected;
	}

	public List<IdentificationType> getIdentificationTypesSelected() {
		return identificationTypesSelected;
	}

	public void setIdentificationTypesSelected(List<IdentificationType> identificationTypesSelected) {
		this.identificationTypesSelected = identificationTypesSelected;
	}

	public IdentificationTypeService getIdentificationTypeService() {
		return identificationTypeService;
	}

	public void setIdentificationTypeService(IdentificationTypeService identificationTypeService) {
		this.identificationTypeService = identificationTypeService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}