package com.ems.ems_backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.ems_backend.dao.EmployeeDao;
import com.ems.ems_backend.dto.EmployeeDTO;
import com.ems.ems_backend.entity.Employee;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeedao;

    @Autowired
    private ModelMapper modelMapper;

    public EmployeeDTO insertData(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        Employee savedEmployee = employeedao.insertdata(employee);
        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }

    public EmployeeDTO updateData(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        Employee updatedEmployee = employeedao.updateData(employee);
        return modelMapper.map(updatedEmployee, EmployeeDTO.class);
    }

    public EmployeeDTO deleteData(int id) {
        Employee deletedEmployee = employeedao.deleteData(id);
        return modelMapper.map(deletedEmployee, EmployeeDTO.class);
    }

    public List<EmployeeDTO> displayallData() {
        List<Employee> employeeList = employeedao.displayallData();
        return employeeList.stream()
                .map(emp -> modelMapper.map(emp, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO getEmployeeById(int id) {
        Employee employee = employeedao.getEmployeeById(id);
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    public List<EmployeeDTO> displayinactive() {
        List<Employee> inactiveList = employeedao.displayinactive();
        return inactiveList.stream()
                .map(emp -> modelMapper.map(emp, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> getSortedEmployees(String field) {
        List<Employee> sortedList = employeedao.getSortedEmployees(field);
        return sortedList.stream()
                .map(emp -> modelMapper.map(emp, EmployeeDTO.class))
                .collect(Collectors.toList());
    }
}
