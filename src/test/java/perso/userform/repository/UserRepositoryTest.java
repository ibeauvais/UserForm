package perso.userform.repository;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;
import perso.userform.domain.User;
import perso.userform.configuration.UserFormModule;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRepositoryTest {

    private UserRepository userRepository;

    @Before
    public void setUp() {
        Injector injector = Guice.createInjector(new UserFormModule());
        userRepository = injector.getInstance(UserRepository.class);
    }

    @Test
    public void should_create_user() {

        User user = new User().withFirstname("ivan").withLastname("beauvais");


        userRepository.createUser(user);


        assertThat(user._id).isNotNull();
    }
}
