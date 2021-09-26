package ljh;

import ljh.utils.ImageWatermark_font;
import ljh.utils.ImageWatermark_img;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootTestApplicationTests {

    // 文字水印铺满整张图
    @Test
    void font() {
        // 原图
        String srcImgPath = "C:\\lijinghai\\文件\\咸鱼哥.jpg";
        // 水印文字
        String logoText = "李京海";
        // 加水印后图片
        String targerTextPath2 = "C:\\lijinghai\\文件\\1.png";
        System.out.println ("给图片添加水印文字开始...");
        // 给图片添加正水印文字
//        ImageWatermark_font.ImageByText (logoText, srcImgPath, targerTextPath2, -40);
        // 给图片添加斜水印文字
        ImageWatermark_font.ImageByText (logoText, srcImgPath, targerTextPath2, -40);
        System.out.println ("给图片添加水印文字结束...");
    }

    // 图片铺满图片
    @Test
    void img() {
        // 水印图片路径
        String icon = "C:\\lijinghai\\文件\\未命名文件.png";
        // 没有加水印的图片路径
        String source = "C:\\lijinghai\\文件\\咸鱼哥.jpg";
        // 加水印后的图片路径
        String output = "C:\\lijinghai\\文件";
        // 图片名称
        String imageName = "2.png";
        // 图片类型
        String imageType = "png";
        // 水印图片旋转角度，为null表示不旋转
        Integer degree = -40;
        // 给图片添加斜水印图片
        ImageWatermark_img.markImageByMoreIcon(icon,source,output,imageName,imageType,degree);
    }



}
