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

	protected String output;
	
	public static void main(String args[]) {
		final JavaScriptLauncher launcher = new JavaScriptLauncher();
		launcher.run();
	}

	public void run() {
		final ScriptEngineManager manager = new ScriptEngineManager();
		final ScriptEngine engine = manager.getEngineByName("nashorn");
		final Invocable invocable=(Invocable)engine;

		try {
			final String template = new String(Files.readAllBytes(Paths
					.get("src/main/resources/template.mst")));
			System.out.println("Break 1");

			final String kontakt = new String(Files.readAllBytes(Paths
					.get("src/main/resources/kontakt.json")));
			System.out.println("Break 2");
			
			final Object json=engine.eval("JSON");
			System.out.println("Break 3");
			final Object data=invocable.invokeMethod(json,"parse",kontakt);
			System.out.println("Break 4");
			
			engine.eval(new FileReader("src/main/resources/mustache/mustache.js"));
			System.out.println("Break 5");
			final Object mustache=engine.eval("Mustache");
			System.out.println("Break 6");
			
			final Object output=invocable.invokeMethod(mustache,"render",template,data);
			System.out.println("Break 7");
			System.out.println(output);
			System.out.println("Break 8");
			
			this.output=(String) output;
			System.out.println("Break 9");
			
			
		} catch (IOException | NoSuchMethodException | ScriptException e) {
			e.printStackTrace();
		}
	}
	
	public String getOutput(){
		return output;
	}

}
