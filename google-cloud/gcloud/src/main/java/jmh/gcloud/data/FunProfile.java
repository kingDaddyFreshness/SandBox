package jmh.gcloud.data;

import com.google.cloud.datastore.DateTimeValue;
import com.google.cloud.datastore.LongValue;
import java.util.Date;

public class FunProfile {
	
	private String swid = null;
	private String firstName = null;
	private String affiliateName = null;
	
	//AutoLogin, 
	private Date birthday = null;
	private Date dateCreated = null;
	private Date dateModified = null;
	private Date dateRegistered = null; 
	private String emailAddress = null;
	private String gender = null;
	private String ISOCountryCode = null; 
	//ISOLanguageCode, 
	private String initial = null;
	private String lastName = null;
	//LegacyAffiliateId, 
	//LegacySourceId, 
	private Long modifiedBy = null;
	private String parentEmailAddress = null; 
	private String password = null; 
	//PasswordHint, 
	//PasswordHintValue, 
	//PasswordSalt, 
	//PostalCode, 
	private String prefix = null;
	//RegionCode, 
	//RowVersion, 
	//SiteCountryCode, 
	private String sourceName = null;
	private String status = null;
	private String suffix = null;
	//SystemId, 
	private String testAccount = null;
	private String username = null; 
	private String validated = null;
	private Long is_primary = null;
			
	
	public String getSwid() {
		return swid;
	}
	public void setSwid(String swid) {
		this.swid = swid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getAffiliateName() {
		return affiliateName;
	}
	public void setAffiliateName(String affiliateName) {
		this.affiliateName = affiliateName;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDateModified() {
		return dateModified;
	}
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	public Date getDateRegistered() {
		return dateRegistered;
	}
	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getISOCountryCode() {
		return ISOCountryCode;
	}
	public void setISOCountryCode(String iSOCountryCode) {
		ISOCountryCode = iSOCountryCode;
	}
	public String getInitial() {
		return initial;
	}
	public void setInitial(String initial) {
		this.initial = initial;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getParentEmailAddress() {
		return parentEmailAddress;
	}
	public void setParentEmailAddress(String parentEmailAddress) {
		this.parentEmailAddress = parentEmailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getTestAccount() {
		return testAccount;
	}
	public void setTestAccount(String testAccount) {
		this.testAccount = testAccount;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getValidated() {
		return validated;
	}
	public void setValidated(String validated) {
		this.validated = validated;
	}
	public Long getIsPrimary() {
		return is_primary;
	}
	public void setIsPrimary(Long is_primary) {
		this.is_primary = is_primary;
	}
	public void print() {
		StringBuilder sb = new StringBuilder();
		sb.append("swid:" + swid + "\n");
		sb.append("username:" + username + " password:" + password + "\n");
		sb.append("prefix:" + prefix + " first:" + firstName + " m:" + initial + " last:" + lastName + " s:" + suffix + "\n");
		System.out.println(sb.toString());
	}

}
