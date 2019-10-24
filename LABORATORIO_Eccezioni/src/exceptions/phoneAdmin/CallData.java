package exceptions.phoneAdmin;

import java.time.Duration;

class CallData {
	private String number;
	private Duration duration;
	private Boolean isReceived;
	
	CallData(String number, Duration duration, Boolean isReceived){
		this.duration = duration;
		this.number = number;
		this.isReceived = isReceived;
	}
	
	/**
	 * Returns the phone number of this data
	 * @return the phone number
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * Set actual phone number to the new one
	 * @param number the new phone number REQUIRE not null String, no characters except '+' '-' ' ' and numbers
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	
	public Duration getDuration() {
		return duration;
	}
	
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	
	public Boolean isReceived() {
		return isReceived;
	}
	
}
