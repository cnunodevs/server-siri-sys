package com.senatic.siri.respository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.senatic.siri.model.entity.AprendicesExt;


public interface VoluntariosInternacionalesRepository extends JpaRepository<AprendicesExt, UUID> {
    
}
