package jmh.gcloud;

import java.io.PrintWriter;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.DateTime;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery;

public class GCloudDataStoreWriter 
{
	
    public static void main( String[] args )
    {
    	
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        KeyFactory keyFactory = datastore.newKeyFactory().setKind("visit");
        IncompleteKey key = keyFactory.setKind("visit").newKey();

        // Record a visit to the datastore, storing the IP and timestamp.
        FullEntity<IncompleteKey> curVisit = FullEntity.newBuilder(key)
            .set("user_ip", "10.45").set("timestamp", DateTime.now()).build();
        datastore.add(curVisit);

        // Retrieve the last 10 visits from the datastore, ordered by timestamp.
        Query<Entity> query = Query.newEntityQueryBuilder().setKind("visit")
            .setOrderBy(StructuredQuery.OrderBy.desc("timestamp")).setLimit(10).build();
        QueryResults<Entity> results = datastore.run(query);

        System.out.print("Last 10 visits:\n");
        while (results.hasNext()) {
          Entity entity = results.next();
          System.out.format("Time: %s Addr: %s\n", entity.getDateTime("timestamp"),
              entity.getString("user_ip"));
        }
    }
}
