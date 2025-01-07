package pkg;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

public class VelocityMainExapmle {

	public static void main(String[] args) {
		main1();
		main2();
	}

	public static void main1() {
		Properties p = new Properties();
		p.setProperty("file.resource.loader.path", "templates");
		Velocity.init(p);

		Template template = Velocity.getTemplate("dir1/VelocityMainExapmle.vm");

		Map<String, String> map = new HashMap<>();
		map.put("key", "value");

		VelocityContext context = new VelocityContext(map);

		StringWriter sw = new StringWriter();
		template.merge(context, sw);
		System.out.println(sw);
	}

	public static void main2() {
		VelocityEngine ve = new VelocityEngine();
		ve.addProperty("file.resource.loader.path", "templates");

		Template template = ve.getTemplate("dir1/VelocityMainExapmle.vm");

		VelocityContext context = new VelocityContext();
		context.put("key", "value");

		StringWriter sw = new StringWriter();
		template.merge(context, sw);
		System.out.println(sw);
	}

}
