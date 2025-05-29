package com.ems.ems_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ems.ems_backend.dto.EmployeeDTO;
import com.ems.ems_backend.service.EmployeeService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/employee-details")
public class EmployeeController {

    @Autowired
    EmployeeService employeeservice;

    @PostMapping("/insertdata")
    public ResponseEntity<EmployeeDTO> insertData(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO savedEmployee = employeeservice.insertData(employeeDTO);
        return ResponseEntity.ok(savedEmployee);
    }

    @PutMapping("/updatedata")
    public ResponseEntity<EmployeeDTO> updateData(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO updatedEmployee = employeeservice.updateData(employeeDTO);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/deletedata/{id}")
    public ResponseEntity<EmployeeDTO> deleteData(@PathVariable int id) {
        EmployeeDTO deletedEmployee = employeeservice.deleteData(id);
        if (deletedEmployee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deletedEmployee);
    }

    @GetMapping("/displayalldata")
    public ResponseEntity<List<EmployeeDTO>> displayallData() {
        List<EmployeeDTO> list = employeeservice.displayallData();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/getemployeebyid/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable int id) {
        EmployeeDTO employee = employeeservice.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/inactive")
    public ResponseEntity<List<EmployeeDTO>> displayinactive() {
        List<EmployeeDTO> emp = employeeservice.displayinactive();
        return ResponseEntity.ok(emp);
    }

    @GetMapping("/sort/{field}")
    public ResponseEntity<List<EmployeeDTO>> getSortedEmployees(@PathVariable String field) {
        List<EmployeeDTO> sortedList = employeeservice.getSortedEmployees(field);
        return ResponseEntity.ok(sortedList);
    }
}
