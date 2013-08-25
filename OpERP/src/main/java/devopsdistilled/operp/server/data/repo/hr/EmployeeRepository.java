package devopsdistilled.operp.server.data.repo.hr;

import org.springframework.data.jpa.repository.JpaRepository;

import devopsdistilled.operp.server.data.entity.hr.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
