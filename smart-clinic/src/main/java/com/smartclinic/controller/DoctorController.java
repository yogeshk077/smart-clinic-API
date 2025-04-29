package com.smartclinic.controller;

import com.smartclinic.entity.Doctor;
import com.smartclinic.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository repo;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','DOCTOR')")
    public Doctor create(@RequestBody Doctor d) { return repo.save(d); }

    @GetMapping
    public List<Doctor> list() { return repo.findAll(); }
}
