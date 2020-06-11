package Backend.GameTools;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimer implements Serializable {

  private int interval;
  private Timer timer;
  private int totalTime;

  public MyTimer(int x) {
    interval = x;
    Run();
    totalTime = x;
  }

  private void Run() {
    int delay = 1000;
    int period = 1000;
    timer = new Timer();
    timer.scheduleAtFixedRate(
        new TimerTask() {

          public void run() {
            setInterval();
          }
        },
        delay,
        period);
  }

  private int setInterval() {
    if (interval == 1) {
      timer.cancel();
      System.out.println("Time's Up , You lost the game :(!");
      System.exit(0);
    }
    return --interval;
  }

  public String getTimeLeft() {
    return timeFormat(interval);
  }

  public String getTimePassed() {
    return timeFormat(totalTime - interval);
  }

  private String timeFormat(int timeInSecounds) {
    int h = timeInSecounds / (60 * 60);
    timeInSecounds %= (60 * 60);
    int m = timeInSecounds / 60;
    timeInSecounds %= 60;
    if (timeInSecounds < 0) timeInSecounds = 0;
    return "" + h + ':' + m + ':' + timeInSecounds;
  }

  @Override
  public String toString() {
    return "Timer";
  }
}
