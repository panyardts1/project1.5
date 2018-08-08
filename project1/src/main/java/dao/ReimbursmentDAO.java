package dao;

import java.util.List;

import app.Reimbursment;

public interface ReimbursmentDAO {

	public Reimbursment getReimbursment(int rid);
	public boolean submitReimbursment(Reimbursment r);
	public boolean resolveReimbursment(int rid, String newStatus, int mid);
	public List<Reimbursment> viewPending();
	public List<Reimbursment> viewResolved();
	public List<Reimbursment> viewEmployeePending(int uid);
	public List<Reimbursment> viewEmployeeResolved(int uid);
	public List<Reimbursment> viewEmployeeReimbursment(int uid);
}
