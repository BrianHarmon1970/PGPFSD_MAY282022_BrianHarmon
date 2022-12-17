package com.harmonengineering;

import com.harmonengineering.beans.ConfiguredPortNumberBean;
import com.harmonengineering.beans.ReportCriteriaBean;
import com.harmonengineering.beans.ValidatorBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@EnableJpaRepositories
@Configuration
public class AppConfiguration
{
    @Bean public ValidatorBean newValidatorBean()
    {
        return new ValidatorBean() ;
    }
    @Bean public ReportCriteriaBean newReportCriteriaBean()
    {  return new ReportCriteriaBean() ; }
    @Bean public ConfiguredPortNumberBean newConfiguredPortNumberBean()
    {
        ConfiguredPortNumberBean portNumberBean = new ConfiguredPortNumberBean();
        return portNumberBean; }
}
