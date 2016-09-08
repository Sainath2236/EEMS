package com.virtusa.eems.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.eems.beans.Activity;
import com.virtusa.eems.beans.BankAccount;
import com.virtusa.eems.beans.Department;
import com.virtusa.eems.beans.Designation;
import com.virtusa.eems.beans.Employee;
import com.virtusa.eems.beans.Gender;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	static Logger log = Logger.getLogger(EmployeeDAOImpl.class);

	@Transactional
	public String registerEmployee(Employee employee) {
		log.info("*** registering employee in employeeDao ***");

		sessionFactory.getCurrentSession().save(employee);
		log.info("*** employee registered in employeeDao ***");
		return "Registration Success!!";

	}

	@Transactional
	public Map<Integer, String> getDepartments() {

		log.info("*** before getting departments as map in employeeDao ***");

		List<Department> departments = sessionFactory.getCurrentSession()
				.createQuery("From Department").list();
		Map<Integer, String> departmentsMap = new LinkedHashMap<Integer, String>();
		for (Department department : departments) {
			departmentsMap.put(department.getDepartmentId(),
					department.getDepartmentName());
		}
		log.info("*** after getting departments as map in employeeDao ***");
		return departmentsMap;
	}

	@Transactional
	public Map<Integer, String> getDesignations() {
		log.info("*** before getting designations as map in employeeDao ***");
		List<Designation> designations = sessionFactory.getCurrentSession()
				.createQuery("From Designation").list();
		Map<Integer, String> designationsMap = new LinkedHashMap<Integer, String>();
		for (Designation designation : designations) {
			designationsMap.put(designation.getDesignationId(),
					designation.getDesignationName());
		}
		log.info("*** after getting designations as map in employeeDao ***");
		return designationsMap;
	}

	@Transactional
	public Map<String, String> getGender() {
		log.info("*** before getting genders as map in employeeDao ***");
		List<Gender> genders = sessionFactory.getCurrentSession()
				.createQuery("From Gender").list();
		Map<String, String> gendersMap = new LinkedHashMap<String, String>();
		for (Gender gender : genders) {
			gendersMap.put(gender.getType(), gender.getType());
		}
		log.info("*** after getting genders as map in employeeDao ***");
		return gendersMap;
	}

	@Transactional
	public List<Employee> getEmployees() {
		log.info("*** before getting employees as list in employeeDao ***");
		Query query = sessionFactory.getCurrentSession().createQuery(
				"From Employee");
		List<Employee> employees = query.list();
		log.info("*** before getting employess as list in employeeDao ***");
		return employees;
	}

	@Transactional
	public String updateEmployee(Employee employee) {
		log.info("*** before updating employees in employeeDao ***");
		sessionFactory.getCurrentSession().update(employee);
		log.info("*** after updating employees in employeeDao ***");
		return "";
	}

	@Transactional
	public Employee getEmployee(int employeeId) {
		log.info("*** before getting employees by employee id in employeeDao ***");
		Employee employee = (Employee) sessionFactory.getCurrentSession().get(
				Employee.class, employeeId);
		log.info("*** after getting employees by employee id in employeeDao ***");
		return employee;
	}

	@Transactional
	public List<Employee> getEmployeesByMID(int managerId) {
		log.info("*** before getting employees by manager id in employeeDao ***");
		List<Employee> employees = sessionFactory.getCurrentSession()
				.createQuery("From Employee where manager_Id =" + managerId)
				.list();
		log.info("*** after getting employees by manager id in employeeDao ***");
		return employees;
	}

	@Transactional
	public Employee login(int employeeId, String password) {
		log.info("*** checking login credentials in employeeDao ***");
		Session session = sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, employeeId);
		if (employee != null) {
			log.info("*** valid employee id ***");
			if (employee.getPassword().equals(password)) {
				log.info("*** valid password ***");
				return employee;
			} else {
				log.info("*** invalid password ***");
				return null;
			}
		} else {
			log.info("*** invalid employee id ***");
			return null;
		}
	}

	@Transactional
	public List<Activity> getEmployeeActivities(Integer employeeId) {
		log.info("*** before getting employee activities by employee id in employeeDao ***");
		int designationId = 0;
		Session session = sessionFactory.getCurrentSession();
		List<Employee> employees = session.createQuery("From Employee").list();
		for (Employee employee : employees) {
			if (employee.getEmployeeId().intValue() == employeeId.intValue()) {
				designationId = employee.getDesignationId();
				log.info("*** retrieved designation id for the corresponding employee id  ***");
			}
		}
		Designation designation = (Designation) session.get(Designation.class,
				designationId);

		if (designation != null) {
			log.info("*** returning activities ***");
			return designation.getActivities();
		}
		log.info("*** invalid employee id ***");
		return null;

	}

	@Transactional
	public Designation getDesignation(int employeeId) {
		log.info("*** before getting designation by employee id in employeeDao ***");
		Employee employee = getEmployee(employeeId);
		if (employee != null) {
			Designation designation = (Designation) sessionFactory
					.getCurrentSession().get(Designation.class,
							employee.getDesignationId());
			log.info("*** returning designation ***");
			return designation;
		} else {
			log.info("*** invalid employee id ***");
			return null;
		}
	}

	@Transactional
	public BankAccount addBankAccount(BankAccount bankAccount) {
		log.info("*** before Adding bank account in  employeeDao ***");
		sessionFactory.getCurrentSession().save(bankAccount);
		log.info("*** After Adding bank account in  employeeDao ***");
		return bankAccount;
	}

	@Transactional
	public BankAccount getBankAccount(String accountNumber) {
		BankAccount bankAccount = (BankAccount) sessionFactory
				.getCurrentSession().get(BankAccount.class, accountNumber);
		return bankAccount;
	}

	public BankAccount updateBankAccount(BankAccount bankAccount) {

		sessionFactory.getCurrentSession().saveOrUpdate(bankAccount);
		return bankAccount;
	}

	public Boolean deleteBankAccount(BankAccount bankAccount) {
		sessionFactory.getCurrentSession().delete(bankAccount);
		return true;
	}

	public Boolean deleteEmployee(Employee employee) {
		sessionFactory.getCurrentSession().delete(employee);
		return true;
	}

	public Employee getManager(int departmentId, int managerId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Employee.class);
		criteria.add(Restrictions.eq("department_id", departmentId));
		criteria.add(Restrictions.eq("manager_id", managerId));
		Employee employee = (Employee) criteria.uniqueResult();
		return employee;
	}

	public Employee getEmployee(String email) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Employee.class);
		criteria.add(Restrictions.eq("email", email));
		Employee employee = (Employee) criteria.uniqueResult();
		return employee;
	}
}
