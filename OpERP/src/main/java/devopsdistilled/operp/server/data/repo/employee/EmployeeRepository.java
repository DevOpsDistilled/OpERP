package devopsdistilled.operp.server.data.repo.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import devopsdistilled.operp.server.data.entity.employee.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
