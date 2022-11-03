package com.example.cadastroemprego.repositories;

import com.example.cadastroemprego.entities.Emprego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmpregoRepository extends CrudRepository<Emprego,Long> {
}
