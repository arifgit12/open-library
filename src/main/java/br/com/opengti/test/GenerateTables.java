package br.com.opengti.test;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;



public class GenerateTables {
	
	public static void main(String[] args) {
		
		Configuration configuration = new AnnotationConfiguration();
		configuration.configure();
		          
		SchemaExport schemaExport = new SchemaExport(configuration);  
		schemaExport.create(true, true);
		
	}

}
