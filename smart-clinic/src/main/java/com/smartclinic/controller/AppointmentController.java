package com.smartclinic.controller;

import com.smartclinic.entity.Appointment;
import com.smartclinic.repository.AppointmentRepository;
import com.smartclinic.repository.DoctorRepository;
import com.smartclinic.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentRepository repo;
    @Autowired private DoctorRepository doctorRepo;
    @Autowired private PatientRepository patientRepo;

    @PostMapping
    @PreAuthorize("hasAuthority('PATIENT')")
    public Appointment book(@RequestParam Long doctorId, @RequestParam Long patientId,
                            @RequestParam String datetime) {
        Appointment appt = new Appointment();
        appt.setDoctor(doctorRepo.findById(doctorId).get());
        appt.setPatient(patientRepo.findById(patientId).get());
        appt.setAppointmentDate(LocalDateTime.parse(datetime));
        appt.setStatus("BOOKED");
        return repo.save(appt);
    }

    @GetMapping("/doctor/{id}")
    @PreAuthorize("hasAnyAuthority('DOCTOR','ADMIN')")
    public List<Appointment> getDoctorAppointments(@PathVariable Long id) {
        return repo.findByDoctorId(id);
    }

    @PutMapping("/{id}/cancel")
    @PreAuthorize("hasAnyAuthority('PATIENT','ADMIN')")
    public Appointment cancel(@PathVariable Long id) {
        Appointment appt = repo.findById(id).get();
        appt.setStatus("CANCELLED");
        return repo.save(appt);
    }
}
