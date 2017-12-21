package cn.mr.hibernate;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class AbstractBaseTestCase {
    private SessionFactory sessionFactory;

    private Session session;

    protected FileSystemXmlApplicationContext dsContext;

    private String[] configStr = { "/WebRoot/WEB-INF/classes/*.xml" };

    @Before
    public void openSession() throws Exception {

        dsContext = new FileSystemXmlApplicationContext(configStr);
        // sessionFactory = new Configuration().configure().buildSessionFactory();
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        //
        // sessionFactory = (SessionFactory) dsContext.getBean("sessionFactory");

        session = SessionFactoryUtils.getSession(sessionFactory, true);

        session.setFlushMode(FlushMode.MANUAL);

        TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(session));

    }

    @After
    public void closeSession() throws Exception {

        TransactionSynchronizationManager.unbindResource(sessionFactory);

        SessionFactoryUtils.releaseSession(session, sessionFactory);

    }
}
