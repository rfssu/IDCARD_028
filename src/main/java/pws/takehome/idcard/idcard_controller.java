/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.takehome.idcard;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author MYLEGION
 */
public class idcard_controller {
    @RequestMapping("/next")
    public String next(
            @RequestParam(value = "val1") String nama,
            @RequestParam(value = "val2")
            @DateTimeFormat(pattern="yyyy-MM-dd") Date date,
            @RequestParam(value = "photo") MultipartFile foto,
            Model card
            
    )throws IOException{  
        SimpleDateFormat newTanggal = new SimpleDateFormat("EE-dd-MMMM-yyyy");
        String tgllahir = newTanggal.format(date);
        byte[] img = foto.getBytes();
        String base64Image = Base64.encodeBase64String(img);
        String imglink= "data:image/png;base64,".concat(base64Image);
        card.addAttribute("isinama", nama);
        card.addAttribute("isitgl", tgllahir);
        card.addAttribute("isifoto", imglink);
        
        
        return "viewpage";
    }
}
    
