package app;

import java.util.List;

import dao.ReimbursmentDAOImpl;

public class ReimbursmentService {

	private static ReimbursmentService rs;
	
	private ReimbursmentService() {
		
	}
	
	public static ReimbursmentService getRService() {
		if(rs == null) {
			rs = new ReimbursmentService();
		}
		
		return rs;
	}
	
	public Reimbursment getReimbursment(int rid) {
		return ReimbursmentDAOImpl.getReimbursmentDAO().getReimbursment(rid);
	}
	
	public boolean submitReimbursment(Reimbursment r) {
		return ReimbursmentDAOImpl.getReimbursmentDAO().submitReimbursment(r);
	}
	
	public boolean approveReimbursment(int rid, int mid) {
		return ReimbursmentDAOImpl.getReimbursmentDAO().resolveReimbursment(rid, "approved", mid);
	}
	
	public boolean rejectReimbursment(int rid, int mid) {
		return ReimbursmentDAOImpl.getReimbursmentDAO().resolveReimbursment(rid, "rejected", mid);
	}
	
	public List<Reimbursment> viewAllPending(){
		return ReimbursmentDAOImpl.getReimbursmentDAO().viewPending();
	}
	
	public List<Reimbursment> viewAllResolved(){
		return ReimbursmentDAOImpl.getReimbursmentDAO().viewResolved();
	}
	
	public List<Reimbursment> viewEmployeePending(int uid){
		return ReimbursmentDAOImpl.getReimbursmentDAO().viewEmployeePending(uid);
	}
	
	public List<Reimbursment> viewEmployeeResolved(int uid){
		return ReimbursmentDAOImpl.getReimbursmentDAO().viewEmployeeResolved(uid);
	}
	
	public List<Reimbursment> viewEmployeeReimbursment(int uid){
		return ReimbursmentDAOImpl.getReimbursmentDAO().viewEmployeeReimbursment(uid);
	}
}
