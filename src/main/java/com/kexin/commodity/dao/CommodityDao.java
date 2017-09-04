package com.kexin.commodity.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

/**
 * 实现接口的类 对商品信息进行增，删，改，查
 * 
 * @author caokexin
 * 
 */
@Repository("commodityDao")
public class CommodityDao   {

	@Resource
    private SqlSessionTemplate sqlSessionTemplate; 
	/**
	 * 查询商品信息
	 * 
	 * @param loginname
	 *            根据用户名查询
	 * @param classify
	 *            根据分类查询
	 * @param designation
	 *            根据商品名称查询
	 * @param sort
	 *            根据商品ID，数量，价格排序
	 * @return 返回根据 用户名，分类查询属性，名称查询属性，排序属性查询商品信息
	 * @throws Exception
	 *             抛出异常
	 */
	public List<Map<String,String>> findCommodity(String loginname, String classify, String designation, String sort)
			throws Exception {
		Map<String,String> map=new HashMap<String,String>();
		map.put("designation",designation);
		map.put("classify",classify);
		map.put("loginname",loginname);
		map.put("sort",sort);
		return sqlSessionTemplate.selectList("com.kexin.commodity.dao.CommodityDao.findCommodity",map);
	}

	/**
	 * 添加商品信息
	 * 
	 * @param commodityId
	 *            商品ID
	 * @param commodityName
	 *            商品名称
	 * @param commodityPrice
	 *            商品价格
	 * @param commodityMuch
	 *            商品数量
	 * @param commodityPeriod
	 *            商品保质期
	 * @param commodityYiedly
	 *            商品生产地
	 * @param categoryId
	 *            商品分类ID
	 * @param userId
	 *            商品用户名ID
	 * @return 返回添加商品的ID,名称，数量，价格保质期，生产地，分类，用户名
	 * @throws Exception
	 *             抛出异常
	 */
	public int addCommodity(String commodityId, String commodityName, String commodityPrice, String commodityMuch,
			String commodityPeriod, String commodityYiedly, String categoryId, String userId) throws Exception {
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Map  map=new HashMap();
		 map.put("commodityId",commodityId);
		 map.put("commodityName",commodityName);
		 map.put("commodityPrice",commodityPrice);
		 map.put("commodityMuch",commodityMuch);
		 map.put("commodityPeriod",commodityPeriod);
		 map.put("commodityYiedly",commodityYiedly);
		 map.put("categoryId",categoryId);
		 map.put("userId",userId);
		 map.put("sdf",sdf.format(new Date()));
		 return sqlSessionTemplate.insert("com.kexin.commodity.dao.CommodityDao.addCommodity",map);
	}

	/**
	 * 根据ID查询商品信息（修改商品信息使用）
	 * 
	 * @param commodityId
	 *            商品ID
	 * @return 返回根据ID查询的商品信息
	 * @throws Exception
	 *             抛出异常
	 */
	public List getCommoditybyId(String commodityId) throws Exception {
		 return sqlSessionTemplate.selectList("com.kexin.commodity.dao.CommodityDao.getCommoditybyId",commodityId);
	}

	/**
	 * 修改商信息
	 * 
	 * @param commodityId
	 *            商品ID
	 * @param commodityName
	 *            商品名称
	 * @param commodityPrice
	 *            商品价格
	 * @param commodityMuch
	 *            商品数量
	 * @param commodityPeriod
	 *            商品保质期
	 * @param commodityYiedly
	 *            商品生产地
	 * @param categoryId
	 *            商品分类
	 * @return 返回修改商品的ID,名称，数量，价格保质期，生产地，分类
	 * @throws Exception
	 *             抛出异常
	 */
	public int updateCommodity(String commodityId, String commodityName, String commodityPrice, String commodityMuch,
			String commodityPeriod, String commodityYiedly, String categoryId) throws Exception {
		  Map<String,String> map=new HashMap<String,String>();
		  map.put("commodityId",commodityId);
		  map.put("commodityName",commodityName);
		  map.put("commodityPrice",commodityPrice);
		  map.put("commodityMuch", commodityMuch);
		  map.put("commodityPeriod",commodityPeriod);
		  map.put("commodityYiedly",commodityYiedly);
		  map.put("categoryId", categoryId);
		  return sqlSessionTemplate.update("com.kexin.commodity.dao.CommodityDao.updateCommodity",map);
	}

	/**
	 * 根据ID删除商品信息
	 * 
	 * @param commodityId
	 *            商品ID
	 * @return 返回根据商品ID删除商品的信息
	 * @throws Exception
	 *             抛出异常
	 */
	public int deleteCommodity(String commodityId) throws Exception {
		return sqlSessionTemplate.delete("com.kexin.commodity.dao.CommodityDao.deleteCommodity",commodityId);
	}

	/**
	 * 根据用户名查询商品总数
	 * 
	 * @param username
	 *            用户名
	 * @return 返回根据用户名查询商品的总数
	 * @throws Exception
	 *             抛出异常
	 */
	public List commoditySum(String username) throws Exception {
		return sqlSessionTemplate.selectList("com.kexin.commodity.dao.CommodityDao.commoditySum",username);
	}

	/**
	 * 每天录入商品总数
	 * 
	 * @return 返回每天录入商品的总数
	 * @throws Exception
	 *             抛出异常
	 */
	public List daySumCommodity() throws Exception {
		return sqlSessionTemplate.selectList("com.kexin.commodity.dao.CommodityDao.daySumCommodity");
	}

	/**
	 * 每个分类商品总数
	 * 
	 * @return 返回每个分类的商品总数
	 * @throws Exception
	 *             抛出异常
	 */
	public List classifySumCommodity() throws Exception {
		return sqlSessionTemplate.selectList("com.kexin.commodity.dao.CommodityDao.classifySumCommodity"); 
  }
}