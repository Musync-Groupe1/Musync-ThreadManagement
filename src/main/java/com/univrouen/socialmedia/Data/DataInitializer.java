package com.univrouen.socialmedia.Data;

import com.univrouen.socialmedia.Entity.User;
import com.univrouen.socialmedia.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class DataInitializer implements CommandLineRunner {

    UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUserId("d0ebb898-6f43-4080-aebe-0016f4400c24");
        user.setFirstName("test");
        user.setLastName("test");
        user.setEmail("test@test.fr");
        user.setGender("Male");
        user.setBirthday(new Date(2002, 1, 1).toLocalDate());
        userRepository.save(user);

        user = new User();
        user.setUserId("e2dc848c-e6bd-4734-b374-95c72a0617cf");
        user.setFirstName("Jean");
        user.setLastName("Dupont");
        user.setEmail("azd@azd.fr");
        user.setGender("Male");
        user.setBirthday(new Date(2004, 5, 15).toLocalDate());
        userRepository.save(user);




        System.out.println("Données d'échantillon insérées !");
    }

}
