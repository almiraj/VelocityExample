package pkg;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class Main {

	public static void main(String[] args) {
		System.out.println(merge());
	}

	public static String merge() {
		// initialize
		Properties p = new Properties();
		p.setProperty("file.resource.loader.path", "templates");
		Velocity.init(p);

		// prepare
		Template template = Velocity.getTemplate("dir1/main.vm");
		VelocityContext context = new VelocityContext();

		// set context
		List<String> list = Arrays.asList("a", "b", "c");
		context.put("list", list);

		List<Obj> objList = new ArrayList<>();
		Obj obj1 = new Obj();
		obj1.field1 = "value_1_1";
		obj1.field2 = "value_1_2";
		objList.add(obj1);
		Obj obj2 = new Obj();
		obj2.field1 = "value_2_1";
		obj2.field2 = "value_2_2";
		objList.add(obj2);
		context.put("objList", objList);

		context.put("subValue", "This is sub.");

		// merge
		StringWriter sw = new StringWriter();
		template.merge(context, sw);
		return sw.toString();
	}

}
