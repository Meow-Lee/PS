import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] cur_time = br.readLine().split(":");
        String[] throw_time = br.readLine().split(":");

        int cur_hour = Integer.parseInt(cur_time[0]);
        int cur_minute = Integer.parseInt(cur_time[1]);
        int cur_second = Integer.parseInt(cur_time[2]);

        int th_hour = Integer.parseInt(throw_time[0]);
        int th_minute = Integer.parseInt(throw_time[1]);
        int th_second = Integer.parseInt(throw_time[2]);

        int hour = th_hour - cur_hour;
        int minute = th_minute - cur_minute;
        int second = th_second - cur_second;

        if(hour==0 && minute==0 && second==0){
            System.out.println("24:00:00");
        }
        else{
            if(second<0){
                second += 60;
                --minute;
            }
            if(minute<0){
                minute+=60;
                --hour;
            }
            if(hour<0){
                hour += 24;
            }
            System.out.format("%02d:%02d:%02d", hour, minute, second);
        }
    }
}