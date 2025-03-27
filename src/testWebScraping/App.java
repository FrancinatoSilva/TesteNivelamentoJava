package testWebScraping;

import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            System.out.println("Iniciando Web Scraping...");
            List<String> pdfLinks = AnsScraper.extractPdfLinks();
            System.out.println("Foram encontrados " + pdfLinks.size() + " PDFs.");

            if (pdfLinks.isEmpty()) {
                System.err.println("Nenhum PDF foi encontrado. O processo será encerrado.");
                return;
            }

            String downloadDir = "anexos";
            PdfDownloader.downloadFiles(pdfLinks, downloadDir);

            String zipFile = "anexos.zip";
            ZipUtils.compress(downloadDir, zipFile);

            System.out.println("Processo concluído com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
