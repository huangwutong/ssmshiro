package com.angsentech.ssm.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;

/**
 * @ClassName: IAbstractService 
 * @Description: TODO(通用Service类) 
 * @author 孙钊宁
 * @date 2016年7月26日 
 * @version 1.0
 * @param <T>
 */
public interface AbstractService<T> {
	/**
	 * @author 孙钊宁
	 * @date 2016年7月26日 
	 * @version 1.0.0
	 * @Title: findObjByid 
	 * @Description: TODO(该方法是用来根据编号查找对象) 
	 * @param @param id
	 * @param @return
	 * @return T
	 * @throws
	 */
	public T findObjByid(Long id);
	/**
	 * <p>根据对象信息查找分页</p>
	 * @author 孙钊宁
	 * @date 2016年7月26日 
	 * @version 1.0.0
	 * @Title: queryObjs 
	 * @Description: TODO(该方法是用来根据对象信息查找分页) 
	 * @param @param pageNo
	 * @param @param pageSize
	 * @param @return
	 * @return PageInfo<T>
	 * @throws
	 */
	public PageInfo<T> queryObjs(Integer pageNo, Integer pageSize);
	/**
	 * @author 孙钊宁
	 * @date 2016年7月26日 
	 * @version 1.0.0
	 * @Title: add 
	 * @Description: TODO(该方法是用来添加一个对象) 
	 * @param @param t
	 * @return Integer
	 * @throws
	 */
    public Integer add(T t);
    /**
     * @author 孙钊宁
     * @date 2016年7月26日 
     * @version 1.0.0
     * @Title: update 
     * @Description: TODO(该方法是用来更新对象) 
     * @param @param t
     * @return Integer
     * @throws
     */
    public Integer update(T t);
    /**
     * @author 孙钊宁
     * @date 2016年7月26日 
     * @version 1.0.0
     * @Title: delete 
     * @Description: TODO(该方法是用来删除对象) 
     * @param @param id
     * @return Integer
     * @throws
     */
    public Integer delete(Long id);
    /**
     * @author 孙钊宁
     * @date 2016年7月26日 
     * @version 1.0.0
     * @Title: saveOrUpdate 
     * @Description: TODO(该方法是用来增加或更新对象) 
     * @param @param t
     * @param @return
     * @return Map<String,Object>
     * @throws
     */
    public Map<String, Object> saveOrUpdate(T t);
}
