package com.sip.ams;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sip.ams.Entities.Etudiant;
import com.sip.ams.Repositories.EtudiantRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestDemoDataController {
    @Autowired
    private EtudiantRepository repo;

    @Test
    @Rollback(false)
    @Order(1)
    public void testCreateEtudiant() {
        Etudiant savedEtudiant = repo.save(new Etudiant("Sada", 24)); // save

        assertThat(savedEtudiant.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void testFindProductByName() {
        Etudiant etudiant = repo.findByName("Sada"); // findByName
        assertThat(etudiant.getName()).isEqualTo("Sada");
    }

    @Test
    @Order(3)
    public void testListEtudiant() {
        List<Etudiant> products = (List<Etudiant>) repo.findAll();
        assertThat(products).size().isGreaterThan(0);
    }
}
