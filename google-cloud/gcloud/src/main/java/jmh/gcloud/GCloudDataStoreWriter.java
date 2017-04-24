package jmh.gcloud;

import java.util.List;

import jmh.gcloud.dao.FunDAO;
import jmh.gcloud.dao.FunDAOImpl;
import jmh.gcloud.data.FunProfile;

public class GCloudDataStoreWriter {

	private FunDAO funDAO = null;
	
	public GCloudDataStoreWriter() {
		this.funDAO = new FunDAOImpl();
	}
	public FunProfile getFunProfileBySwid(String swid) {
		return funDAO.getFunProfileBySwid(swid);
	}
	
	public List<String> getSomeSwids() {
		return funDAO.getSomeSwids();
	}
	
	public static void main(String[] args) {

		GCloudDataStoreWriter gw = new GCloudDataStoreWriter();
		
		String swid = "{0078AE36-582E-4179-B8AE-36582ED17938}";
		FunProfile funProfile = gw.getFunProfileBySwid(swid);
		if (funProfile == null) {
			System.out.println("profile not found for swid:" + swid);
		} else {
			funProfile.print();
		}
		
		List<String> swids = gw.getSomeSwids();
		for (String s : swids) {
			System.out.println(s);
		}
		
		
	}
}
