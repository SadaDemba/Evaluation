package com.sip.ams.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.sip.ams.Entities.Etudiant;

public interface EtudiantRepository extends CrudRepository<Etudiant, Integer> {
    public Etudiant findByName(String name);
}
