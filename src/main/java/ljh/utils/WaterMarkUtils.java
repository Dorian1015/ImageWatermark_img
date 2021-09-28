package ljh.utils;
 
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Encoder;

import java.nio.charset.Charset;

/**
 * Title: WaterMarkUtils
 * Description: 阿里云Oss水印图片处理
 *
 * @Author: lijinghailjh@163.com
 * @Date: 2021/9/24 16:06
 */
@Slf4j
public class WaterMarkUtils {
 
    public static String thumbnail = "?x-oss-process=image/resize,l_1000,";


    /**
     * 图片水印
     *
     * @return 返回值
     */
    public static String addImageWaterMark(){
 
        //水印图片为当前的Bucket下图片，直接针对图片名称进行base64编码。（水印图片地址，存在OSS中）
        String imagePathStr = "sms/water.png";
        String encodeBase64 = new BASE64Encoder().encode(imagePathStr.getBytes());
 
        String safeBase64Str = encodeBase64.replace('+', '-');
 
        safeBase64Str = safeBase64Str.replace('/', '_');
 
        safeBase64Str = safeBase64Str.replaceAll("=", "");
 
        String waterMark = thumbnail + "/watermark,image_"+safeBase64Str+",t_20";
        log.info("================");
        log.info(waterMark);
        return waterMark;
    }
 
    /**
     * 文字水印
     *
     * @return 返回值
     */
    public static String addTextWaterMark(String text,String planName,String time,String code){
 
 
        String textBase64 = new BASE64Encoder().encode(text.getBytes(Charset.forName("utf8")));
        String textBase64Str = textBase64.replace('+', '-');
        textBase64Str = textBase64Str.replace('/', '_');
        textBase64Str = textBase64Str.replaceAll("=", "");
 
        String planNameBase64 = new BASE64Encoder().encode(planName.getBytes(Charset.forName("utf8")));
        String planNameBase64Str = planNameBase64.replace('+', '-');
        planNameBase64Str = planNameBase64Str.replace('/', '_');
        planNameBase64Str = planNameBase64Str.replaceAll("=", "");
 
        String timeBase64 = new BASE64Encoder().encode(time.getBytes(Charset.forName("utf8")));
        String timeBase64Str = timeBase64.replace('+', '-');
        timeBase64Str = timeBase64Str.replace('/', '_');
        timeBase64Str = timeBase64Str.replaceAll("=", "");
 
        String codeBase64 = new BASE64Encoder().encode(code.getBytes(Charset.forName("utf8")));
        String codeBase64Str = codeBase64.replace('+', '-');
        codeBase64Str = codeBase64Str.replace('/', '_');
        codeBase64Str = codeBase64Str.replaceAll("=", "");
 
        String waterMark = "?x-oss-process=image/resize,w_450,h_640/watermark,type_d3F5LW1pY3JvaGVp,size_22,text_"+textBase64Str+",color_333333,t_100,g_north,y_230/watermark,type_d3F5LW1pY3JvaGVp,size_20,text_"+planNameBase64Str+",color_000000,t_100,g_north,y_260/watermark,type_d3F5LW1pY3JvaGVp,size_12,text_"+timeBase64Str+",color_333333,t_100,g_sw,x_48,y_240/watermark,type_d3F5LW1pY3JvaGVp,size_12,text_"+codeBase64Str+",color_333333,t_100,g_sw,x_48,y_220";
 
        return waterMark;
    }
 
}