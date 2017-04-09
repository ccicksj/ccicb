package com.qkjt.qkkt.common.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 保存上传文件等工具类
 *
 * @author unknown
 * @date 2015年1月6日 下午8:56:52
 */
public class CommonUtil {

    /**
     * check is null or "" or set，size=0 or list.size=0 or Array.length=0 or Map.isEmpty;
     *
     * @param obj
     * @return
     */
    public static boolean isNullOrEmpty(Object obj) {
        if (obj == null) {
            return true;
        } else if (obj instanceof java.lang.String) {
            return "".equals(obj);
        } else if (obj instanceof java.util.Set) {
            return ((java.util.Set) obj).size() == 0;
        } else if (obj instanceof java.util.List) {
            return ((java.util.List) obj).size() == 0;
        } else if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        } else if (obj instanceof java.util.Map) {
            return ((Map) obj).isEmpty();
        }
        return false;
    }

    /**
     * check Id is Legal DB table Id
     *
     * @param id
     * @return
     */
    public static boolean isLegalId(Integer id) {
        return (id != null && id > 0);

    }

    /**
     * add years,months,days to date
     *
     * @param date
     * @param years
     * @param months
     * @param days
     * @return
     */
    public static Date addToDate(Date date, int years, int months, int days) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, years);
        cal.add(Calendar.MONTH, months);
        cal.add(Calendar.DAY_OF_YEAR, days);
        return cal.getTime();
    }

    /**
     * date1.after(date2)?true:false
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean compDate(Date date1, Date date2) {
        if (date1 == null) {
            return false;
        }
        if (date2 == null) {
            return true;
        }

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return cal1.after(cal2);
    }

    /**
     * cut string by separator into two partion
     *
     * @param value
     * @param separator
     * @param isFirst: isFirst=true 从separator第一个出现的位置切分 isFirst=fasle 从separator最后一个出现的位置切分
     * @return
     */
    public static String[] separateString(String value, String separator, boolean isFirst) {
        String[] res = new String[] {"", ""};

        if (value == null || "".equals(value)) {
            return res;
        }
        if (separator == null || "".equals(value)) {
            res[0] = value;
        } else {
            if (isFirst) {
                int i = value.indexOf(separator);
                if (i == -1) {
                    res[0] = value;
                } else {
                    res[0] = value.substring(0, i);
                    res[1] = value.substring(i + separator.length());
                }
            } else {
                int i = value.lastIndexOf(separator);
                if (i == -1) {
                    res[0] = value;
                } else {
                    res[0] = value.substring(0, i);
                    res[1] = value.substring(i + separator.length());
                }
            }
        }
        return res;
    }

    /**
     * String.equals(String) Or String.equal(Object.toString)
     *
     * @param str1
     * @param obj
     * @param isIgnoreCase
     * @return
     */
    public static boolean stringEquals(String str1, Object obj, boolean isIgnoreCase) {

        if (str1 == null) {
            return obj == null;
        }
        if (obj == null) {
            return false;
        }
        if (isIgnoreCase) {
            return str1.equalsIgnoreCase(obj.toString());
        } else {
            return str1.equals(obj);
        }
    }

    /**
     * 判断Double类型是否相等
     *
     * @param obj1
     * @param obj2
     * @return
     */
    public static boolean doubleEqual(Object obj1, Object obj2) {
        if (obj1 == null) {
            return obj2 == null;
        }
        if (obj2 == null) {
            return false;
        }
        if (obj1 instanceof java.lang.Number && obj2 instanceof java.lang.Number) {
            return Double.compare(Double.parseDouble(obj1.toString()),
                    Double.parseDouble(obj2.toString())) == 0;
        } else {
            return false;
        }
    }

    public static int convertStringToInt(String str) {
        int res = 0;
        try {
            res = Integer.parseInt(str);
        } catch (Exception e) {

        }
        return res;
    }

    public static Integer convertStringToInteger(String str) {

        Integer res = null;

        if (str == null) {
            return res;
        }

        try {
            res = Integer.valueOf(str);
        } catch (Exception e) {

        }
        return res;
    }

    public static int convertObjectToInt(Object obj) {
        int res = 0;
        if (obj == null) {
            return res;
        }
        try {
            res = Integer.parseInt(obj.toString());
        } catch (Exception e) {

        }
        return res;
    }

    public static Integer convertObjectToInteger(Object obj) {
        Integer res = null;
        if (obj == null) {
            return res;
        }
        try {
            res = Integer.valueOf(obj.toString());
        } catch (Exception e) {

        }
        return res;
    }

    /**
     * 时间加1毫秒
     *
     * @param date
     * @param num
     * @return
     */
    public static Date add1MilliToDate(Date date, int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MILLISECOND, num);
        return cal.getTime();
    }

    /**
     * date1与date2相差的年数（舍余）
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int subDate(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return 0;
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        if (cal1.after(cal2)) {
            return ((cal1.get(1) * 12 + cal1.get(2)) - (cal2.get(1) * 12 + cal2.get(2))) / 12;
        } else {
            return ((cal2.get(1) * 12 + cal2.get(2)) - (cal1.get(1) * 12 + cal1.get(2))) / 12;
        }
    }

    public static int subDateGetDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return 0;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        Date d1 = cal.getTime();
        cal.setTime(date2);
        Date d2 = cal.getTime();
        long daterange = d2.getTime() - d1.getTime();
        long time = 1000 * 3600 * 24;
        long day = daterange / time;
        return convertObjectToInteger(day + 1);
    }

    /**
     * obj==null?null:obj.toString()
     *
     * @param obj
     * @return
     */
    public static String toString(Object obj) {
        return obj == null ? null : obj.toString();
    }

    /**
     * gc.add(1,1)年份加1 gc.add(2,1)月份加1 gc.add(3,1)周加1 gc.add(5,1)天加1 假如为-1表示是减
     *
     * @param date
     * @param d
     * @param beforeMonth
     * @return
     */
    public static Date getDateCal(Date date, int d, int beforeMonth) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.add(d, beforeMonth);
        gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc.get(Calendar.DATE));
        return gc.getTime();
    }

    /**
     * 删除input字符串中的html格式
     *
     * @param input
     * @param length
     * @return
     */
    public static String splitAndFilterString(String input, int length) {
        if (input == null || input.trim().equals("")) {
            return "";
        }
        // 去掉所有html元素,
        String str = input.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "");
        str = str.replaceAll("[(/>)<]", "");
        int len = str.length();
        if (len <= length) {
            return str;
        } else {
            str = str.substring(0, length);
            str += "...";
        }
        return str;
    }

    /**
     * removeNull
     *
     * @param sValue
     * @return
     */
    public static String removeNull(String sValue) {
        if (sValue == null) {
            sValue = "";
        } else {
            sValue = sValue.trim();
        }

        if (sValue.equals("null")) {
            sValue = "";
        }

        return sValue;
    }

    public static String getConvertDateTimeRam() {
        Random ran = new Random();
        int nValue = ran.nextInt();

        String ram = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        ram += nValue;
        return ram;
    }

    public static String getLogoname(String logo) throws Exception {
        String logoname = null;

        String ldname = logo.substring(logo.lastIndexOf("."), logo.length());

        logoname = getConvertDateTimeRam();
        logoname += ldname;
        System.out.println(logoname);

        return logoname;
    }

    public static Integer toInt(Object obj) {
        if (obj instanceof java.lang.String) {
            return Integer.parseInt((String) obj);
        } else {
            return (Integer) obj;
        }

    }

    public static String getStrDate(String dateString) {
        String hourtime = "";
        String[] st1 = dateString.split(" ");
        String[] sts = st1[0].split("-");
        String[] hours = st1[1].split(":");
        if (sts[1].length() <= 1 && Integer.parseInt(sts[1]) < 10) {
            sts[1] = "0" + sts[1];
        }
        if (sts[2].length() <= 1 && Integer.parseInt(sts[2]) < 10) {
            sts[2] = "0" + sts[2];
        }
        if ((Integer.parseInt(hours[0])) < 10) {
            hours[0] = "0" + hours[0];
        }
        String ss[] = hours[2].split("\\.");
        hours[2] = ss[0];
        hourtime = hours[0] + hours[1] + hours[2];
        String ssz = sts[0] + sts[1] + sts[2] + hourtime;
        return ssz;
    }

    public static String MD5Encode(String originString) {
        String resultString = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(originString.getBytes()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resultString;
    }

    /**
     * MD5
     *
     * @param b
     * @return
     */
    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "a", "b", "c", "d", "e", "f"};

    /**
     * 得到相应位数已过滤html、script、style 标签的内容 内容结尾 为...
     *
     * @param content
     * @param p >0 .位数
     * @return
     */
    public static String getNoHTMLString(String content, int p) {
        if (null == content) return "";
        if (0 == p) return "";

        java.util.regex.Pattern p_script;
        java.util.regex.Matcher m_script;
        java.util.regex.Pattern p_style;
        java.util.regex.Matcher m_style;
        java.util.regex.Pattern p_html;
        java.util.regex.Matcher m_html;

        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
            // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script> }
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
            // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style> }
            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(content);
            content = m_script.replaceAll(""); // 过滤script标签

            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(content);
            content = m_style.replaceAll(""); // 过滤style标签

            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(content);
            content = m_html.replaceAll(""); // 过滤html标签

        } catch (Exception e) {
            return "";
        }

        removeNull(content);// 去掉空格

        if (content.length() > p) {
            content = content.substring(0, p) + "...";
            // content = content.substring(0, p)+"...";
        } else {
            // content = content + "...";
        }
        return content;
    }

    /**
     * 计数器 (中文记 2，英文记 1)
     *
     * @param str
     * @param index
     * @return
     */
    public static String subString__(String str, int index) {
        Pattern p = Pattern.compile("^[\\u4e00-\\u9fa5]$");
        int i = 0;
        int j = 0;
        for (char c : str.toCharArray()) {
            Matcher m = p.matcher(String.valueOf(c));
            i += m.find() ? 2 : 1;
            ++j;
            if (i == index) break;
            if (i > index) {
                --j;
                break;
            }
        }
        String subStr = "";
        if (str.length() * 2 > index) {
            subStr = str.substring(0, j) + "...";
        } else {
            subStr = str.substring(0, j);
        }
        return subStr;
    }

    public static String subString_(String str, int index) {
        Pattern p = Pattern.compile("^[\\u4e00-\\u9fa5]$");
        int i = 0;
        int j = 0;
        for (char c : str.toCharArray()) {
            Matcher m = p.matcher(String.valueOf(c));
            i += m.find() ? 2 : 1;
            ++j;
            if (i == index) break;
            if (i > index) {
                --j;
                break;
            }
        }
        String subStr = "";
        if (str.length() * 2 > index) {
            subStr = str.substring(0, j);
        } else {
            subStr = str.substring(0, j);
        }
        return subStr;
    }

    public static int changeToInt(String str) {
        return Integer.parseInt(str);
    }

    /**
     * 转encodedURI编码
     *
     * @param encodedURI
     * @return
     */
    public static String decodeURIComponent(String encodedURI) {
        char actualChar;

        StringBuffer buffer = new StringBuffer();

        int bytePattern, sumb = 0;

        for (int i = 0, more = -1; i < encodedURI.length(); i++) {
            actualChar = encodedURI.charAt(i);

            switch (actualChar) {
                case '%': {
                    actualChar = encodedURI.charAt(++i);
                    int hb =
                            (Character.isDigit(actualChar) ? actualChar - '0' : 10 + Character
                                    .toLowerCase(actualChar) - 'a') & 0xF;
                    actualChar = encodedURI.charAt(++i);
                    int lb =
                            (Character.isDigit(actualChar) ? actualChar - '0' : 10 + Character
                                    .toLowerCase(actualChar) - 'a') & 0xF;
                    bytePattern = (hb << 4) | lb;
                    break;
                }
                case '+': {
                    bytePattern = ' ';
                    break;
                }
                default: {
                    bytePattern = actualChar;
                }
            }

            if ((bytePattern & 0xc0) == 0x80) { // 10xxxxxx
                sumb = (sumb << 6) | (bytePattern & 0x3f);
                if (--more == 0) buffer.append((char) sumb);
            } else if ((bytePattern & 0x80) == 0x00) { // 0xxxxxxx
                buffer.append((char) bytePattern);
            } else if ((bytePattern & 0xe0) == 0xc0) { // 110xxxxx
                sumb = bytePattern & 0x1f;
                more = 1;
            } else if ((bytePattern & 0xf0) == 0xe0) { // 1110xxxx
                sumb = bytePattern & 0x0f;
                more = 2;
            } else if ((bytePattern & 0xf8) == 0xf0) { // 11110xxx
                sumb = bytePattern & 0x07;
                more = 3;
            } else if ((bytePattern & 0xfc) == 0xf8) { // 111110xx
                sumb = bytePattern & 0x03;
                more = 4;
            } else { // 1111110x
                sumb = bytePattern & 0x01;
                more = 5;
            }
        }
        return buffer.toString();
    }

    /**
     * 生成UUID
     *
     * @return
     */
    public static String uuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    /**
     * 保存上传文件
     *
     * @param myfiles文件
     * @param path保存文件目录路径
     * @param imgName新文件名
     * @return 文件名
     * @throws IOException
     */
    public static String saveFile(MultipartFile[] myfiles, String path, String imgName)
            throws IOException {
        // String realPath = propertiesUtil.get("adfile");//读取配置文件中的图片保存目录
        // 如果只是上传一个文件，则只需要MultipartFile类型接收文件即可，而且无需显式指定@RequestParam注解
        // 如果想上传多个文件，那么这里就要用MultipartFile[]类型来接收文件，并且还要指定@RequestParam注解
        // 并且上传多个文件时，前台表单中的所有<input
        // type="file"/>的name都应该是myfiles，否则参数里的myfiles无法获取到所有上传的文件
        for (MultipartFile myfile : myfiles) {
            if (myfile.isEmpty()) {
                imgName = null;
            } else {
                if (null == imgName) {
                    imgName = myfile.getOriginalFilename();
                } else {
                    imgName = imgName + "." + myfile.getOriginalFilename().split("\\.")[1];// 新文件名+扩展名
                }
                FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(path, imgName));
            }
        }
        return imgName;
    }

    /**
     * 使用UUID保存上传文件
     *
     * @param myfiles
     * @param path
     * @return
     * @throws IOException
     */
    public static String saveFileUUID(MultipartFile[] myfiles, String path) throws IOException {
        return saveFile(myfiles, path, CommonUtil.uuid());
    }

    /**
     * 保存上传文件（支持多文件自定义名称）
     *
     * @param files
     * @param path
     * @param names
     * @throws IOException
     */
    public static void saveFiles(List<CommonsMultipartFile> files, String path, List<String> names)
            throws IOException {
        for (int i = 0; i < files.size(); i++) {
            if (!files.get(i).isEmpty()) {
                FileUtils.copyInputStreamToFile(files.get(i).getInputStream(),
                        new File(path, names.get(i)));
            }
        }
    }

    /**
     * 保存上传文件
     *
     * @param myfiles
     * @param path
     * @return
     * @throws IOException
     */
    public static String saveFile(MultipartFile[] myfiles, String path) throws IOException {
        return saveFile(myfiles, path, null);
    }

    /**
     * 生成随机验证码数字
     *
     * @param num 位数
     * @return
     */
    public static String generateVerifyCode(Integer num) {
        String str = "";
        while (str.length() < num) {
            str += (int) (Math.random() * 10);
        }
        return str;
    }
    
    public static Date strToDate(String DateStr){
        if(null==DateStr||"".trim().equals(DateStr))return null;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(DateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    
    public static String getReport(String str){
        String report = "无代谢性慢病风险";
        if(str.indexOf("您")>0){
            report = str.substring(str.indexOf("您")+1, str.indexOf("；"));
        }
        return report;
    }
    
    public static void main(String[] args){
        Date d = CommonUtil.strToDate("2024-05-21");
        int a = CommonUtil.subDate(new Date(),d );
        int b = Math.abs(220-120)*55/100;
        System.out.println(b);
       
        
        String str = "<div>1.测量结果显示, 您疑似3级高血压合并轻中度肥胖；</div><div>2.；</div><div>3.。</div><div>&nbsp;</div>";
        System.out.println(str.indexOf("您"));
        System.out.println(str.indexOf("；"));
        System.out.print(str.substring(str.indexOf("您")+1, str.indexOf("；")));
    
    }
}
