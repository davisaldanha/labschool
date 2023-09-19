
package com.example.labschool.repositories;

import com.example.labschool.models.PedagogoModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedagogoRepository extends JpaRepository<PedagogoModel, UUID>{
    
}
