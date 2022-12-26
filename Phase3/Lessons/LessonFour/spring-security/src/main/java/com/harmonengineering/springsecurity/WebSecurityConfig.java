package com.harmonengineering.springsecurity;
//import com.harmonengineering.springsecurity.security.CustomUserDetailsService;

import com.harmonengineering.authentication.AuthenticateResult;
import com.harmonengineering.authentication.AuthenticationService;
import com.harmonengineering.beans.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.ArrayList;

@Configuration
class Config
{
    @Bean    public AuthenticationService newAuthenticationService()
    {
        return new AuthenticationService() ;
    }
    @Bean    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        return encoder;
//    }
}
@Configuration
@EnableWebSecurity
//@EnableAuthorizationServer
//@EnableJpaRepositories
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired AuthenticationService authenticationService ;
    @Autowired PasswordEncoder encoder ;

    protected void configure( AuthenticationManagerBuilder builder )
            throws Exception
    {
        authenticationService.PasswordEncoder( encoder ) ;
        ArrayList<String> auths;
        UserPrincipal user = new UserPrincipal();
        user.setUserName("user");
        user.setUserPassword(encoder.encode("password"));

        auths = new ArrayList<>();
        auths.add("USER");
        user.GrantUserAuthorities(auths);

        UserPrincipal admin = new UserPrincipal();
        admin.setUserName("admin");
        admin.setUserPassword(encoder.encode("admin"));
        auths = new ArrayList<>();
        auths.add("USER");
        auths.add("ADMIN");
        admin.GrantUserAuthorities(auths);

        AuthenticateResult result ;
        result = authenticationService
                .getAuthenticator()
                .AddUser(user, user.getUserPassword());

        System.out.println( result.getResultStatus() ) ;
        System.out.println( result.getUser().getUserName());
        System.out.println( result.getUser().getUserPassword());

        result = authenticationService
                .getAuthenticator()
                .AddUser(admin, admin.getUserPassword()) ;

        System.out.println( result.getResultStatus() ) ;
        System.out.println( result.getUser().getUserName());
        System.out.println( result.getUser().getUserPassword());

        builder.authenticationProvider( this.authenticationService ) ;
        //builder.userDetailsService( this.customUserDetailsService ) ;
    }

    public void configure(WebSecurity security )
    {
        security.ignoring().antMatchers("/resources/**") ;
    }

    protected void configure( HttpSecurity http )
            throws  Exception
    {

        http.authorizeRequests()
                .antMatchers("/", "/index.html", "/signup.html", "/about.html").permitAll()
                .antMatchers("/secure/**").hasAuthority("USER")
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                //         .antMatchers("/resource.html").hasAuthority("USER")
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/UserLogin.html").failureUrl(
                        "/UserLogin.html?errormsg=Login%20failed.%20Please%20retry.")
                .defaultSuccessUrl("/index.html")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .and().logout()
                .logoutUrl("/logout.html").logoutSuccessUrl("/UserLogoutMessage.html")
                .invalidateHttpSession(true).deleteCookies("JSESSIONID")
                .permitAll()
                .and().csrf().disable();
        //.httpBasic();
        //return http.build();
    }
}
