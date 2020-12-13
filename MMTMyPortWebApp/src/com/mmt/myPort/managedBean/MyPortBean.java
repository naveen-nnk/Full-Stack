package com.mmt.myPort.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.mmt.myPort.bo.PortDetails;
import com.mmt.myPort.exception.MyPortException;
import com.mmt.myPort.service.MyPortService;

@ManagedBean(name = "myPort")
@ViewScoped
public class MyPortBean {
	
	private List<PortDetails> portTableDtls;
	private List<PortDetails> filteredPortTableDtl;
	private List<String> portType;
	private List<String> selectedPortType;
	private String sortBy;
	
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public List<String> getPortType() {
		return portType;
	}
	public void setPortType(List<String> portType) {
		this.portType = portType;
	}
	public List<String> getSelectedPortType() {
		return selectedPortType;
	}
	public void setSelectedPortType(List<String> selectedPortType) {
		this.selectedPortType = selectedPortType;
	}
	public List<PortDetails> getFilteredPortTableDtl() {
		return filteredPortTableDtl;
	}
	public void setFilteredPortTableDtl(List<PortDetails> filteredPortTableDtl) {
		this.filteredPortTableDtl = filteredPortTableDtl;
	}
	public List<PortDetails> getPortTableDtls() {
		return portTableDtls;
	}
	public void setPortTableDtls(List<PortDetails> portTableDtls) {
		this.portTableDtls = portTableDtls;
	}
	public void fetchPortDetails(){
		MyPortService portService = new MyPortService();
		try{
			if(sortBy!=null){
				portTableDtls = portService.fetchPortDetailsSort(sortBy);
			}else if(null!=portTableDtls){
				if(portTableDtls.size()<1)
					portTableDtls = portService.fetchPortDetails();
				else if(selectedPortType!=null&&selectedPortType.size()>0)
					portTableDtls = portService.fetchPortDetails(selectedPortType);
			}else{
				portTableDtls = new ArrayList<PortDetails>();
				portTableDtls = portService.fetchPortDetails();
			}
			if(selectedPortType!=null&&selectedPortType.size()<1)
				portTableDtls = portService.fetchPortDetails();
			if(null!=portType){
				if(portType.size()<1){
					portType = portService.fetchPortTypeDetails();
				}
			}else{
				portType = new ArrayList<String>();
				portType = portService.fetchPortTypeDetails();
			}
		}catch(MyPortException e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Database Connection Failed. Please change database properties in properties file and try again."));
		}
		
	}
}
