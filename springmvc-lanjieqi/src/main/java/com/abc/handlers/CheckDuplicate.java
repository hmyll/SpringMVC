package com.abc.handlers;


import org.apache.poi.hwpf.HWPFDocument;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.text.NumberFormat;

/**
 * @author lhj
 */
@Controller
public class CheckDuplicate {

    private char[] signs = {',' , '，' , '.' , '。' , '！' , '!' , '？' , '?' , ';' , '；'};

    public static double Jaro_Distance(String s1,String s2) throws Throwable {
        if("".equals(s1)||s1==null||"".equals(s2)||s2==null)
        {
            if("".equals(s1)||s1==null&&"".equals(s1)||s2==null){
                return 1.0;
            }
            return 0.0;
        }
        int allowrange=Math.max(s1.length(),s2.length())/2-1;
        int i,j;
        boolean is_match=false;
        int [] matches=new int[s2.length()];
        //将s2中匹配的字符标号，这个标号的意义在于计算t的值，
        //从前往后遍历，如果顺序不对，则肯定要调换
        //DWAYEN
        //0-132  这是一个matches的例子
        //DUANE
        for(i=0;i<s2.length();++i) {
            matches[i]=-1;
        }
        double m=0;//匹配的数目
        for(i=0;i<s1.length();++i)
        {
            is_match=false;
            for(j=i;is_match==false && j>=0 && j>=i-allowrange;--j)
            {
                if(s2.charAt(j)==s1.charAt(i))
                {
                    matches[j]= (int) m++;
                    is_match=true;
                }
            }
            for(j=i;is_match==false && j<s2.length() && j<=i+allowrange;++j)
            {
                if(s2.charAt(j)==s1.charAt(i))
                {
                    matches[j]= (int) m++;
                    is_match=true;
                }
            }
        }
        double t=0;
        i=0;
        for(j=0;j<s2.length();++j)
        {
            if(matches[j]!=-1)
            {
                if(matches[j]!=i++) {
                    ++t;
                }
            }
        }
        matches=null;
        System.gc();
        // printf("m = %lf, t = %lf\n",m,t);
        if(m==0) {
            return 0;
        } else {
            return (m/s1.length()+m/s2.length()+(m-t/2)/m)/3;
        }

    }
    public static double jaro_winkler_distance(String s1, String s2) throws Throwable {
        if("".equals(s1)||s1==null||"".equals(s2)||s2==null)
        {
            if("".equals(s1)||s1==null&&"".equals(s1)||s2==null){
                return 1.0;
            }
            return 0.0;
        }
        int i;
        double p=0.06;
        int len=0;
        for(i=0;i<4;++i)
        {
            if(s1.charAt(i)!=s2.charAt(i)) {
                break;
            }
            ++len;
        }
        double dj=Jaro_Distance(s1,s2);
        System.out.println(dj);
        return dj+p*len*(1-dj);
    }

    @RequestMapping("/upload0.do")
    public double selectWordFile(MultipartFile word1, MultipartFile word2) throws Throwable {

        HWPFDocument doc1 = new HWPFDocument(word1.getInputStream());
        HWPFDocument doc2 = new HWPFDocument(word2.getInputStream());

        String str1 = doc1.getDocumentText();
        String str2 = doc2.getDocumentText();

        double v = 0.0;

        for(int i=0;i<signs.length;i++){
            str1.replace(signs[i],'-');
            str2.replace(signs[i],'-');
        }

        String[] s1 = str1.split("-");
        String[] s2 = str2.split("-");

        if(str1.length()>=str2.length()) {
            v = CheckDuplicate(s1, s2);
        }
        else {
            v = CheckDuplicate(s2,s1);
        }


        return v;
    }

    public double CheckDuplicate(String[] s1,String[] s2) throws Throwable {

        double[] similarity = new double[30];

        String string1 = "";
        String string2 = "";

        int count1 = 0;
        int count2 = 0;
        int index = 0;

        int i=0,j=0;

        while(i<s1.length&&j<s2.length){

            for(;i<s1.length;i++){
                if(s1[i].length()+count1<=38){
                    string1 += s1[i];
                    count1 += s1[i].length();
                }
            }

            for(;j<s2.length;j++){
                if(s2[j].length()+count2<=count1&&s2[j].length()+count2<=38){
                    string2 += s2[j];
                    count1 += s2[j].length();
                }
            }

            for(int k=1;k<=count1-count2;k++){
                string2 += " ";
            }

            similarity[index++] = jaro_winkler_distance(string1,string2);

        }

        double sum = 0.0;
        double denominator = index*1.0;
        for(int k=0;k<index;k++){
            sum += (similarity[k]/denominator);
        }

        return sum;
    }


    public static void main(String[] args) throws Throwable {
        String s2 = "zhanghao";
        String s1 = "12561461";

        double dw = jaro_winkler_distance(s1,s2);
        System.out.println(dw);
        System.out.println(NumberFormat.getPercentInstance().format(dw));
    }
}
