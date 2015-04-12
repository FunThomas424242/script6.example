package script8.example;

import static org.junit.Assert.*;

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
		final String output = launcher.getOutput();
		assertTrue(output.contains( "* ZuHause: +49 333 555333"));
	}

}
