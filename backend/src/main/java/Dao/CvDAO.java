package Dao;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import database.MongoBDConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import models.Cv;
import org.bson.Document;

public class CvDAO {

    private MongoCollection<Document> collection;
    private MongoBDConnection databaseConnection;

    public CvDAO() {
        databaseConnection = new MongoBDConnection();
        collection = databaseConnection.getDatabase().getCollection("cv-collection");
    }

    public void insertCv(Cv cv) {
        Map<String, Object> cvHashMap = cv.getCvHashMap();
        Document data = new Document(cvHashMap);
        collection.insertOne(data);
    }

    public List<Document> getCvs(String idUser) {
        List<Document> cvList = new ArrayList<>();
        try (MongoCursor<Document> cursor = collection.find(eq("idUser", idUser)).iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                cvList.add(doc);
            }
            return cvList;
        }
    }

    public Document getOneCv(String idUser, String id) {
        Document document;
        document = collection.find(eq("id", id)).first();
        return document;
    }
    
    public boolean updateOneCv(Cv cv, String id){
        Map<String, Object> cvHashMap = cv.getCvHashMap();
        Document data = new Document(cvHashMap);
        Document query = new Document("id",id);
        Document updateData = new Document("$set", data);
        UpdateResult result = collection.updateOne(query, updateData);
        
        return result.getModifiedCount() > 0;
    }
    
    public boolean deleteOneCv(String id){
        Document query = new Document("id", id);
        DeleteResult result = collection.deleteOne(query);
        return result.getDeletedCount() > 0;
    }
}
