package script8.example;

import org.junit.Before;
import org.junit.Test;

public class JavaScriptLauncherTest {
	
	protected JavaScriptLauncher launcher;
	
	@Before
	public  void prepare(){
		launcher=new JavaScriptLauncher();
	}

	@Test
	public void testRun() {
		launcher.run();
	}

}
