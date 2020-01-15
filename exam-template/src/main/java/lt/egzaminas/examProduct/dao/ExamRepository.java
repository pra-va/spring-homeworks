package lt.egzaminas.examProduct.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.egzaminas.examProduct.model.Product;

public interface ExamRepository extends JpaRepository<Product, Long> {

}
