package com.batikanugur.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
//@Setter + @Getter = @Data
@Data
@ToString

@Entity
@Table(name = "students")
//POJO
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;


}
