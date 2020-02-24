package work.tomosse.mses.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import work.tomosse.mses.model.db.Msns;
import work.tomosse.mses.model.db.MsnsExample;

@Mapper
public interface MsnsMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msns
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	long countByExample(MsnsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msns
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	int deleteByExample(MsnsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msns
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msns
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	int insert(Msns record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msns
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	int insertSelective(Msns record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msns
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	List<Msns> selectByExample(MsnsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msns
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	Msns selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msns
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	int updateByExampleSelective(@Param("record") Msns record, @Param("example") MsnsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msns
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	int updateByExample(@Param("record") Msns record, @Param("example") MsnsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msns
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	int updateByPrimaryKeySelective(Msns record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msns
	 * @mbg.generated  Tue Feb 25 03:33:28 JST 2020
	 */
	int updateByPrimaryKey(Msns record);
}