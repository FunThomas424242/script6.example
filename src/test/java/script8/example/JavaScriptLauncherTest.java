package script8.example;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class JavaScriptLauncherTest {
	
	protected JavaScriptLauncher launcher;
	
	@BeforeClass
	public void prepare(){
		launcher=new JavaScriptLauncher();
	}

	@Test
	public void testRun() {
		launcher.run();
	}

}
