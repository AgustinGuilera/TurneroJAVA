package com.TurnoJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.TurnoJava.repository.TurnoRepository;
import com.TurnoJava.entity.Turno;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    public List<Turno> listarTurnos() {
        return turnoRepository.findAll();
    }

    public Optional<Turno> obtenerTurnoPorId(int id) {
        return turnoRepository.findById(id);
    }

    public Turno guardarTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    public void eliminarTurno(int id) {
        turnoRepository.deleteById(id);
    }
}
