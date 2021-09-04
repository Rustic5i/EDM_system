package com.example.edm_system.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; //b.	имя
    private String surname; //a.	фамилия
    private String patronymic;// c.	отчество
    private String post;  //d.	должность

    @Override
    public String toString() {
        return "Employee: " + name +" " + surname;
    }
}
