package com.sampleproject.sample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sampleproject.sample.entity.Sample;
import com.sampleproject.sample.repository.SampleRepository;

/**
 * REST-Controller für Sample-Entitäten.
 */
@RestController
@RequestMapping("/api/samples")
public class SampleController {

    @Autowired
    private SampleRepository repository;

    /**
     * Gibt alle Samples zurück.
     * @return Liste aller Samples
     */
    @GetMapping
    public List<Sample> getAll() {
        return repository.findAll();
    }

    /**
     * Gibt ein Sample nach ID zurück.
     * @param id die ID
     * @return das Sample oder null
     */
    @GetMapping("/{id}")
    public Sample getById(@PathVariable final Long id) {
        Optional<Sample> sample = repository.findById(id);
        return sample.orElse(null);
    }

    /**
     * Erstellt ein neues Sample.
     * @param sample das Sample
     * @return das gespeicherte Sample
     */
    @PostMapping
    public Sample create(@RequestBody final Sample sample) {
        return repository.save(sample);
    }

    /**
     * Aktualisiert ein Sample.
     * @param id die ID
     * @param sampleDetails die neuen Daten
     * @return das aktualisierte Sample oder null
     */
    @PutMapping("/{id}")
    public Sample update(@PathVariable final Long id, @RequestBody final Sample sampleDetails) {
        Optional<Sample> optionalSample = repository.findById(id);
        if (optionalSample.isPresent()) {
            Sample sample = optionalSample.get();
            sample.setName(sampleDetails.getName());
            return repository.save(sample);
        } else {
            return null;
        }
    }
}
