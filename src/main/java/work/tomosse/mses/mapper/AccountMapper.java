package work.tomosse.mses.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import work.tomosse.mses.model.db.Account;
import work.tomosse.mses.model.db.AccountExample;

@Mapper
public interface AccountMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account
	 * @mbg.generated  Thu Feb 20 15:53:43 JST 2020
	 */
	long countByExample(AccountExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account
	 * @mbg.generated  Thu Feb 20 15:53:43 JST 2020
	 */
	int deleteByExample(AccountExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account
	 * @mbg.generated  Thu Feb 20 15:53:43 JST 2020
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account
	 * @mbg.generated  Thu Feb 20 15:53:43 JST 2020
	 */
	int insert(Account record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account
	 * @mbg.generated  Thu Feb 20 15:53:43 JST 2020
	 */
	int insertSelective(Account record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account
	 * @mbg.generated  Thu Feb 20 15:53:43 JST 2020
	 */
	List<Account> selectByExample(AccountExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account
	 * @mbg.generated  Thu Feb 20 15:53:43 JST 2020
	 */
	Account selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account
	 * @mbg.generated  Thu Feb 20 15:53:43 JST 2020
	 */
	int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account
	 * @mbg.generated  Thu Feb 20 15:53:43 JST 2020
	 */
	int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account
	 * @mbg.generated  Thu Feb 20 15:53:43 JST 2020
	 */
	int updateByPrimaryKeySelective(Account record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table account
	 * @mbg.generated  Thu Feb 20 15:53:43 JST 2020
	 */
	int updateByPrimaryKey(Account record);
}