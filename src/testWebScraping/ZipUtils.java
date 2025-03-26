package testWebScraping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
    public static void compress(String sourceDir, String outputZip) throws Exception {
        FileOutputStream fos = new FileOutputStream(outputZip);
        ZipOutputStream zos = new ZipOutputStream(fos);

        File dir = new File(sourceDir);
        for (File file : dir.listFiles()) {
            FileInputStream fis = new FileInputStream(file);
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zos.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }

            fis.close();
        }

        zos.close();
        fos.close();
    }
}