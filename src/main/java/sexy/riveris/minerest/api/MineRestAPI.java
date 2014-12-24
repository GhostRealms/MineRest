package sexy.riveris.minerest.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by River on 23-Dec-14.
 */
public class MineRestAPI {

    private static Map<String, APICallHandler> handlerCallMap = new HashMap<String, APICallHandler>();

    public static void registerCalls(APICallHandler handler, String[] calls) {

    }
}
