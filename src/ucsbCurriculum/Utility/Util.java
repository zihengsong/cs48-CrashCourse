package ucsbCurriculum.Utility;

import java.util.ArrayList;
import ucsbCurriculum.Utility.Time;

import ucsbCurriculum.Utility.Time;

public class Util {
	
	// return true if those two Time have conflicts
	public static boolean have_conflict(Time t1, Time t2){
		return t1.start_time > t2.start_time ? (t1.start_time > t2.end_time) : (t2.start_time > t1.start_time);
	}
	
	public static Time converts_to_minute(String day, String t){
		return new Time();
	}
	public static int converts_to_string(int minutes){
		return 1;
	}
}
