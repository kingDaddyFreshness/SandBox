package jmh.gcloud.dao;

import java.util.List;

import jmh.gcloud.data.FunProfile;

public interface FunDAO {
	
	FunProfile getFunProfileBySwid(String swid);

	List<String> getSomeSwids();

}
