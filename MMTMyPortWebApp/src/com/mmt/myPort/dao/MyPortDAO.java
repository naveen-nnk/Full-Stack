package com.mmt.myPort.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.mmt.myPort.bo.PortDetails;
import com.mmt.myPort.exception.MyPortException;
import com.mmt.myPort.utils.ConnectionUtil;

public class MyPortDAO {

	public List<PortDetails> fetchPortDetails() throws MyPortException {
		ConnectionUtil connection = new ConnectionUtil();
		List<PortDetails> myPortDtls = new ArrayList<PortDetails>();
		try{  
			Connection mmtDbConn = connection.getConnection();
			Statement stmt=mmtDbConn.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from mmt");  
			Map<String, String> countries = new HashMap<String, String>();
		    for (String iso : Locale.getISOCountries()) {
		        Locale l = new Locale("", iso);
		        countries.put(l.getDisplayCountry(), iso);
		    }
			while(rs.next()){
				PortDetails portDtl = new PortDetails();
				portDtl.setId(rs.getInt(1));
				portDtl.setCode(rs.getString(2));
				portDtl.setLat(rs.getString(3));
				portDtl.setLon(rs.getString(4));
				portDtl.setName(rs.getString(5));
				portDtl.setRating(Math.round(rs.getFloat(6)));
				portDtl.setCity(rs.getString(7));
				portDtl.setState(rs.getString(8));
				portDtl.setCountry(rs.getString(9));
				portDtl.setTz(rs.getString(10));
				portDtl.setType(rs.getString(11));
				portDtl.setUrl(rs.getString(12));
				portDtl.setElev(rs.getString(13));
				portDtl.setDirect_flights(rs.getString(14));
				String code = countries.get(rs.getString(9));
				if(code!=null)
				portDtl.setImgName(code.toLowerCase());
				myPortDtls.add(portDtl);
			}
			connection.closeConnection(mmtDbConn); 
			}catch(Exception e){ 
				e.printStackTrace();
				throw new MyPortException("Database Connectivity Failed");
			}  
		return myPortDtls;
	}

	public List<String> fetchPortTypeDetails() {
		ConnectionUtil connection = new ConnectionUtil();
		List<String> myPortTypeDtls = new ArrayList<String>();
		try{  
			Connection mmtDbConn = connection.getConnection();
			Statement stmt=mmtDbConn.createStatement();  
			ResultSet rs=stmt.executeQuery("select distinct(type) from mmt");  
			while(rs.next()){
				myPortTypeDtls.add(rs.getString(1));
			}
			connection.closeConnection(mmtDbConn); 
			}catch(Exception e){ 
				e.printStackTrace();
			}  
		return myPortTypeDtls;
	}

	public List<PortDetails> fetchPortDetails(List<String> selectedPortType) {
		ConnectionUtil connection = new ConnectionUtil();
		List<PortDetails> myPortDtlsFilter = new ArrayList<PortDetails>();
		try{  
			Connection mmtDbConn = connection.getConnection();
			StringBuilder builder = new StringBuilder();
			for( int i = 0 ; i < selectedPortType.size(); i++ ) {
			    builder.append("?,");
			}

			String qStmt = "select * from mmt where type in (" + builder.deleteCharAt( builder.length() -1 ).toString()+")";
			PreparedStatement stmt = mmtDbConn.prepareStatement(qStmt);
			int typeCount = 0;
			for( int k=0;k<selectedPortType.size();k++ ) {
				stmt.setString( ++typeCount,selectedPortType.get(k) );  
			}
			ResultSet rs=stmt.executeQuery();  
			Map<String, String> countries = new HashMap<String, String>();
		    for (String iso : Locale.getISOCountries()) {
		        Locale l = new Locale("", iso);
		        countries.put(l.getDisplayCountry(), iso);
		    }
			while(rs.next()){
				PortDetails portDtl = new PortDetails();
				portDtl.setId(rs.getInt(1));
				portDtl.setCode(rs.getString(2));
				portDtl.setLat(rs.getString(3));
				portDtl.setLon(rs.getString(4));
				portDtl.setName(rs.getString(5));
				portDtl.setRating(Math.round(rs.getFloat(6)));
				portDtl.setCity(rs.getString(7));
				portDtl.setState(rs.getString(8));
				portDtl.setCountry(rs.getString(9));
				portDtl.setTz(rs.getString(10));
				portDtl.setType(rs.getString(11));
				portDtl.setUrl(rs.getString(12));
				portDtl.setElev(rs.getString(13));
				portDtl.setDirect_flights(rs.getString(14));
				String code = countries.get(rs.getString(9));
				if(code!=null)
				portDtl.setImgName(code.toLowerCase());
				myPortDtlsFilter.add(portDtl);
			}
			connection.closeConnection(mmtDbConn); 
			}catch(Exception e){ 
				e.printStackTrace();
			}  
		return myPortDtlsFilter;
	}

	public List<PortDetails> fetchPortDetailsSort(String sortBy) throws MyPortException {
		ConnectionUtil connection = new ConnectionUtil();
		List<PortDetails> myPortDtlsSort = new ArrayList<PortDetails>();
		try{  
			Connection mmtDbConn = connection.getConnection();
			String qStmt = "select * from mmt order by ? desc";
			PreparedStatement stmt = mmtDbConn.prepareStatement(qStmt);
			stmt.setString(1, sortBy);
			ResultSet rs=stmt.executeQuery();  
			Map<String, String> countries = new HashMap<String, String>();
		    for (String iso : Locale.getISOCountries()) {
		        Locale l = new Locale("", iso);
		        countries.put(l.getDisplayCountry(), iso);
		    }
			while(rs.next()){
				PortDetails portDtl = new PortDetails();
				portDtl.setId(rs.getInt(1));
				portDtl.setCode(rs.getString(2));
				portDtl.setLat(rs.getString(3));
				portDtl.setLon(rs.getString(4));
				portDtl.setName(rs.getString(5));
				portDtl.setRating(Math.round(rs.getFloat(6)));
				portDtl.setCity(rs.getString(7));
				portDtl.setState(rs.getString(8));
				portDtl.setCountry(rs.getString(9));
				portDtl.setTz(rs.getString(10));
				portDtl.setType(rs.getString(11));
				portDtl.setUrl(rs.getString(12));
				portDtl.setElev(rs.getString(13));
				portDtl.setDirect_flights(rs.getString(14));
				String code = countries.get(rs.getString(9));
				if(code!=null)
				portDtl.setImgName(code.toLowerCase());
				myPortDtlsSort.add(portDtl);
			}
			connection.closeConnection(mmtDbConn); 
			}catch(Exception e){ 
				e.printStackTrace();
				throw new MyPortException("Database Connectivity Failed");
			}  
		return myPortDtlsSort;
	}

}
