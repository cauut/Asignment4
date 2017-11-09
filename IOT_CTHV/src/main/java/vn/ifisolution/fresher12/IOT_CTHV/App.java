package vn.ifisolution.fresher12.IOT_CTHV;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import vn.ifisolution.fresher12.IOT_CTHV.configuration.CassandraConfiguration;

/**
 * Hello world!
 *
 */
@Import(CassandraConfiguration.class)
@SpringBootApplication(scanBasePackages = {"vn.ifisolution.fresher12.IOT_CTHV"})
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}
