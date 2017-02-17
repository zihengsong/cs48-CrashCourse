package ucsbCurriculum.Utility;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

import ucsbCurriculum.Utility.Time;
import ucsbCurriculum.Utility.Util;

public class Course {
	private String name;
	private String location;
	private String instructor;
	
	//String description;  description of the course, save for later
	
	private ArrayList<Time> lectureTimes;
	private ArrayList<Time> sectionTimes;
	
	public String get_name(){
		return name;
	}
	
	public String get_location(){
		return location;
	}
	
	public String get_instructor(){
		return instructor;
	}
	
	public ArrayList<Time> get_sectionTimes(){
		return sectionTimes;
	}
	
	public ArrayList<Time> get_lectureTimes(){
		return lectureTimes;
	}
	
	// Compare all the lecture times. Return true if they have conflicts
	public boolean compareTo(Course c){
		ArrayList<Time> t= c.get_lectureTimes();
		int len1 = this.lectureTimes.size();
		int len2 = t.size();
		for(int i = 0; i < len1; i++)
			for(int j = 0; j < len2; j++)
				if(Util.have_conflict(this.lectureTimes.get(i), t.get(j)))
					return true;
		return false;
	}
    
    public boolen compare(Course c1, Course c2){
        return c1.compareTo(c2);
    }
	
	@Override
	public String toString() {
		// stub
		// to-do
		return super.toString();
	}

}
