package snippet;

public class Snippet {
	server.port=8080
	
	springfox.documentation.swagger.v2.path=/api-docs
	
	logging.level.fr.univbrest.dosi.spi=DEBUG
	logging.file=./log/logfile.log
	
	
	spring.datasource.url=jdbc:mysql://blo7dqvt0dtxfqehpwft-mysql.services.clever-cloud.com:3306/blo7dqvt0dtxfqehpwft
	spring.datasource.username=uswc5ktlbh7e4lgz
	spring.datasource.password=zljVMZzoK9xqFunuND5i
	
	
	spring.datasource.driver-class-name=com.mysql.jdbc.Driver
	
	spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
	
	spring.datasource.maxActive=1
	spring.datasource.tomcat.max-active=1
	
	# Validate the connection before borrowing it from the pool.
	spring.datasource.tomcat.test-on-borrow=true
	-- spring.jpa.hibernate.ddl-auto=update
}

