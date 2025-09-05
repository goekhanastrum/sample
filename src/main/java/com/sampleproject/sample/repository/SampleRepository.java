package com.sampleproject.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sampleproject.sample.entity.Sample;

/**
 * Repository für Sample-Entitäten.
 */
public interface SampleRepository extends JpaRepository<Sample, Long> {
}
