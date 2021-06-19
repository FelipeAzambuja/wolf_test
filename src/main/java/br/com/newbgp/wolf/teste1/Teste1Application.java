package br.com.newbgp.wolf.teste1;

import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.newbgp.wolf.teste1.controllers.ImportData;
import br.com.newbgp.wolf.teste1.model.BloodType;
import br.com.newbgp.wolf.teste1.model.Persons;
import br.com.newbgp.wolf.teste1.repo.BloodTypeRepo;

@SpringBootApplication
public class Teste1Application {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext run = SpringApplication.run(Teste1Application.class, args);
		ImportData id = run.getBean(ImportData.class);
		BloodTypeRepo blood_type = run.getBean(BloodTypeRepo.class);
		String json_data = new String(Files.readAllBytes(Path.of("data.json")));
		id.m_import(json_data);

		blood_type.save(new BloodType(1, "A+", "AB+"));
		blood_type.save(new BloodType(1, "A+", "A+"));

		blood_type.save(new BloodType(1, "A-", "A+"));
		blood_type.save(new BloodType(1, "A-", "A-"));
		blood_type.save(new BloodType(1, "A-", "AB+"));
		blood_type.save(new BloodType(1, "A-", "AB-"));
		
		blood_type.save(new BloodType(1, "B+", "B+"));
		blood_type.save(new BloodType(1, "B+", "AB+"));
		
		blood_type.save(new BloodType(1, "B-", "B+"));
		blood_type.save(new BloodType(1, "B-", "B-"));
		blood_type.save(new BloodType(1, "B-", "AB+"));
		blood_type.save(new BloodType(1, "B-", "AB-"));

		blood_type.save(new BloodType(1, "AB+", "AB+"));

		blood_type.save(new BloodType(1, "AB-", "AB+"));
		blood_type.save(new BloodType(1, "AB-", "AB-"));
		
		blood_type.save(new BloodType(1, "O+", "A+"));
		blood_type.save(new BloodType(1, "O+", "B+"));
		blood_type.save(new BloodType(1, "O+", "O+"));
		blood_type.save(new BloodType(1, "O+", "AB+"));
		
		blood_type.save(new BloodType(1, "O-", "A+"));
		blood_type.save(new BloodType(1, "O-", "B+"));
		blood_type.save(new BloodType(1, "O-", "O+"));
		blood_type.save(new BloodType(1, "O-", "AB+"));
		blood_type.save(new BloodType(1, "O-", "A-"));
		blood_type.save(new BloodType(1, "O-", "B-"));
		blood_type.save(new BloodType(1, "O-", "O-"));
		blood_type.save(new BloodType(1, "O-", "AB-"));
		
	}

}
