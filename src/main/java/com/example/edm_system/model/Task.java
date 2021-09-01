package com.example.edm_system.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//4.	Поручение
@Entity
@Data
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataExecution;
    private String objectOrder;
    private String authorOrder;
    private String textOrder;
    private String executorsOrder; //исполнители поручения
    private String signControl;
    private String signExecution;


}
