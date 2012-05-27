package logic;

//import java.io.FileNotFoundException;
import java.util.Stack;

import operation.*;
//import org.apache.log4j.Logger;
import data.Task;
//import org.apache.log4j.Level;


import storagecontroller.StorageManager;

public class JIDLogic {
	
		
		public static void main(String[] args) {
	        //logger.info("hi");
	    	Add adder=new Add();
	    	
	    	Task[] abc=adder.execute("add *go to meet bhairav weekly by 3.45pm 3/8/2012  @work @home");
	    	if (abc[0]!=null)
	    	System.out.println(abc[0].getName());
		
	}
	private Stack<Operation> undoStack;
	
	private String command;
	//private Logger logger = Logger.getLogger(JIDLogic.class.getName());
	/**
	 * controller constructor. Builds the controller object
	 */
	public JIDLogic() {
		//ui = new UiController();
		StorageManager.loadFile();
		
		undoStack = new Stack<Operation>();
	}
	public Task[] executeCommand (String commandFromUser) {
		Operation op = null;
		if (command == null || command.equals("")) {
			return null;
		} else if (command.trim().equals("exit")) {
			exit();
			return null;
		} else if (commandFromUser.trim().equals("undo") && !undoStack.empty()) {
			Operation undoAction = undoStack.pop();
			return undoAction.undo();
			
		} else {
			op = Operation.getOperationObj(commandFromUser);
			if (op.isUndoAble()) {
				undoStack.push(op);
			}
			
			return  op.execute(commandFromUser);
			
			
		}
		
		}
		
	

	/**
	 * Sets the view to the specified value
	 * 
	 * @param view
	 */
	
	/**
	 * Sets the command to the command specified
	 * 
	 * @param command
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * executes the command and starts the chain of events
	 */
	public void run() {
	}

	/**
	 * exits the code and closes the UI window
	 */
	public void exit() {
	
	}

	/**
	 * 
	 * @return command entered
	 */
	public String getCommand() {
		return command;
	}
}


