package com.shkilAhamad.spring.boot.cource.Entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@ToString
public class Course {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject")
    private String subject;
    @Column(name ="first_name")
    private  String firstName;
    @Column(name = "last_name")
    private String  lastName;

    @Column(name="course_fee")
    private int courseFee;

}
