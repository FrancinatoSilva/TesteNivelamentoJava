package testTransformacaoDeDados;

import java.util.List;

public class DataTransformer {

    public static void substituirAbreviacoes(List<String[]> tabela) {
        for (String[] linha : tabela) {
            for (int i = 0; i < linha.length; i++) {
                if ("OD".equals(linha[i])) {
                    linha[i] = "Olho Direito";
                } else if ("AMB".equals(linha[i])) {
                    linha[i] = "Ambulatório";
                }
            }
        }
    }
}
