package ucsbCurriculum.Scheduler;

import java.util.ArrayList;

import ucsbCurriculum.Utility.*;

// ArrayList of lectures
// ArrayList of (ArrayList of sections) 
public class Schedule {
    // just write out the structure, change the variable name if you want
    private ArrayList<Course> courses;
    private ArrayList<ArrayList<Time>> sections;
    
    // if c result in a collision, return false(or throw a exceptation)
    //returns false if course c already exists in array list of lectures
    //returns false if course c has lecture times that overlap with previous courses' lecture times
    public boolean add(Course c){
    	for(int i = 0; i < courses.size(); i++){
    		if(courses.get(i)==c){
    			return false;
    		}
    		if((courses.get(i)).compareTo(c)==false){
    			return false;
    		}
    	}
    	courses.add(c);
    	sections.add(c.get_sectionTimes());
    	return true;
    }
    
    //removes course c's information from lecture times and section times array lists
    public void delete(Course c){
    	int i = courses.indexOf(c);
    	courses.remove(i);
    	sections.remove(i);
    	System.out.println(c.get_name() + "is being deleted.");
    	//user should be given some kind of warning - course being deleted because of time conflict/or personal choice
    }
    
    //goes through array list of sections and deletes all section times that have conflicts with other times
    //courses that were added first have higher priority
    //if a course has zero available section times left after comparison, it will be deleted from the list
    public void deleteConflicts(){
    	//first check all sections against conflicting lecture times
    	for(int i = 0; i < sections.size(); i++){
    		for(int j = 0; j < courses.size(); j++){
    			boolean sectionToLectureConflict = Util.compare((courses.get(j)).get_lectureTimes(), sections.get(i));
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
    			while(sectionToSectionConflict == true){
    				sectionToSectionConflict = (Util.compare(sections.get(j), currentSection));
    				if (sectionToSectionConflict == false){
    					//no available section times due to conflict; remove course c
    					delete(courses.get(i));
    					}
    				}
    			}
    		}
    	}
    
    
    
    // toString()
    
    
	public static void main (String[] args){
		Course test1 = new Course("Physics 1", "Buchanan", "TBA");
		Course test2 = new Course("Physics 2", "Buchanan", "TBA");
		Course test3 = new Course("Physics 2", "Buchanan", "TBA");
		
	}
    
}
