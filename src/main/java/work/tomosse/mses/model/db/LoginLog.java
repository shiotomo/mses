package work.tomosse.mses.model.db;

import java.util.Date;

public class LoginLog {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column login_log.id
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column login_log.account_id
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	private Long accountId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column login_log.login_time
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	private Date loginTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column login_log.created_at
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	private Date createdAt;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column login_log.updated_at
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	private Date updatedAt;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column login_log.id
	 * @return  the value of login_log.id
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column login_log.id
	 * @param id  the value for login_log.id
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column login_log.account_id
	 * @return  the value of login_log.account_id
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	public Long getAccountId() {
		return accountId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column login_log.account_id
	 * @param accountId  the value for login_log.account_id
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column login_log.login_time
	 * @return  the value of login_log.login_time
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	public Date getLoginTime() {
		return loginTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column login_log.login_time
	 * @param loginTime  the value for login_log.login_time
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column login_log.created_at
	 * @return  the value of login_log.created_at
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column login_log.created_at
	 * @param createdAt  the value for login_log.created_at
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column login_log.updated_at
	 * @return  the value of login_log.updated_at
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column login_log.updated_at
	 * @param updatedAt  the value for login_log.updated_at
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}