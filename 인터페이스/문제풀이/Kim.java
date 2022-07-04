package 인터페이스.문제풀이;

import java.util.Timer;
import java.util.TimerTask;

public interface Kim {
    default void kim_change(int[] channel) {
        while(true) {
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                
                int i = 0;
                @Override
                public void run() {
                    System.out.println("Kim;s 채널: " + channel[i%2]);                    
                    i++;
                }
            };
            timer.schedule(task, 5000);
        }
    }
}
