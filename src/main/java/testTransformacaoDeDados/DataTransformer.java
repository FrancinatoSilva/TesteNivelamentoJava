package testTransformacaoDeDados;

import java.util.List;

public class DataTransformer {

    public static void substituirAbreviacoes(List<String[]> tabela, int indiceOD, int indiceAMB) {
        if (tabela == null || tabela.isEmpty()) {
            return;
        }

        for (String[] linha : tabela) {
            if (indiceOD >= 0 && indiceOD < linha.length) {
                if ("OD".equalsIgnoreCase(linha[indiceOD])) {
                    linha[indiceOD] = "Odontológica";
                }
            }
            if (indiceAMB >= 0 && indiceAMB < linha.length) {
                if ("AMB".equalsIgnoreCase(linha[indiceAMB])) {
                    linha[indiceAMB] = "Ambulatorial";
                }
            }
        }
    }
}