package com.Mais_Saude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Mais_Saude.model.PermissoesModel;
@Repository
public interface PermissoesRepository extends JpaRepository<PermissoesModel, Long> {

}
