package com.example.edm_system.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//1.	Организация
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameOrganization; //a.	наименование организации
    private String physicalAddress;  //b.	физический адрес
    private String juridicalAddress; //c.	юридический адрес;
    private String manager;          //d.	руководитель.

    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinColumn(name = "organization_id")
    private Set<Department> department  = new HashSet<>();


    public void setDepartment(Department department) {
        this.department.add(department);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(nameOrganization, that.nameOrganization) && Objects.equals(physicalAddress, that.physicalAddress) && Objects.equals(juridicalAddress, that.juridicalAddress) && Objects.equals(manager, that.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOrganization, physicalAddress, juridicalAddress, manager);
    }

    @Override
    public String toString() {
        return "Organization: " + nameOrganization;
    }
}
