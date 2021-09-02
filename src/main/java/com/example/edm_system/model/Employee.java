package com.example.edm_system.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; //b.	имя
    private String surname; //a.	фамилия
    private String patronymic;// c.	отчество
    private String post;  //d.	должность

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "authorTask") //автор поручения;
    private List<Task> authorTaskList = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "executorsTask") ////исполнители поручения
    private List<Task> executorsTaskList = new ArrayList<>();



    public void setAuthorTaskList(Task authorTaskList) {
        this.authorTaskList.add(authorTaskList);
    }

    public void setExecutorsTaskList(Task executorsTaskList) {
        this.executorsTaskList.add(executorsTaskList);
    }
}
