package com.supos.app.aksk;


import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/**
 * SaaS App open-api 签名工具
 *
 * @author caonuoqi@supos.com
 * @date 2021/11/22
 */
public class SignUtils {
    private static final String CARRIAGE_RETURN = "\n";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String EMPTY_STR = "";
    private static final String X_MC_PREFIX = "X-MC-";
    private String appId;
    private String appSecret;
    private String ak;
    private String sk;

    /**
     * token方式签名 类实例化
     *
     * @param appId     SaaS App的appId
     * @param appSecret SaaS App的appSecret
     */
    public SignUtils(String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
    }

    /**
     * aksk方式签名 类实例化
     *
     * @param appId     SaaS App的appId
     * @param appSecret SaaS App的appSecret
     * @param ak        租户对应的ak
     * @param sk        租户对应的sk
     */
    public SignUtils(String appId, String appSecret, String ak, String sk) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.ak = ak;
        this.sk = sk;
    }

    /**
     * token方式 请求header签名
     *
     * @param uri        open-api的uri 包含/ess-gate/{essRegion}/{essName}
     * @param methodName 请求方法名(字母大写)：GET POST DELETE PUT
     * @param headerMap  请求头参数
     * @param queryMap   请求参数（url ？后的参数）
     */
    public void signHeaderUseToken(String uri, String methodName, Map<String, String> headerMap, Map<String, String> queryMap) {
        StringBuffer sb = buildSignSource(uri, methodName, headerMap, queryMap);
        System.out.println("签名源内容：\n" + sb);
        HmacUtils hmacSha256 = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, appSecret);
        String signature = hmacSha256.hmacHex(sb.toString());
        String finalSignature = "Sign " + appId + "-" + signature;
        System.out.println("签名结果：\n" + finalSignature);
        headerMap.put("Authorization", finalSignature);
    }

    /**
     * aksk方式 请求header签名
     *
     * @param uri        open-api的uri 包含/ess-gate/{essRegion}/{essName},从/open-api开的的
     * @param methodName 请求方法名(字母大写)：GET POST DELETE PUT
     * @param headerMap  请求头参数
     * @param queryMap   请求参数（url ？后的参数）
     */
    public void signHeaderUseAkSk(String uri, String methodName, Map<String, String> headerMap, Map<String, String> queryMap) {
        StringBuffer sb = buildSignSource(uri, methodName, headerMap, queryMap).append(CARRIAGE_RETURN);
        System.out.println("签名源内容：\n" + sb);
        HmacUtils hmacSha256 = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, sk);
        String signature = hmacSha256.hmacHex(sb.toString());
        String finalSignature = "Sign " + ak + "-" + signature;
        System.out.println("签名结果：\n" + finalSignature);
        headerMap.put("Authorization", finalSignature);
    }

    public static String signHeaderUseAkSkWithInput(String uri, String methodName, Map<String, String> headerMap, Map<String, String> queryMap, String ak, String sk) {
        StringBuffer sb = buildSignSource(uri, methodName, headerMap, queryMap).append(CARRIAGE_RETURN);
        System.out.println("签名源内容：\n" + sb);
        HmacUtils hmacSha256 = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, sk);
        String signature = hmacSha256.hmacHex(sb.toString());
        String finalSignature = "Sign " + ak + "-" + signature;
        System.out.println("签名结果：\n" + finalSignature);
        return finalSignature;
    }

    /**
     * 拼接签名源
     *
     * @param uri        open-api的uri
     * @param methodName 请求方法名(字母大写)：GET POST DELETE PUT
     * @param headerMap  请求头参数
     * @param queryMap   请求参数（url ？后的参数）
     * @return 签名源串
     */
    private static StringBuffer buildSignSource(String uri, String methodName, Map<String, String> headerMap, Map<String, String> queryMap) {
        StringBuffer signStr = new StringBuffer();
        assert StringUtils.isNotBlank(methodName);
        //HTTP Schema
        signStr.append(methodName).append(CARRIAGE_RETURN);
        assert StringUtils.isNotBlank(uri);
        //HTTP URI
        signStr.append(uri).append(CARRIAGE_RETURN);
        String contentType = headerMap.get(CONTENT_TYPE);
        assert StringUtils.isNotBlank(contentType);
        //HTTP ContentType
        signStr.append(contentType).append(CARRIAGE_RETURN);
        //CanonicalQueryString
        signStr.append(buildCanonicalQueryString(queryMap)).append(CARRIAGE_RETURN);
        //CanonicalCustomHeaders
        signStr.append(buildCanonicalCustomHeaders(headerMap));
        return signStr;
    }

    /**
     * 生成有序的查询参数串
     * @param queryMap 查询参数
     * @return 有序的查询参数串
     */
    private static String buildCanonicalQueryString(Map<String, String> queryMap) {
        TreeMap<String, String> queryTreeMap = new TreeMap<>();
        if (queryMap != null && queryMap.size() > 0) {
            for (Map.Entry<String, String> m : queryMap.entrySet()) {
                queryTreeMap.put(m.getKey().toLowerCase(Locale.ROOT), m.getValue());
            }
            return queryTreeMap.toString().replace("{", EMPTY_STR)
                    .replace("}", EMPTY_STR).replace(", ", "&");
        }
        return EMPTY_STR;
    }

    /**
     * 生成有序的 HTTP协议头中所有“自定义”的Header
     * @param headerMap 请求头参数
     * @return 有序的 HTTP协议头中所有“自定义”的Header
     */
    private static String buildCanonicalCustomHeaders(Map<String, String> headerMap) {
        if (headerMap != null && headerMap.size() > 0) {
            TreeMap<String, String> headerTreeMap = new TreeMap<>();
            for (Map.Entry<String, String> m : headerMap.entrySet()) {
                if (m.getKey().startsWith(X_MC_PREFIX)) {
                    headerTreeMap.put(m.getKey().toLowerCase(Locale.ROOT), m.getValue());
                }
            }
            return headerTreeMap.toString().replace("{", EMPTY_STR).replace("}", EMPTY_STR)
                    .replace("=", ":").replace(", ", ";");
        }
        return EMPTY_STR;
    }
}