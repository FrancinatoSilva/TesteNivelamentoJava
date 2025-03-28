package testTransformacaoDeDados;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PdfTableExtractor {

    public static List<String[]> extrairTabela() throws IOException {
        File dir = new File("anexos");

        File[] files = dir.listFiles((d, name) -> name.contains("Anexo_I_Rol"));

        if (files != null && files.length > 0) {
            File file = files[0];
            System.out.println("Arquivo encontrado: " + file.getName());

            PDDocument document = PDDocument.load(file);
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);

            List<String[]> tabela = new ArrayList<>();
            String[] linhas = text.split("\n");

            for (String linha : linhas) {
                String[] colunas = linha.split("\\s{2,}");
                tabela.add(colunas);
            }

            document.close();
            return tabela;
        } else {
            System.out.println("Nenhum arquivo correspondente encontrado.");
            return new ArrayList<>();
        }
    }
}
