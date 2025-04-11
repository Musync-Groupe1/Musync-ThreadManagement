package com.univrouen.socialmedia.Data;

import com.univrouen.socialmedia.Entity.User;
import com.univrouen.socialmedia.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Profile("dev")
@Component
public class DataInitializer implements CommandLineRunner {

    UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // id test : 567423b7-1e35-4894-8e12-c48f64628b54 username : test password : test nom : Dupont prénom : Jean email : test@test.fr
       /* User user = new User();
        user.setUser_id("567423b7-1e35-4894-8e12-c48f64628b54");
        user.setFirst_name("Jean");
        user.setLast_name("Dupont");
        user.setEmail("test@test.fr");
        user.setGender("Male");
        user.setBirthday(new Date(2002, 1, 1));
        userRepository.save(user);

        // id azd : 856b4f12-282f-44bf-9b1f-f28a384aecef, username : azd, password : azd, nom: azd, prénom : azd, email : azd@azd.fr
        user = new User();
        user.setUser_id("856b4f12-282f-44bf-9b1f-f28a384aecef");
        user.setFirst_name("azd");
        user.setLast_name("azd");
        user.setEmail("azd@azd.fr");
        user.setGender("Male");
        user.setBirthday(new Date(2004, 5, 15));
        userRepository.save(user);




        System.out.println("Données d'échantillon insérées !");*/
    }

}
