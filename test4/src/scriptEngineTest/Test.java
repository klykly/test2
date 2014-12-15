package scriptEngineTest;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Test {

	public static void main(String args[]){
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("javascript");

		try {
			engine.eval("print('Hello, world!')");
			engine.eval("alert(1)");
		} catch (ScriptException ex) {
			ex.printStackTrace();
		}
	}
}

