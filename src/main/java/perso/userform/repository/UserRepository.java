package perso.userform.repository;

import com.google.inject.Inject;
import com.mongodb.WriteResult;
import org.jongo.MongoCollection;
import perso.userform.domain.User;


public class UserRepository {

    private MongoCollection userCollection;

    @Inject
    public UserRepository(MongoCollection userCollection) {
        this.userCollection = userCollection;
    }

    public Iterable<User> findAll() {
        return userCollection.find().as(User.class);
    }

    public void createUser(User user) {
        WriteResult save = userCollection.save(user);
        System.out.println(save);
    }
}
