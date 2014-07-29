package perso.userform.configuration;

import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.name.Names;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import org.jongo.MongoCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import perso.userform.db.MongoSource;
import perso.userform.repository.UserRepository;
import perso.userform.web.resources.UserResource;

import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

public class UserFormModule extends JerseyServletModule {

    private static final Logger log = LoggerFactory.getLogger(UserFormModule.class);

    @Override
    protected void configureServlets() {
        bind(UserRepository.class).in(Scopes.SINGLETON);
        bind(MongoSource.class).in(Scopes.SINGLETON);
        bind(UserResource.class);

        Properties properties = loadProperties();

        Names.bindProperties(binder(), properties);


        serve("/resources/*").with(GuiceContainer.class, Collections.singletonMap("com.sun.jersey.api.json.POJOMappingFeature", "true"));
    }

    @Provides
    public MongoCollection userCollection(MongoSource mongoSource) {
        return mongoSource.getClient().getCollection("user");
    }

    private Properties loadProperties() {
        Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/userForm.properties"));
        } catch (IOException e) {
            log.error("Error to load userForm.properties", e);
        }
        return properties;
    }
}
