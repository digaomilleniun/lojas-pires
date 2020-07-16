/**
 * 
 */
package br.com.rpires.lojaspiresprodutos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Rodrigo Pires
 *
 */
@Configuration
@EnableJpaRepositories(basePackages = "br.com.rpires.lojaspiresprodutos")
@PropertySource("application-test.properties")
@EnableTransactionManagement
public class H2JpaConfig {

}
