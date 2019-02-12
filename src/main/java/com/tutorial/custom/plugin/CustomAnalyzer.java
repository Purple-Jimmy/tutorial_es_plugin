package com.tutorial.custom.plugin;


import org.apache.lucene.analysis.Analyzer;

/**
 * 分析器,继承Analyzer,里面需要塞一个分词器
 * Analyzer包含两个核心组件,Tokenizer以及TokenFilter
 * 两者的区别在于:前者在字符级别处理流,而后者则在词语级别处理流
 * Tokenizer是Analyzer的第一步,其构造函数接收一个Reader作为参数
 * 而TokenFilter则是一个类似的拦截器,其参数可以是TokenStream、Tokenizer
 * @Author: jimmy
 * @Date: 2019/2/12
 */
public class CustomAnalyzer extends Analyzer {

    @Override
    protected TokenStreamComponents createComponents(String s) {
        return new TokenStreamComponents(new CustomTokenizer());
    }
}
