package sendMail;
import java.text.SimpleDateFormat;

import data.Task;
import data.TaskDateTime;



import operation.Search;

import org.tiling.scheduling.Scheduler;
import org.tiling.scheduling.SchedulerTask;
import org.tiling.scheduling.iterators.DailyIterator;

import storagecontroller.StorageManager;

import java.io.*;
public class Agenda implements Runnable{
private final Scheduler scheduler=new Scheduler();
private final int hourOfDay,minute,second;

private String recepientEmail;
public Agenda(int hour,int min,int sec,String email)
{
	hourOfDay=hour;
	minute=min;
	second=sec;
	recepientEmail=email;
}
private TaskDateTime getDate(String result)
{
	System.out.println("The string is:" + result);
	int day=Integer.parseInt(result.substring(0, 2));
	String mon=result.substring(3,6);
	int month;
	int year=Integer.parseInt(result.substring(7,11));
	if(mon.matches("Jan"))
		month=1;
	else if(mon.matches("Feb"))
		month=2;
	else if(mon.matches("Mar"))
		month=3;
	else if(mon.matches("Apr"))
		month=4;
	else if(mon.matches("May"))
		month=5;
	else if(mon.matches("Jun"))
		month=6;
	else if(mon.matches("Jul"))
		month=7;
	else if(mon.matches("Aug"))
		month=8;
	else if(mon.matches("Sep"))
		month=9;
	else if(mon.matches("Oct"))
		month=10;
	else if(mon.matches("Nov"))
		month=11;
	else
		month=12;
	TaskDateTime date=new TaskDateTime(year,month,day);
	return date;
}
public void sendMail()
{
	System.out.println("In sendMail");
	String result=StorageManager.loadDate();
	TaskDateTime sentDate = getDate(result);
	System.out.println(" The date extracted  is " + sentDate.formattedToString());
	
	TaskDateTime default2=new TaskDateTime(2002,1,1);
	if(sentDate.compareTo(new TaskDateTime().getDate())==0)
	{
		System.out.println("Default");
		System.out.println(default2.getDate().formattedToString());
		StorageManager.saveDate(default2.getDate().formattedToString());
		start();
	}
	else
	{
	if(sentDate.compareTo(TaskDateTime.getCurrentDate())==-1)
	{
		StorageManager.saveDate(TaskDateTime.getCurrentDate().formattedToString());
		Send send=new Send();
		Search todaysTasks=new Search();
		Task urgentTasks[]=todaysTasks.searchTodaysTasks();
		String Message = "<html><body>Today's Agenda: </br><table border=\"1\" cellspacing=\"0\" cellpadding=\"0\"><tbody>";
		Message+="<tr bgcolor=\"#3399FF\"><td valign=\"top\" width=\"128\"><strong>Start Time</strong></td>";
		Message+="<td valign=\"top\" width=\"128\"><strong>End Time</strong></td><td valign=\"top\" width=\"128\"><strong>Task Details</strong></td>";
		Message+="<td valign=\"top\" width=\"128\"><strong>Labels</strong></td><td valign=\"top\" width=\"128\"><strong>Status</strong></td></tr>";
		for (int i =0; i<urgentTasks.length;i++){
		Message+="<tr>";
		if (urgentTasks[i].getStart()!=null){
			Message+="<td valign=\"top\" width=\"128\">"+urgentTasks[i].getStart().formattedToString()+"</td>";
		}
		else {
			Message+="<td valign=\"top\" width=\"128\"></td>";
		}
		if (urgentTasks[i].getEnd()!=null){
			Message+="<td valign=\"top\" width=\"128\">"+urgentTasks[i].getEnd().formattedToString()+"</td>";
		}
		else {
			Message+="<td valign=\"top\" width=\"128\"></td>";
		}
		Message+="<td valign=\"top\" width=\"128\">"+urgentTasks[i].getName()+"</td>";
		Message+="<td valign=\"top\" width=\"128\">"+urgentTasks[i].toStringLabels()+"</td>";
		Message+="<td valign=\"top\" width=\"128\">";
		if (urgentTasks[i].getImportant()){
			Message+="Important"+"</td>";
		}
		else{
			Message+="Normal"+"</td>";
		}
		Message+="</tr>";
		}
		Message+="</tbody></table></br></br>- This email is generated by an automated system. Do not reply. -</body></html>";

		System.out.println(send.sendMail(recepientEmail,"Today's Agenda",Message));
	}
	else if(sentDate.compareTo(TaskDateTime.getCurrentDate())==0)
	{
		StorageManager.saveDate(TaskDateTime.getCurrentDate().formattedToString());
	}
	}

}
public void start()
{
	scheduler.schedule(new SchedulerTask()
		{
			public void run()
			{
				sendMail();
			}
				}
				, new DailyIterator(hourOfDay,minute,second));
		}
			
	
public static void main(String[] args){
	
	//alarmClock.sendMail();
}
@Override
public void run() {
	// TODO Auto-generated method stub
	sendMail();
	
}

}
