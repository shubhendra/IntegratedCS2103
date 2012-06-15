/**
 * 
 */
package operation;

import constant.OperationFeedback;
import data.Task;

/**
 * @author Shubhendra Agrawal
 *
 */
public class Upcoming extends Operation {

	/**
	 * 
	 */
	@Override
	public Task[] execute(String userCommand) {
		// TODO Auto-generated method stub
		
		return null;
	}

	/* (non-Javadoc)
	 * @see operation.Operation#undo()
	 */
	@Override
	public Task[] undo() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see operation.Operation#redo()
	 */
	@Override
	public Task[] redo() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see operation.Operation#isUndoAble()
	 */
	@Override
	public boolean isUndoAble() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see operation.Operation#getOpFeedback()
	 */
	@Override
	public OperationFeedback getOpFeedback() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see operation.Operation#getOperationName()
	 */
	@Override
	public String getOperationName() {
		// TODO Auto-generated method stub
		return null;
	}

}
