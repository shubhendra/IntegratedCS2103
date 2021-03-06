/**
 * extends Operation
 * 
 * This class is used to check whether a given time slot if free or not
 * 
 * @author Shubhendra Agrawal
 */
package operation;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import parser.Parser;
import constant.OperationFeedback;
import data.Task;
import data.TaskDateTime;


public class CheckFree extends Operation{
	
	private static Logger logger = Logger.getLogger(CheckFree.class);
	private String commandName;

	
	/**
	 * Constructor 
	 */
	public CheckFree (){
		commandName = "check.free";
	}
	
	/**
	 * Constructor
	 * @param userInput
	 */
	public CheckFree(String userInput){
		commandName = userInput;
	}
	
	@Override
	/**
	 * implements whether a given slot is free or not
	 * 
	 * @param userCommand
	 * @return the tasks that class in the given schedule,
	 * 			null if no tasks clash and te given slot os free
	 */
	public Task[] execute(String userCommand) {
		// TODO Auto-generated method stub
		userCommand.toLowerCase().trim().replaceFirst("check.free ", "");
		
		Search SearchObj = new Search();
	
		Task parsedTask=parseCommand(userCommand);
		if (parsedTask.getStart() == null || parsedTask.getEnd() == null){
			feedback = OperationFeedback.TASK_SPECIFIED_DOES_NOT_HAVE_BOTH_START_END_DATE_TIME;
			return null;
		}
		Task[] allSortedTasks = SearchObj.returnAllTasks();
		ArrayList<Task> betweenTasks = new ArrayList<Task>();
		for(int i = 0 ; i < allSortedTasks.length ; i++){
			if(isNotFree(parsedTask, allSortedTasks[i])){
				betweenTasks.add(allSortedTasks[i]);
			}
		}
		
		
		if (betweenTasks.size() == 0) {
			return null;
		} else {
			feedback = OperationFeedback.NOT_FREE;
			logger.debug("these many tasks clashing:"+betweenTasks.size());
			return (Task[]) betweenTasks.toArray(new Task[betweenTasks.size()]);
		}
	}

	/**
	 * 
	 * @param taskToSearch
	 * @param existingTask
	 * @return true if the task clashes with any task in the given period including the 
	 * 			boundary values
	 */
	private static boolean isNotFree(Task taskToSearch, Task existingTask) {
		TaskDateTime defaultTime = new TaskDateTime();
		if (taskToSearch.getStart() != null && taskToSearch.getEnd() != null){
			if (taskToSearch.getStart().getDate().getTimeMilli() != defaultTime.getDate().getTimeMilli() &&
					taskToSearch.getEnd().getDate().getTimeMilli() != defaultTime.getDate().getTimeMilli() &&
					taskToSearch.getStart().getTime().getTimeMilli() != defaultTime.getTime().getTimeMilli() &&
					taskToSearch.getEnd().getTime().getTimeMilli() != defaultTime.getTime().getTimeMilli()){
				
				if (existingTask.getStart() != null && existingTask.getEnd() != null){
					if((taskToSearch.getStart().getTimeMilli() <= existingTask.getStart().getTimeMilli() && 
							taskToSearch.getEnd().getTimeMilli() >= existingTask.getEnd().getTimeMilli()) ||
							(taskToSearch.getStart().getTimeMilli() >= existingTask.getStart().getTimeMilli() && 
							taskToSearch.getEnd().getTimeMilli() <= existingTask.getEnd().getTimeMilli()) ||
							(taskToSearch.getStart().getTimeMilli() >= existingTask.getStart().getTimeMilli() &&
							taskToSearch.getStart().getTimeMilli() <= existingTask.getEnd().getTimeMilli() &&
							taskToSearch.getEnd().getTimeMilli() >= existingTask.getEnd().getTimeMilli()) ||
							(taskToSearch.getStart().getTimeMilli() <= existingTask.getStart().getTimeMilli() &&
							taskToSearch.getEnd().getTimeMilli() >= existingTask.getStart().getTimeMilli() &&
							taskToSearch.getEnd().getTimeMilli() <= existingTask.getEnd().getTimeMilli())){
		
						return true;
					} else {
						return false;
					}
				} else if (existingTask.getStart() == null && existingTask.getEnd()!=null){
					if(taskToSearch.getEnd().getTimeMilli() >= existingTask.getEnd().getTimeMilli() &&
							taskToSearch.getStart().getTimeMilli() <= existingTask.getEnd().getTimeMilli()){
		
						return true;
					} else {
						return false;
					}
				} else if (existingTask.getStart() != null && existingTask.getEnd() == null){
					if(taskToSearch.getStart().getTimeMilli() <= existingTask.getStart().getTimeMilli() &&
							taskToSearch.getEnd().getTimeMilli() >= existingTask.getStart().getTimeMilli()){
		
						return true;
					} else {
						return false;
					}
				} else { 
					return false;
				}
			} else if (taskToSearch.getStart().getDate().getTimeMilli() == defaultTime.getDate().getTimeMilli() &&
					taskToSearch.getEnd().getDate().getTimeMilli() == defaultTime.getDate().getTimeMilli() &&
					taskToSearch.getStart().getTime().getTimeMilli() != defaultTime.getTime().getTimeMilli() &&
					taskToSearch.getEnd().getTime().getTimeMilli() != defaultTime.getTime().getTimeMilli()){
				
				if (existingTask.getStart() != null && existingTask.getEnd() != null){
					if((taskToSearch.getStart().getTime().getTimeMilli() <= existingTask.getStart().getTime().getTimeMilli() && 
							taskToSearch.getEnd().getTime().getTimeMilli() >= existingTask.getEnd().getTime().getTimeMilli()) ||
							(taskToSearch.getStart().getTime().getTimeMilli() >= existingTask.getStart().getTime().getTimeMilli() && 
							taskToSearch.getEnd().getTime().getTimeMilli() <= existingTask.getEnd().getTime().getTimeMilli()) ||
							(taskToSearch.getStart().getTime().getTimeMilli() >= existingTask.getStart().getTime().getTimeMilli() &&
							taskToSearch.getStart().getTime().getTimeMilli() <= existingTask.getEnd().getTime().getTimeMilli() &&
							taskToSearch.getEnd().getTime().getTimeMilli() >= existingTask.getEnd().getTime().getTimeMilli()) ||
							(taskToSearch.getStart().getTime().getTimeMilli() <= existingTask.getStart().getTime().getTimeMilli() &&
							taskToSearch.getEnd().getTime().getTimeMilli() >= existingTask.getStart().getTime().getTimeMilli() &&
							taskToSearch.getEnd().getTime().getTimeMilli() <= existingTask.getEnd().getTime().getTimeMilli())){
		
						return true;
					} else {
						return false;
					}
				} else if (existingTask.getStart() == null && existingTask.getEnd() != null){
					if(taskToSearch.getEnd().getTime().getTimeMilli() >= existingTask.getEnd().getTime().getTimeMilli() &&
							taskToSearch.getStart().getTime().getTimeMilli() <= existingTask.getEnd().getTime().getTimeMilli()){
		
						return true;
					} else {
						return false;
					}
				} else if (existingTask.getStart() != null && existingTask.getEnd() == null){
					if(taskToSearch.getStart().getTime().getTimeMilli() <= existingTask.getStart().getTime().getTimeMilli() &&
							taskToSearch.getEnd().getTime().getTimeMilli() >= existingTask.getStart().getTime().getTimeMilli()){
		
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else if (taskToSearch.getStart().getDate().getTimeMilli() != defaultTime.getDate().getTimeMilli() &&
					taskToSearch.getEnd().getDate().getTimeMilli() != defaultTime.getDate().getTimeMilli() &&
					taskToSearch.getStart().getTime().getTimeMilli() == defaultTime.getTime().getTimeMilli() &&
					taskToSearch.getEnd().getTime().getTimeMilli() == defaultTime.getTime().getTimeMilli()){
				
				if (existingTask.getStart() != null && existingTask.getEnd() != null){
					if((taskToSearch.getStart().getDate().getTimeMilli() <= existingTask.getStart().getDate().getTimeMilli() && 
							taskToSearch.getEnd().getDate().getTimeMilli() >= existingTask.getEnd().getDate().getTimeMilli()) || 
							(taskToSearch.getStart().getDate().getTimeMilli() >= existingTask.getStart().getDate().getTimeMilli() && 
							taskToSearch.getEnd().getDate().getTimeMilli() <= existingTask.getEnd().getDate().getTimeMilli()) ||
							(taskToSearch.getStart().getDate().getTimeMilli() >= existingTask.getStart().getDate().getTimeMilli() && 
							taskToSearch.getStart().getDate().getTimeMilli() <= existingTask.getEnd().getDate().getTimeMilli() &&
							taskToSearch.getEnd().getDate().getTimeMilli() >= existingTask.getEnd().getDate().getTimeMilli()) ||
							(taskToSearch.getStart().getDate().getTimeMilli() <= existingTask.getStart().getDate().getTimeMilli() && 
							taskToSearch.getEnd().getDate().getTimeMilli() >= existingTask.getStart().getDate().getTimeMilli() &&
							taskToSearch.getEnd().getDate().getTimeMilli() <= existingTask.getEnd().getDate().getTimeMilli())){
		
						return true;
					} else {
						return false;
					}
				} else if (existingTask.getStart() == null && existingTask.getEnd() != null){
					if(taskToSearch.getEnd().getDate().getTimeMilli() >= existingTask.getEnd().getDate().getTimeMilli() &&
							taskToSearch.getStart().getDate().getTimeMilli() <= existingTask.getEnd().getDate().getTimeMilli()){
		
						return true;
					} else {
						return false;
					}
					
				} else if (existingTask.getStart() != null && existingTask.getEnd() == null){
					if(taskToSearch.getStart().getDate().getTimeMilli() <= existingTask.getStart().getDate().getTimeMilli() &&
							taskToSearch.getEnd().getDate().getTimeMilli()  >=  existingTask.getStart().getDate().getTimeMilli()){
		
						return true;
					}
					else {
						return false;
					}
				} else 
					return false;
			}
			
			
		}
		return false;
	
		
		
	}
	/**
	 * parses the user Command into a task
	 * 
	 * @param userCommand
	 * @return Task that was parsed on the basis of userCommand
	 */
	private Task parseCommand(String userCommand) {
		// TODO Auto-generated method stub
		Parser newParser=new Parser();
		Task newTask=newParser.parseForSearch(userCommand);
		return newTask;
	}
	
	@Override
	/**
	 * undo is irrelevant here
	 */
	public Task[] undo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
	 * redo is irrelevant here
	 */
	public Task[] redo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
	 * @return whether this functionality is undo able or not
	 */
	public boolean isUndoAble() {
		// TODO Auto-generated method stub
		return isUndoAble;
	}

	@Override
	/**
	 * @return the operation feedback
	 */
	public OperationFeedback getOpFeedback() {
		// TODO Auto-generated method stub
		return feedback;
	}

	@Override
	/**
	 * @return the name of this operation
	 */
	public String getOperationName() {
		// TODO Auto-generated method stub
		return commandName;
	}

}
