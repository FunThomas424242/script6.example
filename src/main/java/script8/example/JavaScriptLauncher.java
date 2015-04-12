package script8.example;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptLauncher implements Runnable {

	public static void main(String args[]) {
		final JavaScriptLauncher launcher = new JavaScriptLauncher();
		launcher.run();
	}

	public void run() {
		final ScriptEngineManager manager = new ScriptEngineManager();
		final ScriptEngine engine = manager.getEngineByName("nashorn");
		

		try {
			final String template = new String(Files.readAllBytes(Paths
					.get("src/main/resources/template.mst")));

			final String kontakt = new String(Files.readAllBytes(Paths
					.get("src/main/resources/kontakt.json")));
			
			final Object json=engine.eval("JSON");
			final Object data=((Invocable)engine).invokeMethod(json,"parse",kontakt);
			
			engine.eval(new FileReader("src/main/resources/mustache/mustache.min.js"));
			final Object mustache=engine.eval("Mustache");
			
			final Object output=((Invocable)engine).invokeMethod(mustache,"render",template,data);
			System.out.println(output);
			
			
		} catch (IOException | NoSuchMethodException | ScriptException e) {
			e.printStackTrace();
		}
	}

}
