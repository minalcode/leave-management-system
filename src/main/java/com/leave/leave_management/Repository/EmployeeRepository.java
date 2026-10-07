
package com.leave.leave_management.Repository;

import com.leave.leave_management.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}