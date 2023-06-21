package state;

public class Context {
    private State state;
    private final String path;
    private boolean isCorrect;
    private String message;

    public Context(State state, String path){
        this.state = state;
        this.path = path;
        this.isCorrect = true;

        if (state == null)
            this.state = new ReadFile();
    }

    public String getPath(){
        return path;
    }

    public void setState(State state) {
        this.state = state;
    }
    public State getState() {
        return state;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public void update(){
        state.doAction(this);
    }
}
