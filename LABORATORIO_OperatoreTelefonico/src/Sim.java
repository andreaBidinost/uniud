import java.time.Duration;
import java.util.Date;
import java.util.List;

class Sim {
	
	private String number;
	private Integer puk;
	private Double residual;
	private List<CallData> calls;
	private Date lastRechargeDate;
	private Person owner;
	private Promotions activePromo;
	private Boolean isOriginal;
	
	String getNumber() {
		return number;
	}

	void setNumber(String number) {
		this.number = number;
	}

	Integer getPuk() {
		return puk;
	}

	void setPuk(Integer puk) {
		this.puk = puk;
	}

	Double getResidual() {
		return residual;
	}

	void setResidual(Double residual) {
		this.residual = residual;
	}

	List<CallData> getCalls() {
		return calls;
	}

	void setCalls(List<CallData> calls) {
		this.calls = calls;
	}

	Date getLastRechargeDate() {
		return lastRechargeDate;
	}

	void setLastRechargeDate(Date lastRechargeDate) {
		this.lastRechargeDate = lastRechargeDate;
	}

	Person getOwner() {
		return owner;
	}

	void setOwner(Person owner) {
		this.owner = owner;
	}

	Promotions getActivePromo() {
		return activePromo;
	}

	void setActivePromo(Promotions activePromo) {
		this.activePromo = activePromo;
	}

	Boolean getIsOriginal() {
		return isOriginal;
	}

	void setIsOriginal(Boolean isOriginal) {
		this.isOriginal = isOriginal;
	}

	
	
	/**
	 * Build a new SIM.
	 * @param owner the owner of the new SIM. REQUIRE not null
	 * @param number the new phone number
	 * @param puk the new puk
	 */
	Sim(Person owner, String number, Integer puk){
		this.owner = owner;
		this.number = number;
		this.puk = puk;
	}
	
	/**
	 * Build a new SIM.
	 * @param owner the owner of the new SIM. REQUIRE not null
	 * @param oldSim the old SIM data
	 */
	Sim(Person owner, Sim oldSim){
		this.owner = owner;
		this.number = oldSim.getNumber();
	}
	
	
	/**
	 * Add a new data of a previous call to the list
	 * @param data data of previous call. REQUIRE not null
	 */
	void addCallData(CallData data){
		calls.add(data);
	}
	
	/**
	 * Return the total amount of minutes of all calls
	 * @return the minutes of all calls
	 */
	Duration getMinutesAmount() {
		Duration result = Duration.ZERO;
		
		for(CallData data:calls) {
			result = result.plus(data.getDuration());
		}
		
		return result;
	}
	
	
	/**
	 * Do a recharge to the actual SIM
	 * @param amount the amount of the recharge REQUIRE not negative
	 */
	void recharge(Double amount) {
		residual += amount;
	}
	
	
	
	
}
