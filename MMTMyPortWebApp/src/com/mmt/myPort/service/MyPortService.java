package com.mmt.myPort.service;

import java.util.List;

import com.mmt.myPort.bo.PortDetails;
import com.mmt.myPort.dao.MyPortDAO;
import com.mmt.myPort.exception.MyPortException;

public class MyPortService {
	
	public List<PortDetails> fetchPortDetails() throws MyPortException{
		MyPortDAO portDao = new MyPortDAO();
		List<PortDetails> portServiceDtls = portDao.fetchPortDetails();
		return portServiceDtls;
	}

	public List<String> fetchPortTypeDetails() {
		MyPortDAO portDao = new MyPortDAO();
		List<String> portTypeDtls = portDao.fetchPortTypeDetails();
		return portTypeDtls;
	}

	public List<PortDetails> fetchPortDetails(List<String> selectedPortType) {
		MyPortDAO portDao = new MyPortDAO();
		List<PortDetails> portServiceDtls = portDao.fetchPortDetails(selectedPortType);
		return portServiceDtls;
	}

	public List<PortDetails> fetchPortDetailsSort(String sortBy) throws MyPortException {
		MyPortDAO portDao = new MyPortDAO();
		List<PortDetails> portServiceSortDtls = portDao.fetchPortDetailsSort(sortBy);
		return portServiceSortDtls;
	}

}
