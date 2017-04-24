package jmh.gcloud.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.DateTime;
import com.google.cloud.datastore.DateTimeValue;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.LongValue;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;

import com.google.api.client.googleapis.extensions.appengine.auth.oauth2.AppIdentityCredential;

import jmh.gcloud.data.FunProfile;

public class FunDAOImpl implements FunDAO {
	
	private Datastore datastore = null;
	private KeyFactory keyFactory = null;
	
	public FunDAOImpl() {
		
		GoogleCredential credential = null;
		try {
			
//			AppIdentityCredential cred =
//			    new AppIdentityCredential(Collections.singleton("https://www.googleapis.com/auth/datastore"));
			
			credential = GoogleCredential.fromStream(new FileInputStream("dtss-guy-project-76f3adf410db.json"))
			    .createScoped(Collections.singleton("https://www.googleapis.com/auth/datastore"));
		}
		catch (IOException e) {
			System.err.println("bummer with credential:" + e.getMessage());
		}
		this.datastore = DatastoreOptions.getDefaultInstance().getService();
	}

	public FunProfile getFunProfileBySwid(String swid) {
		
        keyFactory = datastore.newKeyFactory().setKind("account-tiny-sample-2");
        Key key = keyFactory.setKind("account-tiny-sample-2").newKey(swid);
		
		FunProfile funProfile = new FunProfile();
		Query<Entity> query = Query.newEntityQueryBuilder().setKind("account-tiny-sample-2")
				.filter(PropertyFilter.eq("__key__", key)).build();
		QueryResults<Entity> results = datastore.run(query);

		if (!results.hasNext()) {
			return null;
		}
		
		Entity entity = results.next();
		funProfile.setSwid(entity.getKey().getName());
		funProfile.setFirstName(entity.getString("FirstName"));
		funProfile.setAffiliateName(entity.getString("AffiliateName"));
		
		DateTime d = entity.getDateTime("DateCreated");
		String td = d.toString();
		
		funProfile.setBirthday(new Date(entity.getDateTime("Birthday").getTimestampMillis()));
		funProfile.setDateCreated(new Date(entity.getDateTime("DateCreated").getTimestampMillis()));
		funProfile.setDateModified(new Date(entity.getDateTime("DateModified").getTimestampMillis()));
		funProfile.setDateRegistered(new Date(entity.getDateTime("DateRegistered").getTimestampMillis()));

		funProfile.setEmailAddress(entity.getString("EmailAddress"));
		funProfile.setGender(entity.getString("Gender"));
		funProfile.setISOCountryCode(entity.getString("ISOCountryCode"));
		funProfile.setInitial(entity.getString("Initial"));
		funProfile.setLastName(entity.getString("LastName"));
		
		funProfile.setParentEmailAddress(entity.getString("ParentEmailAddress"));
		funProfile.setPassword(entity.getString("Password"));
		funProfile.setPrefix(entity.getString("Prefix"));
		funProfile.setSourceName(entity.getString("SourceName"));
		funProfile.setStatus(entity.getString("Status"));
		funProfile.setSuffix(entity.getString("Suffix"));
		
		String tmp = entity.getString("TestAccount");
		funProfile.setTestAccount(entity.getString("TestAccount"));
		funProfile.setUsername(entity.getString("Username"));
		funProfile.setValidated(entity.getString("Validated"));
		
		funProfile.setModifiedBy(entity.getLong("ModifiedBy"));
		funProfile.setIsPrimary(entity.getLong("is_primary"));
		
		return funProfile;
	}
	
	public List<String> getSomeSwids() {
		
		List<String> swids = new ArrayList<String>();
		
        Query<Entity> query = Query.newEntityQueryBuilder().setKind("account-tiny-sample-2")
            .setLimit(10).build();
        QueryResults<Entity> results = datastore.run(query);
		
        while (results.hasNext()) {
        	Entity entity = results.next();
    		swids.add(entity.getKey().getName());
        }
        return swids;
	}
}
