package sexy.riveris.minerest.api;

/**
 * Created by River on 23-Dec-14.
 */
public abstract class APICallHandler {

    private String[] calls;

    public APICallHandler(String... calls) {
        this.calls = calls;

    }

    public abstract Object response();
}
