var TimerTask = Java.type("java.util.TimerTask");
var myTimerTask = Java.extend(TimerTask, {
    run: function () {
        print ("Time: " + Date());
    }
});
var Timer = Java.type("java.util.Timer");
new Timer().schedule(new myTimerTask(), 0, 1000);