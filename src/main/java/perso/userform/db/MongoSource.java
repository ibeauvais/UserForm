package perso.userform.db;

import com.google.inject.name.Named;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.jongo.Jongo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.net.UnknownHostException;

public class MongoSource {

    private static final Logger log = LoggerFactory.getLogger(MongoSource.class);

    private Jongo jongo;

    @Inject
    public MongoSource(@Named("mongodb.host") String host, @Named("mongodb.port") int port, @Named("mongodb.login") String login, @Named("mongodb.password") String password, @Named("mongodb.dbname") String dbname) {

        DB db;
        try {
            db = new MongoClient(host, port).getDB(dbname);
            jongo = new Jongo(db);

        } catch (UnknownHostException e) {
            log.error("MongoSource ", e);
        }
    }

    public Jongo getClient() {
        return jongo;
    }
}
