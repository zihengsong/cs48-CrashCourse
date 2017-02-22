package ucsbCurriculum.Utility;

import java.util.ArrayList;

import ucsbCurriculum.Utility.Time;

public class Util {
	
	// return true if those two Time have conflicts
	public static boolean have_conflict(Time t1, Time t2){
		return t1.start_time > t2.start_time ? (t1.start_time > t2.end_time) : (t2.start_time > t1.start_time);
	}
	
//  save for later, this can be used for compare when adding classes
	public static boolean compare(ArrayList<Time> time1, ArrayList<Time> time2){
		int len1 = time1.size();
		int len2 = time2.size();
		
		for(int i = 0; i < len1; i++){
			for(int j = 0; j < len2; j++){
				if(have_conflict(time1.get(i), time2.get(j))){
					// TO-DO: delete that element in the second list
					time2.remove(j);
				}
			}
		}
	
		// TO-DO: check the size of time2, if it's 0, return false, otherwise return true
//		return false; 
		if(time2.size()==0){
			return false;
		}
		else{
			return true;
		}
	}
	
	public static int converts_to_minute(String day, String t){
		return 1;
	}
	public static int converts_to_string(int minutes){
		return 1;
	}
}
