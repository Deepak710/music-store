package DMB.PRJ.MusicBack.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages= {"DMB.PRJ.MusicBack"})
@EnableTransactionManagement
public class HibernateConfig {
	private static final String D_URL="jdbc:h2:tcp://localhost/~/musicstore";
	private static final String D_DRIVER="org.h2.Driver";
	private static final String D_DIALECT="org.hibernate.dialect.H2Dialect";
	private static final String D_UNAME="sa";
	private static final String D_PASS="";
	@Bean("ds")
	public DataSource getDataSource() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName(D_DRIVER);
		ds.setUrl(D_URL);
		ds.setUsername(D_UNAME);
		ds.setPassword(D_PASS);
		return ds;
	}
	@Bean
	public SessionFactory getSessionFactory(DataSource ds)
	{
		LocalSessionFactoryBuilder sfb = new LocalSessionFactoryBuilder(ds);
		sfb.addProperties(getHibernateProperties());
		sfb.scanPackages("DMB.PRJ.MusicBack");
		return sfb.buildSessionFactory();
		
	}
	private Properties getHibernateProperties() {
		Properties p = new Properties();
		p.put("hibernate.dialect", D_DIALECT);
		p.put("hibernate.show_sql", "true");
		p.put("hibernate.format_sql", "true");
		p.put("hibernate.hbm2ddl.auto", "update");
		return p;
	}
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sf)
	{
		HibernateTransactionManager htm=new HibernateTransactionManager(sf);
		return htm;
	}
}
