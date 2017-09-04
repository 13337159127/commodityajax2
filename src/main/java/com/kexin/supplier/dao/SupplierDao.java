package com.kexin.supplier.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kexin.supplier.entity.SupplierEntity;

/**
 * 对供货商进行增 删 改 查
 * 
 * @author caokexin
 *
 */
@Repository("supplierDao")
public class SupplierDao {

	@Resource
    private SqlSessionTemplate sqlSessionTemplate;  
	/**
	 * 查询供货商的信息
	 * 
	 * @return 返回供货商信息列表
	 * @throws Exception
	 *             抛出异常
	 */
	public List<SupplierEntity> findSupplier() throws Exception {
		 return sqlSessionTemplate.selectList("com.kexin.supplier.dao.SupplierDao.findSupplier");
	}

	/**
	 * 根据ID查询供货商的信息
	 * 
	 * @return 返回修改供货商信息列表
	 * @throws Exception
	 *             抛出异常
	 */
	public List getSupplierbyId(String supplierID) throws Exception {
		 return sqlSessionTemplate.selectList("com.kexin.supplier.dao.SupplierDao.getSupplierbyId", supplierID);
	}

	/**
	 * 修改供货商信息
	 * 
	 * @param supplierID
	 *            供货商ID
	 * @param supplierName
	 *            供货商姓名
	 * @param supplierAddress
	 *            供货商地址
	 * @param supplierPhone
	 *            供货商电话
	 * @return 返回修改供货商信息
	 * @throws Exception
	 *             抛出异常
	 */
	public int updateSupplier(String supplierID, String supplierName, String supplierAddress, String supplierPhone)
			throws Exception {
		 SupplierEntity supplierentity=new SupplierEntity();
		 supplierentity.setSupplierID(supplierID);
		 supplierentity.setSupplierAddress(supplierAddress);
		 supplierentity.setSupplierName(supplierName);
		 supplierentity.setSupplierPhone(supplierPhone);
		 return sqlSessionTemplate.update("com.kexin.supplier.dao.SupplierDao.updateSupplier",supplierentity);
	}

	/**
	 * 添加供货商信息
	 * 
	 * @param supplierID
	 *            供货商ID
	 * @param supplierName
	 *            供货商姓名
	 * @param supplierAddress
	 *            供货商地址
	 * @param supplierPhone
	 *            供货商电话
	 * @return 返回添加供货商信息
	 * @throws Exception
	 *             抛出异常
	 */
	public int addSupplier(String supplierID, String supplierName, String supplierAddress, String supplierPhone)
			throws Exception {
		 SupplierEntity supplierentity=new SupplierEntity();
		 supplierentity.setSupplierID(supplierID);
		 supplierentity.setSupplierAddress(supplierAddress);
		 supplierentity.setSupplierName(supplierName);
		 supplierentity.setSupplierPhone(supplierPhone);
		 return sqlSessionTemplate.insert("com.kexin.supplier.dao.SupplierDao.addSupplier",supplierentity);
	}

	/**
	 * 删除供货商信息
	 * 
	 * @param supplierID
	 *            供货商ID
	 * @return 返回删除信息
	 * @throws Exception
	 *             抛出异常
	 */
	public int deleteSupplier(String supplierID) throws Exception {
		 return sqlSessionTemplate.delete("com.kexin.supplier.dao.SupplierDao.deleteSupplier",supplierID); 
	}
}