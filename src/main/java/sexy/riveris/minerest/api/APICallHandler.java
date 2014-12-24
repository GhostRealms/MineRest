/*
   Copyright 2014 River Marmorstein

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package sexy.riveris.minerest.api;

import org.json.simple.JSONObject;

import java.util.concurrent.Callable;

/**
 * Created by River on 23-Dec-14.
 */

public abstract class APICallHandler implements Callable<JSONObject> {

    private String[] calls;

    public APICallHandler(String... calls) {
        this.calls = calls;
        MineRestAPI.registerCalls(this, calls);
    }

    @Override
    public abstract JSONObject call() throws Exception;

}
