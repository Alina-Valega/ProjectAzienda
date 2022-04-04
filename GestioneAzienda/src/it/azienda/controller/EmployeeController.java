package it.azienda.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.springframework.stereotype.Controller;

import it.azienda.entity.Department;
import it.azienda.entity.Employee;
import it.azienda.service.EmployeeService;


@Controller
@ManagedBean(name = "controllerEmployee")
@ViewScoped
public class EmployeeController implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{employeeService}")
	EmployeeService employeeService = new EmployeeService();

	public Employee newEmployee = null;
	private List<Employee> arrEmployee;
	private Employee selectEmployee;
	private List<Department> listDepartment;

	@PostConstruct
	public void init() {
		this.newEmployee = new Employee();
		this.arrEmployee = employeeService.getAllEmployees();
		setSelectEmployee(new Employee());
		setListDepartment(employeeService.getAllDepartment());

	}

	// list
	public List<Employee> employeeList() {
		return employeeService.getAllEmployees();
	}

	// dialog per un nuovo dipendente
	public void openNew() {
		try {
			setNewEmployee(new Employee());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// create
	public void createEmployee() {
		FacesMessage messageExist = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ATTENZIONE",
				"Utente " + newEmployee.getNameEmp() + " già esistente");
		FacesMessage messageSucess = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO",
				"Utente " + newEmployee.getNameEmp() + " registrato");
		FacesMessage messageWarn = new FacesMessage(FacesMessage.SEVERITY_FATAL, "ATTENZIONE ",
				"Impossibile inserire utente");

		
		try {
			Employee employee = employeeService.getEmployeeByName(newEmployee.getNameEmp());
			
			if(employee == null) {
				
				
			employeeService.createNewEmployee(newEmployee);
			reloadEmployee();
			RequestContext.getCurrentInstance().execute("PF('newEmployeeDialog').hide()");
			RequestContext.getCurrentInstance().showMessageInDialog(messageSucess);
			
		} else {
			RequestContext.getCurrentInstance().showMessageInDialog(messageExist);
			reloadEmployee();
		}
		}
		 catch (Exception e) {
			RequestContext.getCurrentInstance().showMessageInDialog(messageWarn);
			e.printStackTrace();

		}

	}

	// Dialog update
	public void openModify() {
		FacesMessage messageSelect = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ATTENZIONE",
				"Selezionare un dipendente");

		if (selectEmployee == null) {
			RequestContext.getCurrentInstance().showMessageInDialog(messageSelect);
			return;
		}
		RequestContext.getCurrentInstance().execute("PF('editEmployeeDialog').show()");

	}

//update
	
	public void saveUpdateEmp()  {
		FacesMessage messageEdit = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "Dipendente modificato");
		FacesMessage messageExist = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ATTENZIONE",
				"Utente già esistente");
		FacesMessage messageWarn = new FacesMessage(FacesMessage.SEVERITY_FATAL, "ATTENZIONE ",
				"Impossibile inserire utente");
	
		try {

			Employee employee = employeeService.getEmployeeByName(selectEmployee.getNameEmp());
			if(employee == null) {
				
			
			employeeService.updateEmployee(selectEmployee);
			RequestContext.getCurrentInstance().execute("PF('editEmployeeDialog').hide()");
			RequestContext.getCurrentInstance().showMessageInDialog(messageEdit);
			reloadEmployee();
			
		} else {
			RequestContext.getCurrentInstance().showMessageInDialog(messageExist);
			reloadEmployee();
		}
		} 
		catch (Exception e) {
			RequestContext.getCurrentInstance().showMessageInDialog(messageWarn);
			e.printStackTrace();

		}

	}

	// delete
	public void deleteEmployee() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ATTENZIONE", "Selezionare un dipendente");
		FacesMessage messageDelete = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "Dipendente eliminato");
		if (selectEmployee == null) {
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			setSelectEmployee(new Employee());
			reloadEmployee();
			return;
		}
		try {
			employeeService.deleteEmployee(selectEmployee);
			RequestContext.getCurrentInstance().showMessageInDialog(messageDelete);
		} catch (Exception e) {
			FacesMessage messageError = new FacesMessage(FacesMessage.SEVERITY_FATAL, "ATTENZIONE",
					"Impossibile eliminare il dipendente");
			;
			RequestContext.getCurrentInstance().showMessageInDialog(messageError);
			e.printStackTrace();
		}
		reloadEmployee();
	}

//	Reload 
	public void reloadEmployee() {
		setArrEmployee(employeeService.getAllEmployees());
	}

	// get and set

	public Employee getEmployee() {
		return newEmployee;
	}

	public void setEmployee(Employee employee) {
		this.newEmployee = employee;
	}

	public Employee getSelectEmployee() {
		return selectEmployee;
	}

	public void setSelectEmployee(Employee selectEmployee) {
		this.selectEmployee = selectEmployee;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Employee getNewEmployee() {
		return newEmployee;
	}

	public void setNewEmployee(Employee newEmployee) {
		this.newEmployee = newEmployee;
	}

	public List<Employee> getArrEmployee() {
		return arrEmployee;
	}

	public void setArrEmployee(List<Employee> arrEmployee) {
		this.arrEmployee = arrEmployee;
	}

	public List<Department> getListDepartment() {
		return listDepartment;
	}

	public void setListDepartment(List<Department> listDepartment) {
		this.listDepartment = listDepartment;
	}

}
