package spring.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

public class LiuClassXMLApplication {
	private  List<Beandefine> beandis = new ArrayList<Beandefine>();
	private Map<String,Object> sigleton =  new HashMap<String,Object>();
	public LiuClassXMLApplication(String fileName){
		this.readXML(fileName);
		
			instaceBean();
		
	}
	private void instaceBean() {
		for(Beandefine b:beandis){
			if(b.getClazz()!=null&&!"".equals(b.getClazz())){
			try {
				/*sigleton.put(b.getId(), Class.forName(b.getClazz()).newInstance());*/
				sigleton.put(b.getId(), b.getClazz()).getClass();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	}
	
	private void readXML(String fileName){
		SAXReader saxReader = new SAXReader();
		org.dom4j.Document document = null;
		URL xmlpath = this.getClass().getClassLoader().getResource(fileName);
		try {
			document =saxReader.read(xmlpath);
			Map<String,Object> nasMap=new HashMap<String,Object>();
			nasMap.put("ns","http://www.springframework.org/schema/beans");
			XPath xsub=document.createXPath("//ns:beans/ns:bean");
			xsub.setNamespaceURIs(nasMap);
			List<Element> beans=xsub.selectNodes(document); 
			for(Element element:beans){
				String id=element.attributeValue("id");
				String clazz=element.attributeValue("class");
				Beandefine beandine = new Beandefine(id, clazz);
				beandis.add(beandine);
				
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Object getBean(String id){
		return sigleton.get(id);
	}

}
