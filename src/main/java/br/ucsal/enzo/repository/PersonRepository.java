package br.ucsal.enzo.repository;

import br.ucsal.enzo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
