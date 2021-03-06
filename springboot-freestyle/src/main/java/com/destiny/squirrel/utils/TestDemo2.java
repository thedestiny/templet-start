package com.destiny.squirrel.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description
 * @Author liangwenchao
 * @Date 2021-07-07 10:51 AM
 */
public class TestDemo2 {

    private static final String regEx_script    = "<script[^>]*?>[\\s\\S]*?<\\/script>";        /* 定义script的正则表达式 */
    private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>";          /* 定义style的正则表达式 */
    private static final String regEx_html  = "<[^>]+>";                                    /* 定义HTML标签的正则表达式<[^>]*> */
    private static final String regEx_space = "<a>\\s*|\t|\r|\n</a>";                       /* 定义空格回车换行符 */
    private static final String regEx_span = "/<span[^>]*>([^<]*)<\\/span>/ig";                       /*  span*/
    private static final String regEx_strong = "<strong.*?>(((?!<\\/strong>).)*)<\\/strong>";                       /* strong*/


    public static String delHTMLTag( String htmlStr )
    {
        /* 去掉script标签 */
        Pattern p_script = Pattern.compile( regEx_script,
                Pattern.CASE_INSENSITIVE );
        Matcher m_script = p_script.matcher( htmlStr );
        htmlStr = m_script.replaceAll( "" );    /* 过滤script标签 */
        /* 去掉style标签 */
        Pattern p_style = Pattern
                .compile( regEx_style, Pattern.CASE_INSENSITIVE );
        Matcher m_style = p_style.matcher( htmlStr );
        htmlStr = m_style.replaceAll( "" );     /* 过滤style标签 */
        /* 去掉html标签 */
        Pattern p_html  = Pattern.compile( regEx_html, Pattern.CASE_INSENSITIVE );
        Matcher m_html  = p_html.matcher( htmlStr );
        htmlStr = m_html.replaceAll( "" );      /* 过滤html标签 */
        /* 去掉span标签 */
        Pattern span_html  = Pattern.compile( regEx_span, Pattern.CASE_INSENSITIVE );
        Matcher span  = span_html.matcher( htmlStr );
        htmlStr = span.replaceAll( "" );      /* 过滤html标签 */
        /* 去掉regEx_strong标签 */
        Pattern strong_html  = Pattern.compile( regEx_strong, Pattern.CASE_INSENSITIVE );
        Matcher strong  = strong_html.matcher( htmlStr );
        htmlStr = strong.replaceAll( "" );      /* 过滤html标签 */
        /* 去掉空格 */
        Pattern p_space = Pattern
                .compile( regEx_space, Pattern.CASE_INSENSITIVE );
        Matcher m_space = p_space.matcher( htmlStr );
        htmlStr = m_space.replaceAll( "" );     /* 过滤空格回车标签 */
        /* 去掉<p>标签<br></br>标签和<>之间内容 */
        htmlStr.replaceAll( "<p .*?>", "\r\n" );
        htmlStr.replaceAll( "<br\\s*/?>", "\r\n" );
        htmlStr.replaceAll( "\\<.*?>", "" );
        return(htmlStr.trim() );                /* 返回文本字符串 */
    }


    public static String getTextFromHtml( String htmlStr ) {
        htmlStr = delHTMLTag( htmlStr );
        htmlStr = htmlStr.replaceAll( " ", "" );
        htmlStr = htmlStr.substring( 0, htmlStr.indexOf( "。" ) + 1 );
        return(htmlStr);
    }


    public static void main(String[] args) {

        String test = "";

       // System.out.println(getTextFromHtml(test));

        BigDecimal decimal = new BigDecimal(0);
        BigDecimal decimal1 = new BigDecimal(0.3);
        System.out.println(decimal);
        String test1 = "";

        List<String> lst = null;
        System.out.println(lst.isEmpty());


        Document parse = Jsoup.parse(test1);
        System.out.println(parse.text());


    }

}
