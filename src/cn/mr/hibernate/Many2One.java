package cn.mr.hibernate;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author xuejiangtao 2013-6-13 下午11:12:02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:hibernate.cfg.xml" })
public class Many2One {

    private static SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Test
    public void testSaveOne2One() {
        Organization o = new Organization();
        o.setOrgName("谷度培训机构");

        Company c = new Company();
        c.setCompayName("广州分公司");

        Company c1 = new Company();
        c1.setCompayName("成都分公司");

        Company c2 = new Company();
        c2.setCompayName("天津分公司");

        Set set = new HashSet();
        set.add(c);
        set.add(c1);
        set.add(c2);

        o.setCompany(set);

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.save(o);
        session.save(c);
        session.save(c1);
        session.save(c2);

        session.beginTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testLoadOne2One() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Organization o = (Organization) session.load(Organization.class, 1);

        System.out.println(o.getId() + " " + o.getOrgName());

        Set list = o.getCompany();

        for (Iterator it = list.iterator(); it.hasNext();) {
            Company c = (Company) it.next();
            System.out.println(c.getId() + " " + c.getCompayName());
        }

        session.beginTransaction().commit();
    }

    @Test
    public void testDeleteOne2One() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        // Company c = (Company) session.load(Company.class, 1) ;

        // session.delete(c) ;

        session.beginTransaction().commit();
    }

    @BeforeClass
    public static void beforeClass() {
        /*
         * new SchemaExport(new AnnotationConfiguration().configure()) .create(true, true) ;
         */

        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @AfterClass
    public static void afterClass() {
        sessionFactory.close();
    }

}
