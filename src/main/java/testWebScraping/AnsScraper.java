package testWebScraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;

public class AnsScraper {
    private static final String ANS_URL = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos";

    public static List<String> extractPdfLinks() throws Exception {
        List<String> pdfLinks = new ArrayList<>();
        Document doc = Jsoup.connect(ANS_URL)
                .userAgent("Mozilla/5.0")
                .timeout(10_000)
                .get();

        Elements links = doc.select("a[href$=.pdf]");
        for (Element link : links) {
            String href = link.absUrl("href");
            if (href.toLowerCase().contains("anexo")) {
                pdfLinks.add(href);
            }
        }

        return pdfLinks;
    }
}
