package com.example.niis.service;

import com.example.niis.model.Kolegij;
import com.example.niis.repository.KolegijRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KolegijService {

    @Autowired
    private KolegijRepository kolegijRepository;

    public List<Kolegij> getAllKolegijs() {
        return kolegijRepository.findAll();
    }

    public Optional<Kolegij> getKolegijById(Long id) {
        return kolegijRepository.findById(id);
    }

    public Optional<Kolegij> createKolegij(Kolegij kolegij) {
        if(kolegij.getId() != null && kolegijRepository.existsById(kolegij.getId())){
            return Optional.empty();
        }
        return Optional.of(kolegijRepository.save(kolegij));
    }

    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public Optional<Kolegij> createKolegijInsecurely(Kolegij kolegij) {
        String insertQuery = "INSERT INTO kolegij (ects, name) VALUES ("
                + kolegij.getEcts() + ", '"
                + kolegij.getName() + "')";
        entityManager.createNativeQuery(insertQuery).executeUpdate();

        return Optional.of(kolegij);
    }


    public Optional<Kolegij> updateKolegij(Long id, Kolegij kolegijDetails) {
        Optional<Kolegij> kolegij = kolegijRepository.findById(id);
        kolegij.map( k -> {
                    k.setName(kolegijDetails.getName());
                    k.setEcts(kolegijDetails.getEcts());
                    kolegijRepository.save(k);
                    return k;
                }
        );
        return kolegij;
    }

    public void deleteKolegij(Long id) {
        kolegijRepository.deleteById(id);
    }
    
}
