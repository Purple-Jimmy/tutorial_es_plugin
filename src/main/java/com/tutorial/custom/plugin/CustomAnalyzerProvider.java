package com.tutorial.custom.plugin;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractIndexAnalyzerProvider;

/**
 * 分析器提供程序,继承AbstractIndexAnalyzerProvider,通过重写get方法返回自定义分析器
 * @Author: jimmy
 * @Date: 2019/2/12
 */
public class CustomAnalyzerProvider extends AbstractIndexAnalyzerProvider<CustomAnalyzer> {
    private final CustomAnalyzer customAnalyzer;

    //@Inject
    public CustomAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        super(indexSettings, name, settings);
        customAnalyzer = new CustomAnalyzer();
    }

    @Override
    public CustomAnalyzer get() {
        return customAnalyzer;
    }
}
