/**
 * 
 */
package uk.bl.wa.whois;

/**
 * @author Andrew Jackson <Andrew.Jackson@bl.uk>
 *
 */
public class WhoisResult {
	
	private final boolean isUK;
	
	private final String record;
	
	public WhoisResult(boolean isUK, String record) {
		this.isUK = isUK;
		this.record = record;
	}

	/**
	 * @return the isUK
	 */
	public boolean isUK() {
		return isUK;
	}

	/**
	 * @return the record
	 */
	public String getRecord() {
		return record;
	}
	
}
