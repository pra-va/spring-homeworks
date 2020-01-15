package lt.egzaminas.examProduct.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.egzaminas.examProduct.model.institutions.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {
}
