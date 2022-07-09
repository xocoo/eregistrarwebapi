package edu.mum.cs.cs425.demoweapps.eregistrarwebapi.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentid")
    private Long studentId;

    @NotBlank(message = "Student Number cannot be null or empty or blank spaces")
    // @Column(name = "student_number", unique = true, nullable = false)
    private String studentNumber;

    @NotBlank(message = "First Name cannot be null or empty or blank spaces")
    private String firstName;

    private String middleName;

    @NotBlank(message = "Last Name cannot be null or empty or blank spaces")
    private String lastName;

    private double cgpa;

    @NotNull(message = "Enrollment Date cannot be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;

    @NotNull(message = "is International cannot be null")
    private boolean isInternational;

    public boolean isIsInternational() {
        return isInternational;
    }

    /**
     * @param isInternational the isInternational to set
     */
    public void setIsInternational(boolean isInternational) {
        this.isInternational = isInternational;
    }
}
