package com.smartclinic.controller;

import com.smartclinic.entity.Patient;
import com.smartclinic.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    private PatientRepository repo;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','PATIENT')")
    public Patient create(@RequestBody Patient p) { return repo.save(p); }

    @GetMapping
    public List<Patient> list() { return repo.findAll(); }
}
