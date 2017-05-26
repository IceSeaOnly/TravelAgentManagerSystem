package site.binghai.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import site.binghai.Interceptors.GuiderInterceptor;
import site.binghai.Interceptors.LineManagerInterceptor;
import site.binghai.Interceptors.UserInterceptor;

/**
 * Created by IceSea on 2017/5/18.
 * GitHub: https://github.com/IceSeaOnly
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Bean
    public UserInterceptor userInterceptor(){
        return new UserInterceptor();
    }

    @Bean
    public GuiderInterceptor guiderInterceptor(){
        return new GuiderInterceptor();
    }

    @Bean
    public LineManagerInterceptor lineManagerInterceptor(){
        return new LineManagerInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor()).addPathPatterns("/user/**");
        registry.addInterceptor(guiderInterceptor()).addPathPatterns("/guider/**");
        registry.addInterceptor(lineManagerInterceptor()).addPathPatterns("/lm/**");
        super.addInterceptors(registry);
    }
}
