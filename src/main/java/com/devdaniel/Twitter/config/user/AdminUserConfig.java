package com.devdaniel.Twitter.config.user;

import com.devdaniel.Twitter.entities.Role;
import com.devdaniel.Twitter.entities.User;
import com.devdaniel.Twitter.repositories.RoleRepository;
import com.devdaniel.Twitter.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;
import java.util.Set;

@Configuration
@AllArgsConstructor
public class AdminUserConfig implements CommandLineRunner {

    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) {

        Role adminRole = roleRepository.findByName(Role.Values.ADMIN.name());

        userRepository.findByUsername("admin")
                .ifPresentOrElse(
                        user -> System.out.println("admin já existe"),
                        () -> {
                            User user = new User();
                            user.setUsername("admin");
                            user.setPassword(passwordEncoder.encode("123"));
                            user.setRoles(Set.of(adminRole));
                            userRepository.save(user);
                        }
                );
    }

}
