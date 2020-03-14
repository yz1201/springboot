package cn.dbdj1201.lazyman.config;

import cn.dbdj1201.lazyman.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author tyz1201
 * @datetime 2020-03-14 11:10
 * 配置拦截器，第一，声明是配置类，第二，实现WebMvcConfigurer接口
 **/
@Configuration
public class WebMvcConfiguration  implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/**");

    }
}
