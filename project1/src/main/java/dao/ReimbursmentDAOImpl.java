package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import app.Reimbursment;
import app.dbConnection;

public class ReimbursmentDAOImpl implements ReimbursmentDAO {

	Logger reimbursmentDaoLog = Logger.getLogger(ReimbursmentDAOImpl.class);

	private static ReimbursmentDAOImpl reDao;

	private ReimbursmentDAOImpl() {

	}

	public static ReimbursmentDAOImpl getReimbursmentDAO() {
		if (reDao == null) {
			reDao = new ReimbursmentDAOImpl();
		}

		return reDao;
	}

	@Override
	public Reimbursment getReimbursment(int rid) {
		
		try {
			Connection conn = dbConnection.getConnection();
			String sql = "select * from reimbursment where r_ID = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, rid);
			
			ResultSet rs = ps.executeQuery();
			
			Reimbursment r = null;
			
			while(rs.next()) {
				r = new Reimbursment(rs.getInt("r_ID"), rs.getFloat("amount"), rs.getString("title"), rs.getInt("u_ID"), rs.getDate("dateSubmitted"), rs.getString("status"), rs.getInt("manager_ID"));
			}
			
			return r;
		}catch(SQLException e) {
			reimbursmentDaoLog.error(e.getStackTrace());
		}
		
		return null;
	}

	@Override
	public boolean submitReimbursment(Reimbursment r) {
		
		try {
			Connection conn = dbConnection.getConnection();
			String sql = "call add_reimbursment(?, ?, ?)";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setFloat(1, r.getAmount());
			cs.setString(2, r.getDescription());
			cs.setInt(3,  r.getU_ID());
			
			return cs.executeUpdate() <= 0;
			
		}catch(SQLException e) {
			reimbursmentDaoLog.error(e.getStackTrace());
		}
		
		return false;
	}

	@Override
	public boolean resolveReimbursment(int rid, String newStatus, int mid) {
		
		try {
			Connection conn = dbConnection.getConnection();
			String sql = "update reimbursment set status = ?, manager_ID = ? where r_ID = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newStatus);
			ps.setInt(2, mid);
			ps.setInt(3, rid);
			
			return ps.executeUpdate() > 0;
			
		}catch(SQLException e) {
			reimbursmentDaoLog.error(e.getStackTrace());
		}
		
		return false;
	}

	@Override
	public List<Reimbursment> viewPending() {
		
		try {
			Connection conn = dbConnection.getConnection();
			String sql = "select * from reimbursment where status = 'pending'";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			List<Reimbursment> pendingR = new ArrayList<Reimbursment>();
			while(rs.next()) {
				Reimbursment r = new Reimbursment(rs.getInt("r_ID"), rs.getFloat("amount"), rs.getString("title"), rs.getInt("u_ID"), rs.getDate("dateSubmitted"), rs.getString("status"), rs.getInt("manager_ID"));
				
				pendingR.add(r);
			}
			
			return pendingR;
			
		}catch(SQLException e) {
			reimbursmentDaoLog.error(e.getStackTrace());
		}
		
		return null;
	}

	@Override
	public List<Reimbursment> viewResolved() {
		try {
			Connection conn = dbConnection.getConnection();
			String sql = "select * from reimbursment where status != 'pending'";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			List<Reimbursment> pendingR = new ArrayList<Reimbursment>();
			while(rs.next()) {
				Reimbursment r = new Reimbursment(rs.getInt("r_ID"), rs.getFloat("amount"), rs.getString("title"), rs.getInt("u_ID"), rs.getDate("dateSubmitted"), rs.getString("status"), rs.getInt("manager_ID"));
				
				pendingR.add(r);
			}
			
			return pendingR;
			
		}catch(SQLException e) {
			reimbursmentDaoLog.error(e.getStackTrace());
		}
		
		return null;
	}

	@Override
	public List<Reimbursment> viewEmployeePending(int uid) {
		
		try {
			Connection conn = dbConnection.getConnection();
			String sql = "select * from reimbursment where u_ID = ? and status = 'pending'";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			
			ResultSet rs = ps.executeQuery();
			
			List<Reimbursment> pendingR = new ArrayList<Reimbursment>();
			while(rs.next()) {
				Reimbursment r = new Reimbursment(rs.getInt("r_ID"), rs.getFloat("amount"), rs.getString("title"), rs.getInt("u_ID"), rs.getDate("dateSubmitted"), rs.getString("status"), rs.getInt("manager_ID"));
				
				pendingR.add(r);
			}
			
			return pendingR;
			
		}catch(SQLException e) {
			reimbursmentDaoLog.error(e.getStackTrace());
		}
		
		return null;
	}

	@Override
	public List<Reimbursment> viewEmployeeResolved(int uid) {

		try {
			Connection conn = dbConnection.getConnection();
			String sql = "select * from reimbursment where u_ID = ? and status != 'pending'";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			
			ResultSet rs = ps.executeQuery();
			
			List<Reimbursment> pendingR = new ArrayList<Reimbursment>();
			while(rs.next()) {
				Reimbursment r = new Reimbursment(rs.getInt("r_ID"), rs.getFloat("amount"), rs.getString("title"), rs.getInt("u_ID"), rs.getDate("dateSubmitted"), rs.getString("status"), rs.getInt("manager_ID"));
				
				pendingR.add(r);
			}
			
			return pendingR;
			
		}catch(SQLException e) {
			reimbursmentDaoLog.error(e.getStackTrace());
		}
		
		return null;
	}

	@Override
	public List<Reimbursment> viewEmployeeReimbursment(int uid) {

		try {
			Connection conn = dbConnection.getConnection();
			String sql = "select * from reimbursment where u_ID = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			
			ResultSet rs = ps.executeQuery();
			
			List<Reimbursment> pendingR = new ArrayList<Reimbursment>();
			while(rs.next()) {
				Reimbursment r = new Reimbursment(rs.getInt("r_ID"), rs.getFloat("amount"), rs.getString("title"), rs.getInt("u_ID"), rs.getDate("dateSubmitted"), rs.getString("status"), rs.getInt("manager_ID"));
				
				pendingR.add(r);
			}
			
			return pendingR;
			
		}catch(SQLException e) {
			reimbursmentDaoLog.error(e.getStackTrace());
		}
		
		return null;
	}

}
