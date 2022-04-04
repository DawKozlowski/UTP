package zad1;

public class StringTask implements Runnable{


    Thread thread = new Thread(this);
    String text;
    String text2;
    int number;
    boolean created = false;
    boolean running=false;
    boolean finished=false;
    boolean aborted=false;


    public StringTask(String text, int number){
        this.text=text;
        text2=text;
        this.number=number;
        created=true;
    }


    public void run(){
        running = true;
        for (double i = 0; i < number - 1; i++) {
            text = text + text2;
        }
        finished = true;
        running = false;
    }


    public String getResult(){
        return text;
    }

    public TaskState getState() {
        if (aborted) {
            return TaskState.ABORTED;
        } else {
            if (running) {
                return TaskState.RUNNING;
            } else if (finished) {
                return TaskState.READY;
            } else {
                return TaskState.CREATED;
            }
        }
    }

    public void start(){
        thread.start();
    }

    public void abort(){
        thread.stop();
        aborted=true;
    }

    public boolean isDone(){
        switch (this.getState()){
            case READY: return true;

            case ABORTED: return true;

            default: return false;
        }
    }


}
