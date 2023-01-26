import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class QAWeather {
    private static final URL JSON = null;

    public class weather {
        private String var;
        private Object env;

        public String getVar() {
            return var;
        }

        public void setVar(String var) {
            this.var = var;
        }

        public Object getEnv() {
            return env;
        }

        public void setEnv(String env) {
            this.env = env;
        }
    }

    public static void main(String[] args) throws IOException{
        URL url1 = new URL("http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=V2aPAoCVU2z26xXTXNxKQlHona6GCVze");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url1.openConnection();

        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter
                (httpURLConnection.getOutputStream()));

        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader
                (httpURLConnection.getInputStream()));

        String temp;

        while ((temp = bufferedReader1.readLine()) != null) {
            System.out.println(temp);
        }
    }
}
