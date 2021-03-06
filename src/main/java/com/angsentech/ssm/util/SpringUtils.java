package com.angsentech.ssm.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.MessageSourceAccessor;

/**
 * @ProjectNmae：util.
 * @ClassName：SpringUtil
 * @Description： (Spring 工具类)
 * @author：孙钊宁
 * @crateTime：2016-07-26
 * @editor：
 * @editTime：
 * @editDescription：
 * @version 1.0.0
 */
public class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext; // Spring应用上下文环境

    private static MessageSourceAccessor messageSourceAccessor; // spring国际化资源

    /**
     * @setApplicationContext(实现ApplicationContextAware接口的回调方法，设置上下文环境).
     * @author： 孙钊宁
     * @createTime：2013-5-22 下午1:36:50
     * @param applicationContext
     * @throws BeansException
     * @return void
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
        SpringUtils.messageSourceAccessor = new MessageSourceAccessor(applicationContext);
    }

    /**
     * @getApplicationContext(获取ApplicationContext).
     * @author： 孙钊宁
     * @crateTime：2016-07-26
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 
     * @containsBean(判断是否存在arg0 bean).
     * @author： 孙钊宁
     * @crateTime：2016-07-26
     * @param arg0
     *            bean名称
     * @return boolean
     */
    public static boolean containsBean(String arg0) {
        return applicationContext.containsBean(arg0);
    }

    /**
     * @getAliases(获取arg0 bean的别名).
     * @author： 孙钊宁
     * @crateTime：2016-07-26
     * @param arg0
     *            bean名称
     * @return String[]
     */
    public static String[] getAliases(String arg0) {
        return applicationContext.getAliases(arg0);
    }

    /**
     * @getBean(获取实例).
     * @author： chl
     * @crateTime：2016-07-26
     * @param arg0
     * @throws BeansException
     * @return T
     */
    public static <T> T getBean(Class<T> arg0) throws BeansException {
        return applicationContext.getBean(arg0);
    }

    /**
     * 
     * @getBean(根据bean名称和类型获取实例).
     * @author： 孙钊宁
     * @crateTime：2016-07-26
     * @param arg0
     *            bean名称
     * @param arg1
     *            实例类型
     * @return
     * @throws BeansException
     * @return T
     */
    public static <T> T getBean(String arg0, Class<T> arg1) throws BeansException {
        return applicationContext.getBean(arg0, arg1);
    }

    /**
     * 
     * @getBean(根据bean名称和类型数组获取实例).
     * @author： 孙钊宁
     * @crateTime：2016-07-26
     * @param arg0
     * @param arg1
     * @return
     * @throws BeansException
     * @return Object
     */
    public static Object getBean(String arg0, Object... arg1) throws BeansException {
        return applicationContext.getBean(arg0, arg1);
    }

    /**
     * 
     * @getBean(根据bean名称获取实例).
     * @author： 孙钊宁
     * @crateTime：2016-07-26
     * @param arg0
     *            bean名称
     * @return
     * @throws BeansException
     * @return Object
     */
    public static Object getBean(String arg0) throws BeansException {
        return applicationContext.getBean(arg0);
    }

    /**
     * @getBeanNamesForType(获取给定的类型(包括子类)的bean的名称).
     * @author： 孙钊宁
     * @crateTime：2016-07-26
     * @param arg0
     *            类型
     * @param arg1
     *            是否包括原型或是作用域
     * @param arg2
     *            是否初始化单例和创建的对象
     * @return
     * @return String[]
     */
    public static <T> String[] getBeanNamesForType(Class<T> arg0, boolean arg1, boolean arg2) {
        return applicationContext.getBeanNamesForType(arg0, arg1, arg2);
    }

    /**
     * @getBeanNamesForType(获取给定的类型(包括子类)的bean的名称).
     * @author： chl
     * @crateTime：2016-07-26
     * @param arg0
     * @return
     * @return String[]
     */
    public static <T> String[] getBeanNamesForType(Class<T> arg0) {
        return applicationContext.getBeanNamesForType(arg0);
    }

    /**
     * @getClassLoader(获取类加载器).
     * @author： 孙钊宁
     * @crateTime：2016-07-26
     * @return ClassLoader
     */
    public ClassLoader getClassLoader() {
        return applicationContext.getClassLoader();
    }

    /**
     * 获取国际化资源
     * @author： 孙钊宁
     * @crateTime：2016-07-26
     * @return
     */
    public static MessageSourceAccessor getMessageSource() {
        return messageSourceAccessor;
    }

}
