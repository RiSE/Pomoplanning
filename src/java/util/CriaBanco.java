/**
*@ autores : Saulo de tarso Oliveira da Silva
*  29/03/2011
*/

package util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class CriaBanco
{
    public static void main(String args[])
    {
        AnnotationConfiguration cfg = new AnnotationConfiguration();
        cfg.getProperties().setProperty("hibernate.connection.password","postgres");
        cfg.getProperties().setProperty("hibernate.connection.username","postgres");
        cfg.configure();
        
        SchemaExport se = new SchemaExport(cfg);
        se.drop(true, true);
        se.create(true, true);
    }
}
