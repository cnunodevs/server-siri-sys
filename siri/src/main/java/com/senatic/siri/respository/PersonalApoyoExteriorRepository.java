package com.senatic.siri.respository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.senatic.siri.model.entity.PersonalApoyoExterior;

public interface PersonalApoyoExteriorRepository extends JpaRepository<PersonalApoyoExterior, UUID>{
    
}
