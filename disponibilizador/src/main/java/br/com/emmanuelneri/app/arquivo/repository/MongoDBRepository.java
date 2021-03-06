package br.com.emmanuelneri.app.arquivo.repository;

import br.com.emmanuelneri.DisponibilizadorProperties;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MongoDBRepository {

    private static final String COLLECTION_NOTA_FISCAL_XML = "notaFiscalXml";

    @Autowired
    private DisponibilizadorProperties properties;

    public Iterable<Document> find() {
        return getDatabase().getCollection(COLLECTION_NOTA_FISCAL_XML).find();
    }

    public Document findFirst(Document document) {
        return getDatabase().getCollection(COLLECTION_NOTA_FISCAL_XML).find(document).first();
    }

    private MongoDatabase getDatabase() {
        return client().getDatabase(properties.getMongoDataBase());
    }

    private MongoClient client() {
        return new MongoClient(properties.getMongoHost(), properties.getMongoPort());
    }

}
