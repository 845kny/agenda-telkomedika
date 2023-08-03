package com.Agenda.Agenda.Klinik.Telkomedika.Controller;
import com.Agenda.Agenda.Klinik.Telkomedika.dto.AgendaDTO;
import com.Agenda.Agenda.Klinik.Telkomedika.entity.AgendaEntity;
import com.Agenda.Agenda.Klinik.Telkomedika.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
    @Autowired
    AgendaService agendaService;
    @GetMapping
    public List<AgendaDTO> findAllAgenda(){
        return agendaService.findAllAgenda().stream().map(obatEntity -> agendaService.mapToDTO(obatEntity))
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public Optional<AgendaEntity> findAgendaById(@PathVariable("id")Long id){
        return agendaService.findById(id);
    }
    @PostMapping
    public AgendaDTO saveAgenda(@RequestBody AgendaDTO request){
        final AgendaEntity agendaEntity = agendaService.mapToEntity(request);
        final AgendaEntity result = agendaService.saveAgenda(agendaEntity);
        return agendaService.mapToDTO(result);
    }
    @PutMapping
    public AgendaDTO updateAgenda(@RequestBody AgendaDTO request){
       final AgendaEntity agendaEntity = agendaService.mapToEntity(request);
       final AgendaEntity result = agendaService.updateAgenda(agendaEntity);
        return agendaService.mapToDTO(result);
    }
    @DeleteMapping("/{id}")
    public void deleteAgenda(@PathVariable("id")Long id){
        agendaService.deleteAgenda(id);
    }


}
