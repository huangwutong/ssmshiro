package com.angsentech.ssm.dao;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: IAbstractDAO 
 * @Description: TODO(抽象Dao) 
 * @author 孙钊宁
 * @date 2016年7月26日
 * @version 1.0
 * @param <T>
 */
public interface AbstractDao<T> extends SqlMapper {
	/**
	 * @author 孙钊宁
	 * @date 2016年7月26日
	 * @version 1.0.0
	 * @Title: findObjByid 
	 * @Description: TODO(该方法是用来根据主键查找对象) 
	 * @param @param id
	 * @param @return
	 * @return T
	 * @throws
	 */
    public T findObjByid(Long id);
    /**
     * @author 孙钊宁
     * @date 2016年7月26日
     * @version 1.0.0
     * @Title: queryObjsList 
     * @Description: TODO(该方法是用来查找对象列表) 
     * @param @return
     * @return List<T>
     * @throws
     */
    public List<T> queryObjsList();
    /**
     * @author 孙钊宁
     * @date 2016年7月26日
     * @version 1.0.0
     * @Title: queryObjsCount 
     * @Description: TODO(该方法是用来查找对象总数) 
     * @param @param t
     * @param @return
     * @return Integer
     * @throws
     */
    public Integer queryObjsCount(T t);
    /**
     * @author 孙钊宁
     * @date 2016年7月26日
     * @version 1.0.0
     * @Title: insert 
     * @Description: TODO(该方法是用来插入一条对象) 
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
     * @Description: TODO(该方法是用来更新一个对象) 
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
     * @Description: TODO(该方法是用来根据主键删除一个对象) 
     * @param @param id
     * @return Integer
     * @throws
     */
    public Integer delete(Long id);
    /**
     * @author 孙钊宁
     * @date 2016年7月26日
     * @version 1.0.0
     * @Title: queryListByMap 
     * @Description: TODO(根据Map对象查找返回列表) 
     * @param @param map
     * @return List<T>
     * @throws
     */
    public List<T> queryListByMap(Map<String,Object> map);
    /**
     * @author 孙钊宁
     * @date 2016年7月26日
     * @version 1.0.0
     * @Title: queryCountByMap 
     * @Description: TODO(根据Map对象查找返回总数) 
     * @param @param map
     * @return Integer
     * @throws
     */
    public Integer queryCountByMap(Map<String,Object> map);
}
