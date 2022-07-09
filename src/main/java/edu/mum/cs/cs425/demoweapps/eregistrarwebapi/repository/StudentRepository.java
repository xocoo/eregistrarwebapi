package edu.mum.cs.cs425.demoweapps.eregistrarwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.demoweapps.eregistrarwebapi.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByOrderByFirstNameAsc();

    // Custom query
    @Query(value = "SELECT * FROM students s WHERE s.first_name LIKE %:keyword%", nativeQuery = true)
    List<Student> findByKeyword(@Param("keyword") String keyword);
}
