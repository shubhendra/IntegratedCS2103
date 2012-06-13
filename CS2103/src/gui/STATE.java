package gui;

import gui.mainWindow.MainJFrame;

import org.apache.log4j.Logger;

/**
 * to see what command user is currently using
 * different commands result in different action from GUI
 * @author Ramon
 *
 */
public enum STATE {
	
	
	ADD, DELETE, EDIT, SEARCH, COMPLETED, ARCHIVE
	, OVERDUE, NULL, LIST, UNDO, EXIT, HELP, REDO
	, IMPORTANT, LOGIN, LOGOUT, DELETEALL, COMPLETEDALL
	, CLEARARCHIVE, EXPORTARCHIVE;

	private static Logger logger=Logger.getLogger(STATE.class);
	
	private static STATE state = NULL;
	private static String command;
	
	public static void setState(STATE newState) {
		state = newState;
	}
	
	public static void resetState() {
		state = NULL;
	}
	
	public static STATE getState() {
		return state;
	}
	
	public static String getEndedString(boolean isOneTask) {
		if(isOneTask)
			switch(state){
			case ADD: return "is added.";
			case DELETEALL:
			case DELETE: return "is deleted.";
			case EDIT: return "is edited.";
			case COMPLETEDALL:
			case COMPLETED: return "is toggled completed.";
			case IMPORTANT: return "is toggled important.";
			case OVERDUE: return "is overdue.";
			default:
				logger.warn(state + " getEndedString");
			}
		else
			switch(state) {
			case COMPLETEDALL: return "are completed.";
			case DELETEALL: return "are deleted.";
			case OVERDUE: return "are overdue.";
			case IMPORTANT: return "are toggled important.";
			}
		return null;
	}
	
	public static STATE checkCommand(String curText) {
		if(curText.equals(""))
			return STATE.NULL;
		
		String delims = "[ ]+";
		String firstWord = curText.trim().split(delims)[0];
		command = firstWord;
		
		if(firstWord.equalsIgnoreCase("add") 
				|| firstWord.equalsIgnoreCase("insert"))
			return STATE.ADD;
		if(firstWord.equalsIgnoreCase("delete")
				|| firstWord.equalsIgnoreCase("remove"))
			return STATE.DELETE;
		if(firstWord.equalsIgnoreCase("modify")
				|| firstWord.equalsIgnoreCase("edit")
				|| firstWord.equalsIgnoreCase("update"))
			return STATE.EDIT;
		if(firstWord.equalsIgnoreCase("search")
				|| firstWord.equalsIgnoreCase("find"))
			return STATE.SEARCH;
		if(firstWord.equalsIgnoreCase("completed")
				|| firstWord.equalsIgnoreCase("done"))
			return STATE.COMPLETED;
		if(firstWord.equalsIgnoreCase("archive"))
			return STATE.ARCHIVE;
		if(firstWord.equalsIgnoreCase("overdue"))
			return STATE.OVERDUE;
		if(firstWord.equalsIgnoreCase("list"))
			return STATE.LIST;
		if(firstWord.equalsIgnoreCase("undo"))
			return STATE.UNDO;
		if(firstWord.equalsIgnoreCase("exit"))
			return STATE.EXIT;
		if(firstWord.equalsIgnoreCase("help"))
			return STATE.HELP;
		if(firstWord.equalsIgnoreCase("redo"))
			return STATE.REDO;
		if(firstWord.equalsIgnoreCase("important"))
			return STATE.IMPORTANT;
		if(firstWord.equalsIgnoreCase("login"))
			return STATE.LOGIN;
		if(firstWord.equalsIgnoreCase("delete.all"))
			return STATE.DELETEALL;
		if(firstWord.equalsIgnoreCase("completed.all"))
			return STATE.COMPLETEDALL;
		if(firstWord.equalsIgnoreCase("archive"))
			return STATE.ARCHIVE;
		if(firstWord.equalsIgnoreCase("cleararchive"))
			return STATE.CLEARARCHIVE;
		if(firstWord.equalsIgnoreCase("exportarchive"))
			return STATE.EXPORTARCHIVE;
		
		command = "";
		return STATE.NULL;
	} 

	public static String getCommand() {
		return command;
	}
}