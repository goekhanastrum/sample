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

@RestController
@RequestMapping("/api/samples")
public class SampleController {

    @Autowired
    private SampleRepository repository;

    @GetMapping
    public List<Sample> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Sample getById(@PathVariable Long id) {
        Optional<Sample> sample = repository.findById(id);
        return sample.orElse(null);
    }

    @PostMapping
    public Sample create(@RequestBody Sample sample) {
        return repository.save(sample);
    }

    @PutMapping("/{id}")
    public Sample update(@PathVariable Long id, @RequestBody Sample sampleDetails) {
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