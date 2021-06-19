package br.com.newbgp.wolf.teste1.controllers;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.newbgp.wolf.teste1.repo.PersonsRepo;
import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000/", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/api/report")
public class Report {
    @Autowired
    PersonsRepo personsRepo;

    @Autowired
    private HttpSession session;
    @Autowired
    HttpServletResponse response;
    @Autowired
    EntityManager entityManager;

    @GetMapping("state")
    Object state() {
        return ResponseEntity.ok(personsRepo.getEstadoCount());
    }

    @GetMapping("imc")
    Object imc() {
        ArrayList<MinMax> range = new ArrayList<MinMax>();
        int last_i = 1;
        for (int i = 0; i < 110; i += 10) {
            if (i == 0)
                continue;
            if (last_i == 1)
                range.add(new MinMax(0, i));
            else
                range.add(new MinMax((last_i + 1), i));
            last_i = i;
        }
        ArrayList<List<?>> return_obj = new ArrayList<List<?>>();
        for (MinMax min_max : range) {
            return_obj.add(personsRepo.getImcAverage(min_max.min, min_max.max));
        }
        return ResponseEntity.ok(return_obj);
    }

    @GetMapping("obsity")
    Object obsity() {
        return ResponseEntity.ok(personsRepo.getSexObsityAverage());
    }

    @GetMapping("blood_type")
    Object blood_type() {
        return ResponseEntity.ok(personsRepo.getBloodAgeAverage());
    }

    @GetMapping("qtd_blood_type")
    Object qtd_blood_type() {
        return ResponseEntity.ok(personsRepo.getBloodTypeDonateCount());
    }

}

@AllArgsConstructor
class MinMax {
    Integer min, max;
}