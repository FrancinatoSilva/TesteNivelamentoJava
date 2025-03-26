
package testWebScraping;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

public class PdfDownloader {
    public static void downloadFiles(List<String> urls, String outputDir) throws Exception {
        File dir = new File(outputDir);
        if (!dir.exists()) dir.mkdirs();

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            for (String url : urls) {
                String fileName = url.substring(url.lastIndexOf("/") + 1);
                File file = new File(dir, fileName);

                HttpGet request = new HttpGet(url);
                try (CloseableHttpResponse response = httpClient.execute(request);
                     InputStream is = response.getEntity().getContent();
                     FileOutputStream fos = new FileOutputStream(file)) {

                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = is.read(buffer)) != -1) {
                        fos.write(buffer, 0, bytesRead);
                    }
                }
            }
        }
    }
}