package com.angsentech.ssm.util;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;


/**
 * @ClassName: PropertiesUtils 
 * @Description: TODO(配置文件读取通用类) 
 * @author 孙钊宁
 * @date 2016年7月26日
 */
public class PropertiesUtils extends PropertyPlaceholderConfigurer {

    private static Map<String, String> ctxPropertiesMap;

    @Override
    public void setLocations(Resource[] locations) {
        Resource rs = locations[0];
        try {
            // 读取资源文件
            Properties props = PropertiesLoaderUtils.loadProperties(rs);

            // 发布模式
            String productMode = props.getProperty("product_mode");
            // 文件目录
            String loadDir = props.getProperty("load_dir");
            // 加载文件
            String loadFile = props.getProperty("load_file");

            String[] files = loadFile.split(",");
            if (files.length > 0) {
                if (StringUtils.equals(productMode, "produce")) {
                    //生产环境
                    Resource[] newLocations = new UrlResource[files.length];
                    for (int i = 0, j = files.length; i < j; i++) {
                        newLocations[i] = new UrlResource("file:" + loadDir + File.separator + files[i]);
                    }
                    super.setLocations(newLocations);
                } else {
                    //开发环境
                    Resource[] newLocations = new ClassPathResource[files.length];
                    for (int i = 0, j = files.length; i < j; i++) {
                        newLocations[i] = new ClassPathResource(loadDir + "/" + productMode + "/" + files[i]);
                    }
                    super.setLocations(newLocations);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props) throws BeansException {
        super.processProperties(beanFactory, props);
        // 读取propertys到ctxPropertiesMap属性中
        ctxPropertiesMap = new HashMap<String, String>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            ctxPropertiesMap.put(keyStr, value);
        }
    }

    /**
     * 获取propertys值
     * 
     * @param name
     *            propertys的key值
     * @return
     * @author fanp
     * @date 2013-7-3
     */
    public static String getContextProperty(String name) {
        return ctxPropertiesMap.get(name);
    }

}
