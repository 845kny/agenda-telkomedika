package com.Agenda.Agenda.Klinik.Telkomedika.repository;

import com.Agenda.Agenda.Klinik.Telkomedika.entity.AgendaEntity;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<AgendaEntity, Long> {
}
