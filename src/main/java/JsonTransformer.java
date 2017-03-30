/**
 * Created by martin on 29/03/17.
 */


    import com.google.gson.Gson;
    import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {

        private Gson gson = new Gson();

        @Override
        public String render(Object model) {
            return gson.toJson(model);
        }

    }
