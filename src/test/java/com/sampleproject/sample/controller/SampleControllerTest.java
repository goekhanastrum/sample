package com.sampleproject.sample.controller;

import com.sampleproject.sample.entity.Sample;
import com.sampleproject.sample.repository.SampleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.Optional;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit-Tests für SampleController.
 */
public class SampleControllerTest {
    @Mock
    private SampleRepository repository;

    @InjectMocks
    private SampleController controller;

    /**
     * Initialisiert Mocks vor jedem Test.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Testet getAll-Methode.
     */
    @Test
    public void testGetAll() {
        Sample sample1 = new Sample();
        sample1.setId(1L);
        sample1.setName("Test1");
        Sample sample2 = new Sample();
        sample2.setId(2L);
        sample2.setName("Test2");
        when(repository.findAll()).thenReturn(Arrays.asList(sample1, sample2));
        List<Sample> result = controller.getAll();
        assertEquals(2, result.size());
        assertEquals("Test1", result.get(0).getName());
    }

    /**
     * Testet getById, wenn Sample gefunden wird.
     */
    @Test
    public void testGetByIdFound() {
        Sample sample = new Sample();
        sample.setId(1L);
        sample.setName("Test");
        when(repository.findById(1L)).thenReturn(Optional.of(sample));
        Sample result = controller.getById(1L);
        assertNotNull(result);
        assertEquals("Test", result.getName());
    }

    /**
     * Testet getById, wenn Sample nicht gefunden wird.
     */
    @Test
    public void testGetByIdNotFound() {
        when(repository.findById(99L)).thenReturn(Optional.empty());
        Sample result = controller.getById(99L);
        assertNull(result);
    }

    /**
     * Testet create-Methode.
     */
    @Test
    public void testCreate() {
        Sample sample = new Sample();
        sample.setName("New");
        when(repository.save(sample)).thenReturn(sample);
        Sample result = controller.create(sample);
        assertEquals("New", result.getName());
    }

    /**
     * Testet update-Methode, wenn Sample gefunden wird.
     */
    @Test
    public void testUpdateFound() {
        Sample existing = new Sample();
        existing.setId(1L);
        existing.setName("Old");
        Sample update = new Sample();
        update.setName("Updated");
        when(repository.findById(1L)).thenReturn(Optional.of(existing));
        when(repository.save(existing)).thenReturn(existing);
        Sample result = controller.update(1L, update);
        assertEquals("Updated", result.getName());
    }

    /**
     * Testet update-Methode, wenn Sample nicht gefunden wird.
     */
    @Test
    public void testUpdateNotFound() {
        Sample update = new Sample();
        update.setName("Updated");
        when(repository.findById(99L)).thenReturn(Optional.empty());
        Sample result = controller.update(99L, update);
        assertNull(result);
    }
}
