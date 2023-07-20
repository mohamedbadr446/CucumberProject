package CucumberFramwork1.runner;


import okhttp3.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

public class JSONTaleez {

    public static void  getjson() throws IOException {
       /* OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        Proxy proxyTest = new Proxy(Proxy.Type.HTTP,new InetSocketAddress("proxy", 443));
        OkHttpClient client = new OkHttpClient.Builder().proxy(proxyTest).build();*/
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api.taleez.com/0/jobs")
                .method("GET", null)
                .addHeader("X-taleez-api-key", "pk_live_4410_51919a8e820f4edab3f1be37a176674516068294148177e4d02873b7e4e039b3c0ba599274202")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
    public static void main(String[] args) throws IOException {
        getjson();
    }
}
