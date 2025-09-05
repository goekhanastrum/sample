package com.sampleproject.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sampleproject.sample.entity.Sample;

public interface SampleRepository extends JpaRepository<Sample, Long> {}