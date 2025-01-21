package com.example.niis.database;

import com.example.niis.model.Kolegij;
import com.example.niis.repository.KolegijRepository;
import com.example.niis.security.UserInfo;
import com.example.niis.security.UserRepository;
import com.example.niis.security.UserRole;
import com.example.niis.security.UserRoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Service
public class DataInitializer {

    @Autowired
    private KolegijRepository kolegijRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initData() {
        kolegijRepository.save(new Kolegij(null, "Interoperabilnost sustava", 6));
        kolegijRepository.save(new Kolegij(null, "Pisanje sigurnog koda", 7));
        kolegijRepository.save(new Kolegij(null, "Osnove računalnog vida", 5));
        kolegijRepository.save(new Kolegij(null, "Napredne programske paradigme", 4));
        kolegijRepository.save(new Kolegij(null, "Brzi razvoj Java aplikacija", 4));

        UserRole userRole = new UserRole("ADMIN");

        Set<UserRole> roles = new HashSet<>();
        roles.add(userRole);

        userRoleRepository.save(userRole);

        userRepository.save(new UserInfo("test", passwordEncoder.encode("test"), roles));

        System.out.println("Sample Kolegijs added to H2 database.");
    }
}
