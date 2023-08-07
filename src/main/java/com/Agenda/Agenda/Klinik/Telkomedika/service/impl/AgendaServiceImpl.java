package com.Agenda.Agenda.Klinik.Telkomedika.service.impl;

import com.Agenda.Agenda.Klinik.Telkomedika.dto.AgendaDTO;
import com.Agenda.Agenda.Klinik.Telkomedika.entity.AgendaEntity;
import com.Agenda.Agenda.Klinik.Telkomedika.repository.AgendaRepository;
import com.Agenda.Agenda.Klinik.Telkomedika.service.AgendaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaServiceImpl implements AgendaService {
    private final AgendaRepository agendaRepository;

    public AgendaServiceImpl(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    @Override
    public List<AgendaEntity> findAllAgenda() {
        return agendaRepository.findAll();
    }

    @Override
    public Optional<AgendaEntity> findById(Long id) {
        return agendaRepository.findById(id);
    }

    @Override
    public AgendaEntity saveAgenda(AgendaEntity agendaEntity) {
        return agendaRepository.save(agendaEntity);
    }

    @Override
    public AgendaDTO updateAgenda(Long id, AgendaDTO agendaDTO) {
        Agenda agenda = agendaRepository.findById(id).orElse(null);

        if (agenda != null) {
//            modelMapper.map(transactionDTO, transaction);
            if(agendaDTO.judul() != null) {
                agenda.setJudul(agendaDTO.judul());
            } if(agendaDTO.deskripsi() != null) {
                agenda.setDeskripsi(agendaDTO.deskripsi() );
            } if(agendaDTO.waktu() != null) {
                agenda.setWaktu(agendaDTO.waktu() );
            }

            Agenda savedAgenda = agendaRepository.save(agenda);
            return modelMapper.map(savedAgenda, AgendaDTO.class);
        }
        return null;
    }

    @Override
    public void deleteAgenda(Long id) {
        agendaRepository.deleteById(id);
    }
    ObjectMapper mapper = new ObjectMapper();
    @Override
    public AgendaDTO mapToDTO(AgendaEntity agendaEntity) {
        return mapper.convertValue(agendaEntity, AgendaDTO.class);
    }

    @Override
    public AgendaEntity mapToEntity(AgendaDTO agendaDTO) {
        return mapper.convertValue(agendaDTO, AgendaEntity.class);
    }
}

