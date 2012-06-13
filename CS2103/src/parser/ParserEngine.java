package parser;


public class ParserEngine {
	
	public static void main (String args[]) {
		
	
	
		/*
		System.out.print("Input string:");
		try {
			inputString = reader.readLine();
		}
		catch(IOException ioe) {
			System.out.println("An unexpected error occured for your input");
		}
		*/
		Parser parserObject = new Parser();
		final String ID_REGEX = "(\\$\\$__)(\\d{2}-\\d{2}-\\d+[A-Z])(__\\$\\$)";
		
		System.out.println("<CMPT:true><IMPT:true><DEAD:true><RECUR:yearly><RECURID:$$__21-06-2012030000B__$$><LABEL:>".matches("<CMPT:(true|false)><IMPT:(true|false)><DEAD:(true|false)><RECUR:(daily|weekly|monthly|yearly)?><RECURID:("+ID_REGEX+")?><LABEL:((\\w+ )+)?>"));
		
		String arr[] = parserObject.fetchGCalDes("<CMPT:true><IMPT:false><DEAD:true><RECUR:><RECURID:><LABEL:>");
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i]);
		//parserObject.parseForSearch("14 june @work");
		/*
		ArrayList<Task> tArr = new ArrayList<Task>();
		//Task tempTask = null;
		for (int i=0; i<10; i++) {
			//tempTask = new Task("dfgds this is no."+i+" haha","",null,null,null,null,false,false);
			tArr.add(new Task("dfgds this is no."+i+" haha","",null,null,null,null,false,false));
		}
		
		for (int j=0; j<10; j++) {
			System.out.println("the current list element's details: "+tArr.get(j).getName());
		}
		*/
		/*
		System.out.print("Input string2:");
		try {
			inputString = reader.readLine();
		}
		catch(IOException ioe) {
			System.out.println("An unexpected error occured for your input");
		}
		*/
		
		//final String DONT_PARSE = "(\'(\\w+\\s?)*\')";
		//System.out.print("\'tme adsfdas adasdas\': "+"\'tme adsfdas adasdas\'".matches(DONT_PARSE));
		//Parser parserObject = new Parser();
		//parserObject.parseForAdd("meeting by 4pm @work @play");
		//parserObject.parseForSearch("by sat");
		
		/*
		AtomicReference<String> inputRef = new AtomicReference(inputString);
		mutateString(inputRef);
		System.out.println("the reference now holds: "+inputRef.toString());
		System.out.println("inputString: "+inputString);
		*/
		
	}
	/*
	System.out.println("1st march 2012".matches(GENERAL_DATE_PATTERN));
	System.out.println("1nd march 2012".matches(GENERAL_DATE_PATTERN));
	System.out.println("2nd march 2012".matches(GENERAL_DATE_PATTERN));
	System.out.println("4th march 2012".matches(GENERAL_DATE_PATTERN));
	System.out.println("9st march 2012".matches(GENERAL_DATE_PATTERN));
	System.out.println("9th march 2012".matches(GENERAL_DATE_PATTERN));
	System.out.println("3RD march 2012".matches(GENERAL_DATE_PATTERN));
	System.out.println("1 march 2012".matches(GENERAL_DATE_PATTERN));
	System.out.println("11th march: "+"11th march".matches(GENERAL_DATE_PATTERN));
	System.out.println("19th DEC: "+"19th DEC".matches(GENERAL_DATE_PATTERN));
	System.out.println("20th march 2012: "+"20th march 2012".matches(GENERAL_DATE_PATTERN));
	System.out.println("20st march 2012: "+"20st march 2012".matches(GENERAL_DATE_PATTERN));
	System.out.println("21st march 2012: "+"21st march 2012".matches(GENERAL_DATE_PATTERN));
	System.out.println("22nd march 2012: "+"22nd march 2012".matches(GENERAL_DATE_PATTERN));
	System.out.println("23rd march 2012: "+"23rd march 2012".matches(GENERAL_DATE_PATTERN));
	System.out.println("24th march 2012: "+"24th march 2012".matches(GENERAL_DATE_PATTERN));
	System.out.println("34th march 2012: "+"34th march 2012".matches(GENERAL_DATE_PATTERN));
	System.out.println("31th march 2012: "+"31th march 2012".matches(GENERAL_DATE_PATTERN));
	System.out.println("31st march 2012: "+"31st march 2012".matches(GENERAL_DATE_PATTERN));
	System.out.println("30th march 2012: "+"30th march 2012".matches(GENERAL_DATE_PATTERN));
	System.out.println("30 march 2012: "+"30 march 2012".matches(GENERAL_DATE_PATTERN));
	System.out.println("30/march/2012: "+"30/march/2012".matches(GENERAL_DATE_PATTERN));
	System.out.println("30th-march-2012: "+"30th-march-2012".matches(GENERAL_DATE_PATTERN));
	System.out.println("on monday: "+"on monday".matches(GENERAL_DATE_PATTERN));
	System.out.println("on next monday: "+"on next monday".matches(GENERAL_DATE_PATTERN));
	System.out.println("next monday: "+"next monday".matches(GENERAL_DATE_PATTERN));
	System.out.println("next SUN: "+"next SUN".matches(GENERAL_DATE_PATTERN));
	System.out.println("SUN: "+"SUN".matches(GENERAL_DATE_PATTERN));
	*/
	

}
