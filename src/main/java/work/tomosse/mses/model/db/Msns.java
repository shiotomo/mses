package work.tomosse.mses.model.db;

import java.util.Date;

public class Msns {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column msns.id
	 * @mbg.generated  Thu Mar 19 04:57:15 JST 2020
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column msns.host
	 * @mbg.generated  Thu Mar 19 04:57:15 JST 2020
	 */
	private String host;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column msns.port
	 * @mbg.generated  Thu Mar 19 04:57:15 JST 2020
	 */
	private Integer port;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column msns.version
	 * @mbg.generated  Thu Mar 19 04:57:15 JST 2020
	 */
	private String version;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column msns.created_at
	 * @mbg.generated  Thu Mar 19 04:57:15 JST 2020
	 */
	private Date createdAt;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column msns.updated_at
	 * @mbg.generated  Thu Mar 19 04:57:15 JST 2020
	 */
	private Date updatedAt;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column msns.id
	 * @return  the value of msns.id
	 * @mbg.generated  Thu Mar 19 04:57:15 JST 2020
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column msns.id
	 * @param id  the value for msns.id
	 * @mbg.generated  Thu Mar 19 04:57:15 JST 2020
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column msns.host
	 * @return  the value of msns.host
	 * @mbg.generated  Thu Mar 19 04:57:15 JST 2020
	 */
	public String getHost() {
		return host;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column msns.host
	 * @param host  the value for msns.host
	 * @mbg.generated  Thu Mar 19 04:57:15 JST 2020
	 */
	public void setHost(String host) {
		this.host = host == null ? null : host.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column msns.port
	 * @return  the value of msns.port
	 * @mbg.generated  Thu Mar 19 04:57:15 JST 2020
	 */
	public Integer getPort() {
		return port;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column msns.port
	 * @param port  the value for msns.port
	 * @mbg.generated  Thu Mar 19 04:57:15 JST 2020
	 */
	public void setPort(Integer port) {
		this.port = port;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column msns.version
	 * @return  the value of msns.version
	 * @mbg.generated  Thu Mar 19 04:57:15 JST 2020
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column msns.version
	 * @param version  the value for msns.version
	 * @mbg.generated  Thu Mar 19 04:57:15 JST 2020
	 */
	public void setVersion(String version) {
		this.version = version == null ? null : version.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column msns.created_at
	 * @return  the value of msns.created_at
	 * @mbg.generated  Thu Mar 19 04:57:15 JST 2020
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column msns.created_at
	 * @param createdAt  the value for msns.created_at
	 * @mbg.generated  Thu Mar 19 04:57:15 JST 2020
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column msns.updated_at
	 * @return  the value of msns.updated_at
	 * @mbg.generated  Thu Mar 19 04:57:15 JST 2020
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column msns.updated_at
	 * @param updatedAt  the value for msns.updated_at
	 * @mbg.generated  Thu Mar 19 04:57:15 JST 2020
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}