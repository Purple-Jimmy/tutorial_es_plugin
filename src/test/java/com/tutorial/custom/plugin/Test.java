package com.tutorial.custom.plugin;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

/**
 * @Author: jimmy
 * @Date: 2019/2/12
 */
public class Test {

    public static void main(String[] args) throws IOException {
        CustomAnalyzer analyzer = new CustomAnalyzer();
        TokenStream ts = analyzer.tokenStream("text", "我爱北京 天安门");
        CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
        ts.reset();
        while (ts.incrementToken()) {
            System.out.println(term.toString());
        }
        ts.end();
        ts.close();
    }
}
