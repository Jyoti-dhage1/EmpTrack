package com.ems.ems_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data // Includes getter, setter, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String phoneno;
    private String departmentit;
    private String status;
    private String createdby;
    private String updatedby;
    private int cid;
}
