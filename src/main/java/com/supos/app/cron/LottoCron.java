package com.supos.app.cron;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.supos.app.dto.sampleMailDto;
import com.supos.app.entity.Lotto;
import com.supos.app.service.impl.LottoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static com.supos.app.impl.SampleMail.sendLottoMail;

@Component
public class LottoCron {

    @Autowired
    LottoServiceImpl lottoServiceImpl;

    @Scheduled(cron="0 0 14 * * ?")
//    @Scheduled(cron="0/5 * * * * ?")   //每5秒执行一次
    public void execute() throws IOException {

        // 使用HashMap按name分组收集中奖细节
        Map<String, List<String>> userDetails = new HashMap<>();
        Map<String, String> userEmails = new HashMap<>();

        HttpResponse response = HttpRequest.get("https://webapi.sporttery.cn/gateway/lottery/getHistoryPageListV1.qry?gameNo=85&provinceId=0&pageSize=30&isVerify=1&pageNo=1").formStr(null).headerMap(null, true).execute();
        System.out.println(response);

        String lotteryDrawNum= JSON.parseObject(response.body()).getJSONObject("value").getJSONObject("lastPoolDraw").getString("lotteryDrawNum");
        System.out.println(lotteryDrawNum);

        String lotteryDrawResult= JSON.parseObject(response.body()).getJSONObject("value").getJSONObject("lastPoolDraw").getString("lotteryDrawResult");
        String[] lotteryDrawResultArray = lotteryDrawResult.split("\\s+");

        List<Lotto> lottoList  = lottoServiceImpl.selectAllWithoutSend();
        Gson gson = new Gson();
        Type listType = new TypeToken<List<String>>(){}.getType();

        // 开奖结果的前区和后区
        List<String> lotteryDrawResultFront = Arrays.asList(Arrays.copyOfRange(lotteryDrawResultArray, 0, 5));
        List<String> lotteryDrawResultBack = Arrays.asList(Arrays.copyOfRange(lotteryDrawResultArray, 5, 7));

        for (Lotto lotto : lottoList) {
            String lottoPeriod = lotto.getPeriod();
            if (lotteryDrawNum.contains(lottoPeriod)) {
                System.out.println("Period: " + lottoPeriod + ", Number: " + lotto.getNumber());

                List<String> lottoNumberList = gson.fromJson(String.valueOf(lotto.getNumber()), listType);
                // 分别获取前区和后区号码
                List<String> lottoNumberFront = lottoNumberList.subList(0, 5);
                List<String> lottoNumberBack = lottoNumberList.subList(5, 7);

                // 计算匹配数量
                int matchFront = 0;
                for (String num : lottoNumberFront) {
                    if (lotteryDrawResultFront.contains(num)) {
                        matchFront++;
                    }
                }

                int matchBack = 0;
                for (String num : lottoNumberBack) {
                    if (lotteryDrawResultBack.contains(num)) {
                        matchBack++;
                    }
                }

                // 根据匹配数量判断中奖等级
                String prize = "未中奖";
                if (matchFront == 5 && matchBack == 2) {
                    prize = "一等奖，奖金 8,217,484元";
                } else if (matchFront == 5 && matchBack == 1) {
                    prize = "二等奖，奖金 80,002元";
                } else if (matchFront == 5) {
                    prize = "三等奖，奖金 10,000元";
                } else if (matchFront == 4 && matchBack == 2) {
                    prize = "四等奖，奖金 3,000元";
                } else if (matchFront == 4 && matchBack == 1) {
                    prize = "五等奖，奖金 300元";
                } else if (matchFront == 3 && matchBack == 2) {
                    prize = "六等奖，奖金 200元";
                } else if (matchFront == 4) {
                    prize = "七等奖，奖金 100元";
                } else if (matchFront == 3 && matchBack == 1 || matchFront == 2 && matchBack == 2) {
                    prize = "八等奖，奖金 15元";
                } else if (matchFront == 3 && matchBack == 0|| matchFront == 2 && matchBack == 1|| matchFront == 1 && matchBack == 2|| matchFront == 0 && matchBack == 2) {
                    prize = "九等奖，奖金 5元";
                }

                lotto.setSend_flag(1);
                lotto.setResult(prize);
                lottoServiceImpl.update(lotto);
                System.out.println(prize);
                // 收集中奖细节
                userDetails.computeIfAbsent(lotto.getName(), k -> new ArrayList<>()).add(prize);
                userEmails.putIfAbsent(lotto.getName(), lotto.getEmail());
            }
        }

        // 对每个用户发送一封邮件
        for (Map.Entry<String, List<String>> entry : userDetails.entrySet()) {
            String name = entry.getKey();
            List<String> prizes = entry.getValue();
            String email = userEmails.get(name);

            sampleMailDto mailDto = new sampleMailDto();
            mailDto.setName(String.join(", ", prizes)+" 开奖号码为："+lotteryDrawResult); // 中奖细节作为邮件内容
            mailDto.setMail(email); // 设置收件人邮箱

            sendLottoMail(mailDto); // 发送邮件
        }

    }

    public static void main(String[] args) {

        HttpResponse response = HttpRequest.get("https://webapi.sporttery.cn/gateway/lottery/getHistoryPageListV1.qry?gameNo=85&provinceId=0&pageSize=30&isVerify=1&pageNo=1").formStr(null).headerMap(null, true).execute();
        System.out.println(response);

        String lotteryDrawResult= JSON.parseObject(response.body()).getJSONObject("value").getJSONObject("lastPoolDraw").getString("lotteryDrawResult");
        String[] lotteryDrawResultArray = lotteryDrawResult.split("\\s+");

        // 将字符串数组转换为列表
        List<String> lotteryDrawResultList = Arrays.asList(lotteryDrawResultArray);

        System.out.println(lotteryDrawResultList);

    }

}
