package com.kexin.supplier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kexin.supplier.dao.SupplierDao;
import com.kexin.supplier.entity.SupplierEntity;

@Service("supplierService")
public class SupplierService  {
	// 声明变量 @Autowired为变量赋值
	@Autowired
	private SupplierDao supplierDao;

	/**
	 * 查询供货商的信息
	 * 
	 * @return 返回供货商信息列表
	 * @throws Exception
	 *             抛出异常
	 */
	public List<SupplierEntity> findSupplier() throws Exception {
		return supplierDao.findSupplier();
	}

	/**
	 * 根据ID查询供货商的信息
	 * 
	 * @return 返回修改供货商信息列表
	 * @throws Exception
	 *             抛出异常
	 */
	public List getSupplierbyId(String supplierID) throws Exception {
		return supplierDao.getSupplierbyId(supplierID);
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
		return  supplierDao.updateSupplier(supplierID, supplierName, supplierAddress, supplierPhone);
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
		  return  supplierDao.addSupplier(supplierID, supplierName, supplierAddress, supplierPhone);
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
		return    supplierDao.deleteSupplier(supplierID);
	 
	}
}
