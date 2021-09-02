package com.example.edm_system.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//2.	Подразделение
@Entity
@Data
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameDepartment; //a.	наименование подразделения
    private String contactData;    //b.	контактные данные;
    private String manager;        // c.	руководитель.

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE})
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE},
            mappedBy = "department")
    private Set<Employee> employee = new HashSet<>();

    public void setEmployee(Employee employee) {
        this.employee.add(employee);
    }
}
