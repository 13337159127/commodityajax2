package com.kexin.classify.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kexin.classify.entity.ClassifyEntity;
/**
 * 对数据库进行访问   实现商品分类的  增  删  改  查  
 * @author caokexin
 *
 */
@Repository("classifyDao")
public class ClassifyDao  {
	 
	@Resource
    private SqlSessionTemplate sqlSessionTemplate;  
	/**
	 * 查询商品的分类 （添加，修改商品使用）
	 * 
	 * @return
	 *             查询商品的分类，返回商品分类的信息（添加，修改商品使用）
	 * @throws Exception
	 *             抛出异常
	 */
	public List selectClassify() throws Exception {
		return  sqlSessionTemplate.selectList("com.kexin.classify.dao.ClassifyDao.selectClassify");
	}

	/**
	 * 查询商品分类
	 * 
	 * @return
	 *             查询商品的分类信息，返回商品的分类信息表
	 * @throws Exception
	 *             抛出异常
	 */
	public List findClassify() throws Exception {
		return  sqlSessionTemplate.selectList("com.kexin.classify.dao.ClassifyDao.findClassify");	 
	}

	/**
	 * 添加商品分类
	 * 
	 * @param category
	 *            分类类别
	 * @param categoryId
	 *            分类ID
	 * @return
	 *            添加商品分类，返回商品分类ID和商品分类
	 * @throws Exception
	 *            抛出异常
	 */
	public int addClassify(String category, String categoryId) throws Exception {
		 ClassifyEntity entity=new  ClassifyEntity();
		 entity.setCategoryId(categoryId);
		 entity.setCategory(category);
		 return sqlSessionTemplate.insert("com.kexin.classify.dao.ClassifyDao.addClassify",entity);
	}

	/**
	 * 根据ID查询商品分类（修改商品信息使用）
	 * 
	 * @param categoryid
	 *            商品的ID
	 * @return
	 *            根据ID查询商品分类，返回分类的信息
	 * @throws Exception
	 *            抛出异常
	 */
	public List  getClassifybyId(String categoryid) throws Exception {
		return sqlSessionTemplate.selectList("com.kexin.classify.dao.ClassifyDao.getClassifybyId",categoryid);
	}

	/**
	 * 修改商品的分类
	 * 
	 * @param category
	 *            商品类别
	 * @param categoryId
	 *            商品ID
	 * @return
	 *            修改商品的分类，返回修改商品分类的信息
	 * @throws Exception
	 *            抛出异常
	 */
	public int updateClassify(String category, String categoryId) throws Exception {
		 ClassifyEntity entity=new  ClassifyEntity();
		  entity.setCategoryId(categoryId);
		  entity.setCategory(category);
		 return sqlSessionTemplate.update("com.kexin.classify.dao.ClassifyDao.updateClassify",entity);
	}

	/**
	 * 根据分类ID删除商品分类
	 * 
	 * @param categoryId
	 *            商品分类ID
	 * @return
	 *            根据分类ID删除商品分类，返回删除商品分类的信息
	 * @throws Exception
	 *            抛出异常
	 */
	public int deleteClassify(String categoryId) throws Exception {
		return sqlSessionTemplate.delete("com.kexin.classify.dao.ClassifyDao.deleteClassify",categoryId);
	}
}
