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
        user.setUser_id("914d643b-7bb5-4eed-a1f2-77899680b97e");
        user.setFirst_name("test");
        user.setLast_name("test");
        user.setEmail("test@test.fr");
        user.setGender("Male");
        user.setBirthday(new Date(2002, 1, 1));
        userRepository.save(user);

        user = new User();
        user.setUser_id("e2dc848c-e6bd-4734-b374-95c72a0617cf");
        user.setFirst_name("Jean");
        user.setLast_name("Dupont");
        user.setEmail("azd@azd.fr");
        user.setGender("Male");
        user.setBirthday(new Date(2004, 5, 15));
        userRepository.save(user);




        System.out.println("Données d'échantillon insérées !");
    }

}
