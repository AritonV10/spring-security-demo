package com.vio.spring5.springsecuritydemo.config;

import org.springframework.context.MessageSource;

@Configuration
@ComponentScan(basePackage = {"com.vio.spring5.springsecuritydemo.mvc"}
@EnableWebMvc
public class ControllersConfig extends WebConfigurerAdapter{

    
    /**
     * @{MessageSource} bean to use different languages for validations
     */
    @Bean
    public MessageSource messageSource() {
      ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
      messageSource.setBasename("classpath:/messages/messages");
      messageSource.setDefaultEncoding("UTF-8");
		
		return messageSource;
    }
  
   @Override
   public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
  }
  
   @Override
   public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("/", "/resources/");
  }
  
}
