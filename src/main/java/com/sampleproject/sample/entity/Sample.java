package com.sampleproject.sample.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entity-Klasse für Sample.
 */
@Entity
public class Sample {
    /**
     * Eindeutige ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Name des Samples.
     */
    private String name;

    /**
     * Gibt die ID zurück.
     * @return die ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Setzt die ID.
     * @param newId die neue ID
     */
    public void setId(final Long newId) {
        this.id = newId;
    }

    /**
     * Gibt den Namen zurück.
     * @return der Name
     */
    public String getName() {
        return name;
    }

    /**
     * Setzt den Namen.
     * @param newName der neue Name
     */
    public void setName(final String newName) {
        this.name = newName;
    }

}
