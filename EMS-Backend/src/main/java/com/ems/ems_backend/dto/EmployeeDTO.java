package com.ems.ems_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private int id;
    private String name;
    private String phoneno;
    private String departmentit;
    private String status;
    private String createdby;
    private String updatedby;
    private int cid;
}
