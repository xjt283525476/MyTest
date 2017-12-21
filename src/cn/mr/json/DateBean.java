package cn.mr.json;

import java.io.Serializable;
import java.util.Date;

/**
 * 带日期属性的JavaBean类
 * @author xuejiangtao
 * 2012-8-23 上午11:21:51
 */
public class DateBean implements Serializable {
	private static final long serialVersionUID = -2071405788146467301L;
	
	private String id;
	private String name;
	private int age;
	private Date birth;
	
	public DateBean() {
		super();
	}
	
	public DateBean(String id, String name, int age, Date birth) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.birth = birth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "DateBean [age=" + age + ", birth=" + birth + ", id=" + id
				+ ", name=" + name + "]";
	}
	
}
