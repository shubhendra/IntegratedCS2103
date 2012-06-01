package data;

import java.util.Comparator;
public class compareByDate implements Comparator<Task>{

	@Override
	public int compare(Task o1, Task o2) {
		// TODO Auto-generated method stub
				
		if (o1.getStartDateTime()!=null && o2.getStartDateTime()!=null)
		{
			long diff = o1.getStartDateTime().getTimeMilli() - o2.getStartDateTime().getTimeMilli();
		
			if(diff < 0)
				return -1;
			else if(diff == 0)
				return 0;
			else
				return 1;
		
			
		}
		else if (o1.getStartDateTime()==null && o2.getStartDateTime()!=null)
		{
			if (o1.getEndDateTime()!=null)
			{
				long diff = o1.getEndDateTime().getTimeMilli() - o2.getStartDateTime().getTimeMilli();
			
				if(diff < 0)
					return -1;
				else if(diff == 0)
					return 0;
				else
					return 1;
			}
			else 
				return -1;
		}
		else if (o1.getStartDateTime()!=null && o2.getStartDateTime()==null)
		{
			if (o2.getEndDateTime()!=null)
			{
				long diff = o1.getStartDateTime().getTimeMilli() - o2.getEndDateTime().getTimeMilli();
			
				if(diff < 0)
					return -1;
				else if(diff == 0)
					return 0;
				else
					return 1;
			}
				else 
					return -1;
		}
		else
		{
			return -1;
		}

	}
	
}
