/**
 * 
 */
package org.hscieripple.audit.model;

import java.io.Serializable;
import java.util.Date;

/**
 * An audit record of access to patient data. Captures data regarding which user accessed which resource 
 * and at what time. In addition it captures the ID of the patient that the requested resource relates to.
 * 
 * @author WeatherillW
 *
 */
public class AuditDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String requesterUsername;
	private long targetNhsNumber;
	private String targetResource;
	private Date requestDateTime;
	
	public String getRequesterUsername() {
		return requesterUsername;
	}
	
	public void setRequesterUsername(String requesterUsername) {
		this.requesterUsername = requesterUsername;
	}
	
	public long getTargetNhsNumber() {
		return targetNhsNumber;
	}
	
	public void setTargetNhsNumber(Long targetNhsNumber2) {
		this.targetNhsNumber = targetNhsNumber2;
	}
	
	public String getTargetResource() {
		return targetResource;
	}
	
	public void setTargetResource(String targetResource) {
		this.targetResource = targetResource;
	}
	
	public Date getRequestDateTime() {
		return requestDateTime;
	}
	
	public void setRequestDateTime(Date requestDateTime) {
		this.requestDateTime = requestDateTime;
	}

	@Override
	public String toString() {
		return "AuditDetails [" + (requesterUsername != null ? "requesterUsername=" + requesterUsername + ", " : "")
				+ "targetNhsNumber=" + targetNhsNumber + ", "
				+ (targetResource != null ? "targetResource=" + targetResource + ", " : "")
				+ (requestDateTime != null ? "requestDateTime=" + requestDateTime : "") + "]";
	}
	
	
}
