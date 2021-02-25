import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
  public static final String url = "https://api.nasa.gov/planetary/apod?api_key=b2nyG73o3p0JdNDUvoygEjc8cfPfEGtqyyuB1zQb";
  public static final ObjectMapper mapper = new ObjectMapper();

  public static void main(String[] args) throws IOException {
    CloseableHttpClient httpClient = HttpClientBuilder.create()
            .setDefaultRequestConfig(RequestConfig.custom()
                    .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                    .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                    .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                    .build())
            .build();
    // создание объекта запроса
    HttpGet request = new HttpGet(url);

    // отправка запроса
    CloseableHttpResponse response = httpClient.execute(request);

    // чтение
    Image image = mapper.readValue(response.getEntity().getContent(), new TypeReference<Image>() {
    });

    // запрос для получения картинки
    HttpGet request2 = new HttpGet(image.getUrl());
    CloseableHttpResponse response2 = httpClient.execute(request2);

    // имя файла
    String fileName = image.getUrl().substring(image.getUrl().lastIndexOf("/") + 1);
    System.out.println(fileName);

    // сохранение картинки в файл
    FileOutputStream out = new FileOutputStream(fileName);
    response2.getEntity().writeTo(out);
  }
}
