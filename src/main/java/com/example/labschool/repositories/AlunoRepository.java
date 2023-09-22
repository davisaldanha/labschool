package com.example.labschool.repositories;

import com.example.labschool.models.AlunoModel;
import com.example.labschool.Dtos.AlunoSeletorDto;
import java.util.UUID;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface AlunoRepository  extends JpaRepository<AlunoModel, UUID>{
    
    @Query(value="SELECT new com.example.labschool.Dtos.AlunoSeletorDto(al.id, al.nome)"
        + " FROM com.example.labschool.models.Aluno al")
    List<AlunoSeletorDto> findByIdName();
}
