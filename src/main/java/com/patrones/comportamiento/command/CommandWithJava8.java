package com.patrones.comportamiento.command;

import java.util.ArrayList;
import java.util.List;

public class CommandWithJava8 {

	public static void main(String...s) {
		final Editor editor = new MockEditor();
		Macro macro = new Macro();
		
		macro.record(editor::open);
		macro.record(editor::save);
		macro.record(editor::close);
		macro.run();
	}
}

interface Editor {
    public void save();
    public void open();
    public void close();
}

final class MockEditor implements Editor {

	private final List<String> actions = new ArrayList<>();

	@Override
	public void close() {
		this.actions.add("close");
	}

	@Override
	public void open() {
		this.actions.add("open");
	}

	@Override
	public void save() {
		this.actions.add("save");
	}

}

@FunctionalInterface
interface Action {
	public void perform();
}

class Save implements Action {
	private final Editor editor;
	
	public Save(Editor editor) {
		this.editor = editor;
	}

	@Override
	public void perform() {
		editor.save();
	}
}

class Macro {
    private final List<Action> actions;
 
    public Macro() {
        actions = new ArrayList<>();
    }
 
    public void record(Action action) {
        actions.add(action);
    }
 
    public void run() {
        actions.forEach(Action::perform);
    }
}