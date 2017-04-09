package com.qkjt.qkkt.common.utils;

import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertyResolver;
import org.springframework.core.env.PropertySourcesPropertyResolver;
import org.springframework.core.io.support.ResourcePropertySource;

public class PropertyConfig {
    
   
    
    public static String getProperty(String key) {
        MutablePropertySources propertySources = new MutablePropertySources(); 
        try{
            ResourcePropertySource propertySource1 = new ResourcePropertySource("mfp","classpath:mfp.properties"); 
            ResourcePropertySource propertySource2 = new ResourcePropertySource("sys-product", "classpath:sys-product.properties"); 
            propertySources.addFirst(propertySource1);  
            propertySources.addLast(propertySource2);  
        }catch(Exception e){
            e.printStackTrace();
        }
        PropertyResolver propertyResolver = new PropertySourcesPropertyResolver(propertySources); 
        return  propertyResolver.getProperty(key);
    }
    


}
