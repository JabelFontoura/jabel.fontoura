package br.com.crescer.social.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import static org.springframework.http.HttpMethod.POST;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * @author carloshenrique
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SocialWebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Value("${social.security:/usuario}")
  private String[] securityPublic;

  @Autowired
  private SocialUserDetailsService userDetailsService;

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
            .authorizeRequests().antMatchers(POST, securityPublic).permitAll()
            .and()
            .authorizeRequests().antMatchers("/**").authenticated()
            .and()
            .httpBasic()
            .and()
            .logout().logoutUrl("/logout").deleteCookies("JSESSIONID").permitAll()
            .and()
            .cors()
            .and()
            .csrf().disable();
  }

  @Autowired
  public void setDetailsService(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
    return source;
  }
}
