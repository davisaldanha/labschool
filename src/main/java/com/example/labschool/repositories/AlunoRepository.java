package com.example.labschool.repositories;

import com.example.labschool.models.AlunoModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface AlunoRepository  extends JpaRepository<AlunoModel, UUID>{
    
}
