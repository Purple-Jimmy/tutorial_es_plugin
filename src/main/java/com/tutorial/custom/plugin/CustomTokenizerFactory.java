package com.tutorial.custom.plugin;

import org.apache.lucene.analysis.Tokenizer;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenizerFactory;

/**
 * 分词器工厂,继承AbstractTokenizerFactory,通过重写create方法返回自定义的分词器
 * 作用:产生分词器类的实例
 * @Author: jimmy
 * @Date: 2019/2/12
 */
public class CustomTokenizerFactory extends AbstractTokenizerFactory {

    public CustomTokenizerFactory(IndexSettings indexSettings, Environment environment, String s, Settings settings) {
        super(indexSettings, s, settings);
      //  String polyphoneDbUrl = settings.get("polyphone_db_url");
    }

    @Override
    public Tokenizer create() {
        return new CustomTokenizer();
    }
}
