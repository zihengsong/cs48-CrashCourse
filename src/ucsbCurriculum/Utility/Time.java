package ucsbCurriculum.Utility;

public class Time {
    int start_time;
    int end_time;
    
    public Time(int start, int end){
        startTime = start;
        endTime = end;
    }
    
    public int getStart(){
        return startTime;
    }
    
    public int getEnd(){
        return endTime;
    }
}
