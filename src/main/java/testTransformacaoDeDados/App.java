package testTransformacaoDeDados;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            String pdfPath = "anexos/Anexo_I.pdf";
            String csvPath = "dados_extraidos.csv";
            String zipPath = "Teste_Francinato.zip";

            List<String[]> tabelaExtraida = PdfTableExtractor.extrairTabela();

            if (tabelaExtraida == null || tabelaExtraida.isEmpty()) {
                throw new IOException("Tabela extraída está vazia ou nula.");
            }

            DataTransformer.substituirAbreviacoes(tabelaExtraida, 3, 4);

            CsvWriter.salvarComoCSV(tabelaExtraida, csvPath);

            ZipUtils.compress(csvPath, zipPath);

            System.out.println("Processo concluído com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}