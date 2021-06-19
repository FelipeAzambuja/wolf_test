package br.com.newbgp.wolf.teste1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.newbgp.wolf.teste1.model.BloodType;

@Repository
public interface BloodTypeRepo extends JpaRepository<BloodType,Integer>{
    
    
}
