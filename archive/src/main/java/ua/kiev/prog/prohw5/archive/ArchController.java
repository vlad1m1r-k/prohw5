package ua.kiev.prog.prohw5.archive;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Controller
public class ArchController {
    @RequestMapping("/")
    public String onIndex() {
        return "index";
    }

    @RequestMapping(value = "/pack", method = RequestMethod.POST)
    public ResponseEntity<byte[]> onPack(@RequestParam MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return null;
        }
        OutputStream zipOutputStream = new ByteArrayOutputStream();
        ZipOutputStream zippedFile = new ZipOutputStream(zipOutputStream);
        zippedFile.putNextEntry(new ZipEntry(file.getOriginalFilename()));
        zippedFile.write(file.getBytes());
        zippedFile.closeEntry();
        zippedFile.close();
        zipOutputStream.close();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.set("Content-disposition", "attachment; filename=" + file.getOriginalFilename() + ".zip");
        return new ResponseEntity<>(((ByteArrayOutputStream) zipOutputStream).toByteArray(), headers, HttpStatus.OK);
    }
}
