package pl.sda.j133.springcar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reg;                     // rejestracja (numer rejestracyjny / registration number)
    private LocalDate registrationDate;     // data rejestracji
    private Integer doors;                  // ilość drzwi
    private Double engineCap;               // pojemność silnika (engine capacity)
}
