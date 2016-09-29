package kreps.config;

import kreps.security.RESTAuthenticationEntryPoint;
import kreps.security.RESTAuthenticationFailureHandler;
import kreps.security.RESTAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    RESTAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    RESTAuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    RESTAuthenticationFailureHandler authenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //@formatter:off
        http
                .authorizeRequests().anyRequest().authenticated().and()
                .httpBasic().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and()
//                .formLogin().successHandler(authenticationSuccessHandler).and()
//                .formLogin().failureHandler(authenticationFailureHandler).and()
                .csrf().disable();



        //@formatter:on
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.GET);
    }

}
