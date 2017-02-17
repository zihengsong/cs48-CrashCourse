package ucsbCurriculum.Utility;

import java.util.ArrayList;

import stub.Time;

public class Util {
	
	// return true if those two Time have conflicts
	static boolean have_conflict(Time t1, Time t2){
		return t1.startTime > t2.startTime ? (t1.startTime > t2.endTime) : (t2.startTime > t1.startTime);
	}
	
//  save for later, this can be used for compare when adding classes
//	static boolean compare(ArrayList<Time> time1, ArrayList<Time> time2){
//		int len1 = time1.size();
//		int len2 = time2.size();
//		
//		for(int i = 0; i < len1; i++)
//			for(int j = 0; j < len2; j++)
//				if(have_conflict(time1.get(i), time2.get(j)))
//					// TO-DO: delete that element in the second list
//					
		// TO-DO: check the size of time2, if it's 0, return false, otherwise return true
//		return false;
//	}
	
	static int converts_to_minute(String day, String t){
		return 1;
	}
	static int converts_to_string(int minutes){
		return 1;
	}
}
