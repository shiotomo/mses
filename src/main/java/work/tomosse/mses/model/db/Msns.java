package work.tomosse.mses.model.db;

public class Msns {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column msns.id
     *
     * @mbg.generated Thu Feb 20 15:53:43 JST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column msns.host
     *
     * @mbg.generated Thu Feb 20 15:53:43 JST 2020
     */
    private String host;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column msns.port
     *
     * @mbg.generated Thu Feb 20 15:53:43 JST 2020
     */
    private Integer port;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column msns.version
     *
     * @mbg.generated Thu Feb 20 15:53:43 JST 2020
     */
    private String version;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column msns.id
     *
     * @return the value of msns.id
     *
     * @mbg.generated Thu Feb 20 15:53:43 JST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column msns.id
     *
     * @param id the value for msns.id
     *
     * @mbg.generated Thu Feb 20 15:53:43 JST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column msns.host
     *
     * @return the value of msns.host
     *
     * @mbg.generated Thu Feb 20 15:53:43 JST 2020
     */
    public String getHost() {
        return host;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column msns.host
     *
     * @param host the value for msns.host
     *
     * @mbg.generated Thu Feb 20 15:53:43 JST 2020
     */
    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column msns.port
     *
     * @return the value of msns.port
     *
     * @mbg.generated Thu Feb 20 15:53:43 JST 2020
     */
    public Integer getPort() {
        return port;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column msns.port
     *
     * @param port the value for msns.port
     *
     * @mbg.generated Thu Feb 20 15:53:43 JST 2020
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column msns.version
     *
     * @return the value of msns.version
     *
     * @mbg.generated Thu Feb 20 15:53:43 JST 2020
     */
    public String getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column msns.version
     *
     * @param version the value for msns.version
     *
     * @mbg.generated Thu Feb 20 15:53:43 JST 2020
     */
    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }
}