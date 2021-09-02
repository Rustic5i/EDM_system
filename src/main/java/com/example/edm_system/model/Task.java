package com.example.edm_system.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//4.	Поручение
@Entity
@Data
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataExecution; // d.	срок исполнения;
    private String objectTask; // a.	предмет поручения;
    private String textTask;  // g.	текст поручения.
    private String signControl; //e.	признак контрольности;
    private String signExecution;  // f.	признак исполнения;

    @ManyToOne
    @JoinColumn(name = "executorsTask_id")
    private Employee executorsTask; //исполнители поручения

    @ManyToOne
    @JoinColumn(name = "authorTask_id")
    private Employee authorTask; // b.	автор поручения;
}
