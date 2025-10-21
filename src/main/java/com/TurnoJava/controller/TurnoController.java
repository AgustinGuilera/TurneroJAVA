package com.TurnoJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.TurnoJava.service.TurnoService;
import com.TurnoJava.entity.Turno;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turnos")
@CrossOrigin(origins = "*")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @GetMapping
    public List<Turno> listar() {
        return turnoService.listarTurnos();
    }

    @GetMapping("/{id}")
    public Optional<Turno> obtenerPorId(@PathVariable int id) {
        return turnoService.obtenerTurnoPorId(id);
    }

    @PostMapping
    public Turno crear(@RequestBody Turno turno) {
        return turnoService.guardarTurno(turno);
    }

    @PutMapping("/{id}")
    public Turno actualizar(@PathVariable int id, @RequestBody Turno turnoActualizado) {
        return turnoService.obtenerTurnoPorId(id)
                .map(t -> {
                    t.setUsuario(turnoActualizado.getUsuario());
                    t.setCancha(turnoActualizado.getCancha());
                    t.setFecha(turnoActualizado.getFecha());
                    t.setHorario(turnoActualizado.getHorario());
                    t.setEstado(turnoActualizado.getEstado());
                    t.setMonto(turnoActualizado.getMonto());
                    return turnoService.guardarTurno(t);
                })
                .orElseGet(() -> {
                    turnoActualizado.setIdTurno(id);
                    return turnoService.guardarTurno(turnoActualizado);
                });
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        turnoService.eliminarTurno(id);
    }
}
