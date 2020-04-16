package imk.tn.jdbcSpringbootSecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Autowired
	DataSource dataSource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource);
		//.usersByUsernameQuery("select username,password, enabled from users where username = ?")         // when we use a different table for user
		//.authoritiesByUsernameQuery("select username,authority from authorities where username = ?");
		//.withDefaultSchema()
		//.withUser("foo").password(passwordEncoder().encode("foo")).roles("ADMIN"); // We can add user like that in H2 DB
	}

	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
        .antMatchers("/h2-console").permitAll()
        .antMatchers("/").permitAll()
        .antMatchers("/user").hasRole("USER")
        .antMatchers("/admin").hasAnyRole("USER","ADMIN")
        .and().formLogin()
        .and().logout().logoutSuccessUrl("/login").permitAll()
       .and().csrf().disable();
         
       
    }
	
	
	
	

}
