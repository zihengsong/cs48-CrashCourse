package Test;

import ucsbCurriculum.*;

import ucsbCurriculum.CourseScraper.CourseScraper;
import ucsbCurriculum.Scheduler.Schedule;
import ucsbCurriculum.Utility.*;

// This is environment for command line testing
public class Test {
	public CourseScraper scraper;
	public Schedule scheduler;
	
	
	// do the command line interaction 
	public static void main(String[] args){
		CourseScraper scraper = new CourseScraper();
		Schedule scheduler = new Schedule();	
		
		System.out.println("This is a demo program for CrashCourse. This program grabs information from the UCSB Curriculum Search page and demos a few sample schedules.");
		
		
		scraper.getCourseListFor("CMPSC", "20172", "Undergraduate");
		Course cs8 = scraper.get_course_by_name("CMPSC 8 ");
		Course cs24 = scraper.get_course_by_name("CMPSC 24 ");
		Course cs130a = scraper.get_course_by_name("CMPSC 130A ");
		Course cs162 = scraper.get_course_by_name("CMPSC 162 ");
		scraper.getCourseListFor("MATH", "20172", "Undergraduate");
		System.out.println("Now getting information for Math Department courses.");
		Course math4a = scraper.get_course_by_name("MATH 4A ");
		Course math6a = scraper.get_course_by_name("MATH 6A ");
		Course math3a = scraper.get_course_by_name("MATH 3A ");
		
		System.out.println("Creating Schedule with CmpSc 8, CmpSc 24, Math 4A, and Math 6A:");
		scheduler.add(cs8);
		scheduler.add(cs24);
		scheduler.add(math4a);
		scheduler.add(math6a);
		
		System.out.println("Deleting conflicts from schedule.");
		scheduler.deleteConflicts();
		
		System.out.println("Printing Schedule: ");
		String answer = scheduler.toString();
		System.out.println(answer);
		
		System.out.println("Deleting classes from previous schedule: ");
		scheduler.clearSchedule();
		
		System.out.println("Creating Schedule with CmpSc 8, CmpSc 8, Math 4A, Math 6A:");
		scheduler.add(cs8);
		scheduler.add(cs8);
		scheduler.add(math4a);
		scheduler.add(math6a);
		
		System.out.println("Deleting conflicts from schedule.");
		scheduler.deleteConflicts();
		
		System.out.println("Printing Schedule: ");
		answer = scheduler.toString();
		System.out.println(answer);
		
		System.out.println("Deleting classes from previous schedule: ");
		scheduler.clearSchedule();
		
		System.out.println("Creating Schedule with CmpSc 130A, CmpSc 178, Math 4A, and Math 6A:");
		scheduler.add(cs130a);
		scheduler.add(cs162);
		scheduler.add(math4a);
		scheduler.add(math6a);
		
		System.out.println("Deleting conflicts from schedule.");
		scheduler.deleteConflicts();
		
		System.out.println("Printing Schedule: ");
		answer = scheduler.toString();
		System.out.println(answer);
		
		System.out.println("Deleting classes from previous schedule: ");
		scheduler.clearSchedule();
		
		System.out.println("Creating Schedule with CmpSc 130A, CmpSc 178, Math 6A, and Math 3A:");
		scheduler.add(cs130a);
		scheduler.add(cs162);
		scheduler.add(math6a);
		scheduler.add(math3a);
		
		System.out.println("Deleting conflicts from schedule.");
		scheduler.deleteConflicts();
		
		System.out.println("Printing Schedule: ");
		answer = scheduler.toString();
		System.out.println(answer);
		
		System.out.println("Deleting classes from previous schedule: ");
		scheduler.clearSchedule();
		
		
		
		
	}
}
