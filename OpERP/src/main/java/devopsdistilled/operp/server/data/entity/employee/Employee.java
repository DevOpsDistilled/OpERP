package devopsdistilled.operp.server.data.entity.employee;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import devopsdistilled.operp.server.data.entity.Entiti;
import devopsdistilled.operp.server.data.entity.account.PayableAccount;
import devopsdistilled.operp.server.data.entity.commons.ContactInfo;

@Entity
public class Employee extends Entiti<Long> {

	private static final long serialVersionUID = -7806347667142118294L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;

	private String employeeName;

	private ContactInfo contactInfo;

	private PayableAccount account;

	private Double salary;

	private String designation;

	@Temporal(TemporalType.DATE)
	private Date joinedDate;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public PayableAccount getAccount() {
		return account;
	}

	public void setAccount(PayableAccount account) {
		this.account = account;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	@Override
	public Long id() {
		return getEmployeeId();
	}

	@Override
	public String toString() {
		return new String(getEmployeeId().toString() + ": " + getEmployeeName());
	}
}
