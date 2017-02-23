package ucsbCurriculum.Scheduler;

import java.util.ArrayList;

import ucsbCurriculum.Utility.*;

// ArrayList of lectures
// ArrayList of (ArrayList of sections) 
public class Schedule {
    // just write out the structure, change the variable name if you want
    private ArrayList<Course> courses = new ArrayList<Course>();
    private ArrayList<ArrayList<Time>> sections = new ArrayList<ArrayList<Time>>();
    
    
    public static boolean compare(ArrayList<Time> time1, ArrayList<Time> time2){
		int len1 = time1.size();
		int len2 = time2.size();
		
		for(int i = 0; i < len1; i++){
			for(int j = 0; j < len2; j++){
				if(Util.have_conflict(time1.get(i), time2.get(j))){
					// TO-DO: delete that element in the second list
					time2.remove(j);
				}
			}
		}
		if(time2.size()==0)
			return false;
		else
			return true;
	}
    
    
    
    // if c result in conflicts, then just print a message and return
    
    public void add(Course c){
    		ArrayList<Time> sectionTime = c.get_sectionTimes();
	    	for(int i = 0; i < courses.size(); i++){
	    		Course temp = courses.get(i);
	    		if(temp == c){
	    			
	    			// Only for command line version!!!
	    			System.out.println("Course already added!!!");
	    			
	    			return;
	    		}
	    		if(!Course.compare(temp, c) || !compare(sections.get(i), sectionTime) || !compare(temp.get_lectureTimes(), sectionTime)){
	    			
	    			// Only for command line version!!!
	    			System.out.println("Conflicts detected! This course cannot be add to schedule!");
	    			
	    			return;
	    		}
	    	}
	    	courses.add(c);
        	sections.add(sectionTime);
    }
    
    @Override
    // only for command line version
    public String toString(){
    		String res = "Current Schedule:\n";
    		
    		for(int i = 0; i < courses.size(); i++)
    		{
    			Course c = courses.get(i);
    			res += "\t " + c.get_name();
    			ArrayList<Time> times = c.get_lectureTimes();
    			for(int j = 0; j < times.size(); j++)
    			{
    				res += "";
    			}
    		}
    		
    		return res;
    }
    
    
 
    
    
    //removes course c's information from lecture times and section times array lists
    public void delete(Course c){
    	int i = courses.indexOf(c);
    	courses.remove(i);
    	sections.remove(i);
    	System.out.println(c.get_name() + " is being deleted.");
    	//user should be given some kind of warning - course being deleted because of time conflict/or personal choice
    }
    
    //goes through array list of sections and deletes all section times that have conflicts with other times
    //courses that were added first have higher priority
    //if a course has zero available section times left after comparison, it will be deleted from the list
    public void deleteConflicts(){
    	//first check all sections against conflicting lecture times
    	for(int i = 0; i < sections.size(); i++){
    		boolean sectionToLectureConflict = true;
    		for(int j = 0; j < courses.size(); j++){
    			sectionToLectureConflict = compare((courses.get(j)).get_lectureTimes(), sections.get(i));
    			if(sectionToLectureConflict == false){
    				//false will be returned if all section times for a lecture have been removed due to conflict
    				delete(courses.get(i));
    			}
    		}
    	}
    	//now check all sections against previous sections
    	//start at 1 because course at position 0 has priority
    	for(int i = 1; i < sections.size(); i++){
    		ArrayList<Time> currentSection = sections.get(i);
    		//now compare current section list with all previous section lists
    		boolean sectionToSectionConflict = true;
    		for(int j = i-1; j >= 0; j--){
    				sectionToSectionConflict = (compare(sections.get(j), currentSection));
    				if (sectionToSectionConflict == false){
    					//no available section times due to conflict; remove course c
    					delete(courses.get(i));
    					}
    				}
    		}
    	}
    
    
   
    
    
    
}
