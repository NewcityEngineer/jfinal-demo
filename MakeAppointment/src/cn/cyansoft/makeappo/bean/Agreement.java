package cn.cyansoft.makeappo.bean;

public class Agreement {

	public static void main(String[] args) {
		String str="06010011601010601";
		System.out.println(str.substring(0, 2));
		System.out.println(str.substring(2, 4));
		System.out.println(str.substring(4, 7));
		System.out.println("20"+str.substring(7, 9)+"."+str.substring(9, 11)+"."+str.substring(11,13));
		System.out.println(str.substring(13, 15));
		System.out.println(str.substring(15, 17));
	}
	
	private int id;
	private String archiveID;
	private String agreementID;
	private String deptID;
	private String bankID;
	private String enterpriseID;
	private String agreementDate;
	private String cycle;
	private String renew;
	private String finishDate;
	private String pawnee; 
	private String pledgor;
	private String happenTime;
	private String enterDate;
	private String money;
	private String financingAmount;
	private String pledgeRatio;
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArchiveID() {
		return archiveID;
	}
	public void setArchiveID(String archiveID) {
		this.archiveID = archiveID;
	}
	public String getAgreementID() {
		return agreementID;
	}
	public void setAgreementID(String agreementID) {
		this.agreementID = agreementID;
	}
	public String getDeptID() {
		return deptID;
	}
	public void setDeptID(String deptID) {
		this.deptID = deptID;
	}
	public String getBankID() {
		return bankID;
	}
	public void setBankID(String bankID) {
		this.bankID = bankID;
	}
	public String getEnterpriseID() {
		return enterpriseID;
	}
	public void setEnterpriseID(String enterpriseID) {
		this.enterpriseID = enterpriseID;
	}
	public String getAgreementDate() {
		return agreementDate;
	}
	public void setAgreementDate(String agreementDate) {
		this.agreementDate = agreementDate;
	}
	public String getCycle() {
		return cycle;
	}
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	public String getRenew() {
		return renew;
	}
	public void setRenew(String renew) {
		this.renew = renew;
	}
	public String getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}
	public String getPawnee() {
		return pawnee;
	}
	public void setPawnee(String pawnee) {
		this.pawnee = pawnee;
	}
	public String getPledgor() {
		return pledgor;
	}
	public void setPledgor(String pledgor) {
		this.pledgor = pledgor;
	}
	public String getHappenTime() {
		return happenTime;
	}
	public void setHappenTime(String happenTime) {
		this.happenTime = happenTime;
	}
	public String getEnterDate() {
		return enterDate;
	}
	public void setEnterDate(String enterDate) {
		this.enterDate = enterDate;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getFinancingAmount() {
		return financingAmount;
	}
	public void setFinancingAmount(String financingAmount) {
		this.financingAmount = financingAmount;
	}
	public String getPledgeRatio() {
		return pledgeRatio;
	}
	public void setPledgeRatio(String pledgeRatio) {
		this.pledgeRatio = pledgeRatio;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
