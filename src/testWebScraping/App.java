package testWebScraping;

import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            List<String> pdfLinks = AnsScraper.extractPdfLinks();

            String downloadDir = "anexos";
            PdfDownloader.downloadFiles(pdfLinks, downloadDir);

            ZipUtils.compress(downloadDir, "anexos.zip");

            System.out.println("Processo concluído com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}