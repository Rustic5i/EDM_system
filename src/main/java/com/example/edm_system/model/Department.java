package com.example.edm_system.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

//2.	Подразделение
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameDepartment; //a.	наименование подразделения
    private String contactData;    //b.	контактные данные;
    private String manager;        // c.	руководитель.

    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE})
    @JoinColumn(name = "department_id")
    private List<Employee> employee = new ArrayList<>();

    public void setEmployee(Employee employee) {
        this.employee.add(employee);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(nameDepartment, that.nameDepartment) && Objects.equals(contactData, that.contactData) && Objects.equals(manager, that.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameDepartment, contactData, manager);
    }

    @Override
    public String toString() {
        return "Department" + nameDepartment;
    }
}
