package cn.mr.hibernate;

import org.junit.Before;
import org.junit.Test;

public class TestCase1 extends AbstractBaseTestCase {

    private Organization org;

    @Before
    public void prepare() {
        org = (Organization) dsContext.getBean("Organization");
    }

    @Test
    public void test1() {
        System.out.println();
    }
}