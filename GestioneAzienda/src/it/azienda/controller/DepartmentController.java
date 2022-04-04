package it.azienda.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;
import org.springframework.stereotype.Controller;
import it.azienda.entity.Department;
import it.azienda.service.DepartmentService;

@Controller
@ManagedBean(name = "controllerDepartment")
@SessionScoped
public class DepartmentController implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{departmentService}")
	DepartmentService departmentService = new DepartmentService();

	private Department newDepartment = null;
	private List<Department> arrDepartment;
	private Department selectDepartment;

	@PostConstruct
	public void init() {
		this.newDepartment = new Department();
		this.arrDepartment = departmentService.getAllDepartment();
		setSelectDepartment(new Department());

	}

	// list
	public List<Department> departamentList() {
		return departmentService.getAllDepartment();
	}

	// dialog per un nuovo dipartimento
	public void openNew() {
		try {
			setNewDepartment(new Department());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// create
	public void createDepartment() {
		FacesMessage messageExist = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ATTENZIONE",
				"Dipartimento " + newDepartment.getNameDep() + " già esistente");
		FacesMessage messageSucess = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO",
				"Dipartimento  " + newDepartment.getNameDep() + " registrato");
		FacesMessage messageWarn = new FacesMessage(FacesMessage.SEVERITY_FATAL, "ATTENZIONE ",
				"Impossibile inserire dipartimento ");
		try {
			Department department = departmentService.getDepartmentByName(newDepartment.getNameDep());

			if (department == null) {

				departmentService.createDepartment(newDepartment);
				reloadDepartment();
				RequestContext.getCurrentInstance().execute("PF('newDepartmentDialog').hide()");
				RequestContext.getCurrentInstance().showMessageInDialog(messageSucess);

			} else {
				RequestContext.getCurrentInstance().showMessageInDialog(messageExist);
				reloadDepartment();
			}
		} catch (Exception e) {
			RequestContext.getCurrentInstance().showMessageInDialog(messageWarn);
			e.printStackTrace();

		}

	}

	// Dialog update
	public void openModify() {
		FacesMessage messageSelect = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ATTENZIONE",
				"Selezionare un dipartimento");

		if (selectDepartment == null) {
			RequestContext.getCurrentInstance().showMessageInDialog(messageSelect);
			return;
		}
		RequestContext.getCurrentInstance().execute("PF('editDepartmentDialog').show()");

	}

	// update
	public void saveUpdateDepartment() {
		FacesMessage messageExist = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ATTENZIONE",
				"Dipartimento già esistente");
		FacesMessage messageEdit = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "Dipartimento modificato");
		
		try {
			Department department = departmentService.getDepartmentByName(selectDepartment.getNameDep());
			if(department==null) {
					departmentService.updateDepartment(selectDepartment);
			reloadDepartment();
			RequestContext.getCurrentInstance().execute("PF('editDepartmentDialog').hide()");
			RequestContext.getCurrentInstance().showMessageInDialog(messageEdit);

		} else {
			RequestContext.getCurrentInstance().showMessageInDialog(messageExist);
			reloadDepartment();
		}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// delete
	public void deleteDepartment() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ATTENZIONE",
				"Selezionare un dipartimento");
		FacesMessage messageDelete = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "Dipartimento eliminato");
		if (selectDepartment == null) {
			RequestContext.getCurrentInstance().showMessageInDialog(message);
			setSelectDepartment(new Department());
			reloadDepartment();
			return;
		}
		try {
			departmentService.deleteDepartment(selectDepartment);
			RequestContext.getCurrentInstance().showMessageInDialog(messageDelete);
		} catch (Exception e) {
			FacesMessage messageError = new FacesMessage(FacesMessage.SEVERITY_FATAL, "ATTENZIONE",
					"Impossibile eliminare il dipartimento");
			;
			RequestContext.getCurrentInstance().showMessageInDialog(messageError);
			e.printStackTrace();
		}
		reloadDepartment();
	}

	// reload
	public void reloadDepartment() {
		setArrDepartment(departmentService.getAllDepartment());
	}

	public Department getDepartment() {
		return newDepartment;
	}

	public void setDepartment(Department departament) {
		this.newDepartment = departament;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public Department getNewDepartment() {
		return newDepartment;
	}

	public void setNewDepartment(Department newDepartment) {
		this.newDepartment = newDepartment;
	}

	public List<Department> getArrDepartment() {
		return arrDepartment;
	}

	public void setArrDepartment(List<Department> arrDepartment) {
		this.arrDepartment = arrDepartment;
	}

	public Department getSelectDepartment() {
		return selectDepartment;
	}

	public void setSelectDepartment(Department selectDepartment) {
		this.selectDepartment = selectDepartment;
	}

}
