package com.univrouen.socialmedia.Data;

import com.univrouen.socialmedia.Entity.User;
import com.univrouen.socialmedia.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUserId("64e2a957-6780-4b08-addf-be727004e743");
        user.setFirstName("test");
        user.setLastName("test");
        user.setEmail("test@test.fr");
        user.setGender("Male");
        user.setBirthday(LocalDate.of(2002, 1, 1));
        userRepository.save(user);

        user = new User();
        user.setUserId("29a69e09-103f-4d2e-beaa-097a29e79a99");
        user.setFirstName("Jean");
        user.setLastName("Dupont");
        user.setEmail("azd@azd.fr");
        user.setGender("Male");
        user.setBirthday(LocalDate.of(2002, 1, 1));
        userRepository.save(user);




        System.out.println("Données d'échantillon insérées !");
    }

}
