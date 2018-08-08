package app;

import java.util.Date;

public class Reimbursment {

	private int r_ID;
	private float amount;
	private String description;
	private int u_ID;
	private Date dateSubmitted;
	private String status;
	private int m_ID;
	
	public Reimbursment(int r_ID, float amount, String description, int u_ID, Date dateSubmitted, String status,
			int m_ID) {
		super();
		this.r_ID = r_ID;
		this.amount = amount;
		this.description = description;
		this.u_ID = u_ID;
		this.dateSubmitted = dateSubmitted;
		this.status = status;
		this.m_ID = m_ID;
	}

	public int getR_ID() {
		return r_ID;
	}

	public void setR_ID(int r_ID) {
		this.r_ID = r_ID;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getU_ID() {
		return u_ID;
	}

	public void setU_ID(int u_ID) {
		this.u_ID = u_ID;
	}

	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getM_ID() {
		return m_ID;
	}

	public void setM_ID(int m_ID) {
		this.m_ID = m_ID;
	}

	@Override
	public String toString() {
		return r_ID + "	" + amount + "	" + description + "	" + u_ID
				+ "	" + dateSubmitted + "	" + status + "	" + m_ID;
	}
	
	
}
