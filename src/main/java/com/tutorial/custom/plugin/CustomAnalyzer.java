package com.tutorial.custom.plugin;


import org.apache.lucene.analysis.Analyzer;

/**
 * 分析器,继承Analyzer,里面需要塞一个分词器
 * @Author: jimmy
 * @Date: 2019/2/12
 */
public class CustomAnalyzer extends Analyzer {

    @Override
    protected TokenStreamComponents createComponents(String s) {
        return new TokenStreamComponents(new CustomTokenizer());
    }
}
