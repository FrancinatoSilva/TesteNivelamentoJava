package testWebScraping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
    public static void compress(String sourceDir, String outputZip) throws Exception {
        File dir = new File(sourceDir);
        if (!dir.exists() || dir.listFiles() == null || dir.listFiles().length == 0) {
            throw new IllegalArgumentException("Diretório vazio ou não encontrado: " + sourceDir);
        }

        try (FileOutputStream fos = new FileOutputStream(outputZip);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            for (File file : dir.listFiles()) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    ZipEntry zipEntry = new ZipEntry(file.getName());
                    zos.putNextEntry(zipEntry);

                    byte[] buffer = new byte[4096];
                    int length;
                    while ((length = fis.read(buffer)) > 0) {
                        zos.write(buffer, 0, length);
                    }

                    zos.closeEntry();
                }
            }
        }

        System.out.println("Arquivos compactados em: " + outputZip);
    }
}
