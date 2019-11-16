package com.zzmath.employee1.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.zzmath.employee1.entities.Employee;
import com.zzmath.employee1.repositories.EmployeeRepository;
import com.zzmath.employee1.services.exceptions.DatabaseException;
import com.zzmath.employee1.services.exceptions.ResourceNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	
	public Set<Employee> findfindByAge(Employee employee) {
		return repository.findByAge(employee);
	}
	
	public Set<Employee> FindBySalary(Employee employee){
		return repository.FindBySalary(employee);
	}
	
	public List<Employee> findAll() {
		return repository.findAll();
	}
	
	
	public Employee findById(Long id) {
		
		Optional<Employee> obj = repository.findById(id);
		return obj.get();
	}
	
	public Employee insert(Employee employee) {
		return repository.save(employee);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Employee update(Long id, Employee obj) {
		try {
			Employee entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}
	
	private void updateData(Employee entity, Employee obj) {
		entity.setEmployee_name(obj.getEmployee_name());
		entity.setEmployee_salary(obj.getEmployee_salary());
		entity.setEmployee_age(obj.getEmployee_age());
		entity.setProfile_img(obj.getProfile_img());
	}
}
