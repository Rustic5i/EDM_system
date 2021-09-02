package com.example.edm_system.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//1.	Организация
@Entity
@Data
@NoArgsConstructor
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameOrganization; //a.	наименование организации
    private String physicalAddress;  //b.	физический адрес
    private String juridicalAddress; //c.	юридический адрес;
    private String manager;          //d.	руководитель.

    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "organization") // указываем где нужно искать связь
    private Set<Department> department  = new HashSet<>();

    public void setDepartment(Department department) {
        this.department.add(department);
    }
}
