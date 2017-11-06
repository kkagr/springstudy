package springTest;



import org.junit.Test;

import spring.controller.LiuClassXMLApplication;
import spring.person.service.personService;
import spring.person.service.impl.personServiceImpl;

public class test {

	@SuppressWarnings("resource")
	@Test
	public void test() throws ClassNotFoundException{
		/*ApplicationContext ap = new ClassPathXmlApplicationContext("beans.xml");*/
		LiuClassXMLApplication ap=new LiuClassXMLApplication("beans.xml");
		personService personService1=(personService) ap.getBean("personService");
		personServiceImpl a= new personServiceImpl();
		/*a.save();*/
		personService1.save();
	}
	}