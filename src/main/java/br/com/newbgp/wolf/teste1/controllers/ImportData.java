package br.com.newbgp.wolf.teste1.controllers;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.newbgp.wolf.teste1.model.Persons;
import br.com.newbgp.wolf.teste1.repo.PersonsRepo;

@CrossOrigin(origins = "http://localhost:3000/", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/api/import_data")
public class ImportData {

    @Autowired
    PersonsRepo personsRepo;

    @Autowired
    private HttpSession session;
    @Autowired
    HttpServletResponse response;
    @Autowired
    EntityManager entityManager;

    @PostMapping("/import")
    public Object m_import(@RequestBody String data) {
        JsonElement json = JsonParser.parseString(data);
        JsonArray asJsonArray = json.getAsJsonArray();
        personsRepo.deleteAll();
        for (JsonElement json_person : asJsonArray) {
            JsonObject json_object_person = json_person.getAsJsonObject();
            Persons persons = new Persons();
            persons.setNome(json_object_person.get("nome").getAsString());
            persons.setCpf(json_object_person.get("cpf").getAsString());
            persons.setRg(json_object_person.get("rg").getAsString());
            persons.setData_nasc(json_object_person.get("data_nasc").getAsString());
            persons.setSexo(json_object_person.get("sexo").getAsString());
            persons.setMae(json_object_person.get("mae").getAsString());
            persons.setPai(json_object_person.get("pai").getAsString());
            persons.setEmail(json_object_person.get("email").getAsString());
            persons.setCep(json_object_person.get("cep").getAsString());
            persons.setEndereco(json_object_person.get("endereco").getAsString());
            persons.setNumero(json_object_person.get("numero").getAsString());
            persons.setBairro(json_object_person.get("bairro").getAsString());
            persons.setCidade(json_object_person.get("cidade").getAsString());
            persons.setEstado(json_object_person.get("estado").getAsString());
            persons.setTelefone_fixo(json_object_person.get("telefone_fixo").getAsString());
            persons.setCelular(json_object_person.get("celular").getAsString());
            persons.setAltura(json_object_person.get("altura").getAsFloat());
            persons.setPeso(json_object_person.get("peso").getAsFloat());
            persons.setTipo_sanguineo(json_object_person.get("tipo_sanguineo").getAsString());
            personsRepo.save(persons);
        }
        return ResponseEntity.ok("");
    }

}
