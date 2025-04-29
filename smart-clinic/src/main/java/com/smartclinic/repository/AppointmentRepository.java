package com.smartclinic.repository;

import com.smartclinic.entity.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, Long> {
    List<Appointment> findByDoctorId(Long doctorId);

}

