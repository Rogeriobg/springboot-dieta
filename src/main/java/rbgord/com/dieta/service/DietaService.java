package rbgord.com.dieta.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rbgord.com.dieta.model.Dieta;
import rbgord.com.dieta.repository.DietaRepository;

@Service
public class DietaService {

    @Autowired
    private DietaRepository dietaRepository;

    public Dieta adicionaDieta(Dieta dieta) {
        dieta.getAlimentos().forEach(alimento -> alimento.setDieta(dieta));
        return dietaRepository.save(dieta);
    }

    public List<Dieta> listDieta() {
        return dietaRepository.findAll();
    }

    public List<Dieta> listarDietasPorDia(LocalDate dia) {
        return dietaRepository.findByDia(dia);
    }

}
