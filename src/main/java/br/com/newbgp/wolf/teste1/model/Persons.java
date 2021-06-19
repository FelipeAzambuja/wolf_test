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

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persons {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String nome,cpf,rg,data_nasc,sexo,mae,pai,email,cep,endereco,numero,
    bairro,cidade,estado,telefone_fixo,celular,tipo_sanguineo;

    Float altura,peso;


}
