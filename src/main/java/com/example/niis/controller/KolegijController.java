package com.example.niis.controller;

import com.example.niis.model.Kolegij;
import com.example.niis.service.KolegijService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/kolegiji")
public class KolegijController {

    @Autowired
    private KolegijService kolegijService;

    @GetMapping
    public List<Kolegij> getAllKolegijs() {
        return kolegijService.getAllKolegijs();
    }

    @GetMapping("/{id}")
    public Kolegij getKolegijById(@PathVariable Long id) {
        return kolegijService.getKolegijById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Kolegij was not found by that code"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Kolegij createKolegij(@RequestBody Kolegij kolegij) {
        return kolegijService.createKolegij(kolegij)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Kolegij with the same code already exists"));
    }

    @PostMapping("/add-kolegij")
    public String createKolegijByModel(@ModelAttribute Kolegij  kolegij) {
        kolegijService.createKolegij(kolegij)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Kolegij with the same code already exists"));
        return "Uspješno dodano!";
    }

    @PostMapping("/add-kolegij-unsafe")
    public String createKolegijByModelSql(@ModelAttribute Kolegij  kolegij) {
        kolegijService.createKolegijInsecurely(kolegij)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "Kolegij with the same code already exists"));
        return "Uspješno dodano!";
    }

    @PutMapping("/{id}")
    public Kolegij updateKolegij(@PathVariable Long id, @RequestBody Kolegij kolegijDetails) {
        return kolegijService.updateKolegij(id, kolegijDetails)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Kolegij was not found by that code"));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteKolegij(@PathVariable Long id) {
        kolegijService.deleteKolegij(id);
    }


}
