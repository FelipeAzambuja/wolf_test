package br.com.newbgp.wolf.teste1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BloodType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String tipo, doa;
}
