package br.com.newbgp.wolf.teste1.repo;

import java.util.List;

import org.hibernate.annotations.ParamDef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.newbgp.wolf.teste1.model.Persons;

@Repository
public interface PersonsRepo extends JpaRepository<Persons,Integer>,JpaSpecificationExecutor<Persons> {

    @Query(value = "SELECT estado,count(*) as total FROM Persons group by estado",nativeQuery = true)
    List<?> getEstadoCount();

    @Query(value = "" +
        "select "+
        "	IFNULL(round(avg(peso / (altura * altura)),2),0) as imc, "+
        "	:min as min, "+
        "	:max as max, "+
        "from "+
        "	persons "+
        "where "+
        "	datediff( YEAR , parsedatetime( data_nasc , 'dd/MM/yyyy' ) , current_date() ) between :min and :max"+
    "",nativeQuery = true)
    List<?> getImcAverage(@Param("min") Integer min, @Param("max") Integer max);

    @Query(value = "" +
        "SELECT"+
        "    cast((cast( count(*)  as float) /  (select count(*) from persons where sexo = person.sexo)) * 100 as int), "+
        "    sexo "+
        "FROM "+ 
        "    persons person "+
        "WHERE "+
        "    peso / (altura * altura) > 30"+
        "group by sexo"+
    "",nativeQuery = true)
    List<?> getSexObsityAverage();

    @Query(value = "" +
        "select " +
        "    tipo_sanguineo , " +
        "    avg( datediff( YEAR , parsedatetime( data_nasc , 'dd/MM/yyyy' ) , current_date() ) ) " +
        "from " +
        "	persons " +
        "group by tipo_sanguineo" +
    "",nativeQuery = true)
    List<?> getBloodAgeAverage();

    @Query(value = "" +
        "select " +
        "	person.tipo_sanguineo , " +
        "	(" +
        "    	select " +
        "      		count(*) " +
        "      	from " +
        "      		persons " +
        "      	where " +
        "      		tipo_sanguineo in ( select doa from blood_type where tipo = person.tipo_sanguineo ) " +
        "      		and datediff( YEAR , parsedatetime( data_nasc , 'dd/MM/yyyy' ) , current_date() ) BETWEEN 16 and 59 " +
        "      		AND peso > 50 " +
        "    )  as total " +
        "from " +
        "	persons person " +
        "group by tipo_sanguineo " +
    "",nativeQuery = true)
    List<?> getBloodTypeDonateCount();

}  
 