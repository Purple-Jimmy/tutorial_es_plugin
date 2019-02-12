package com.tutorial.custom.plugin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.elasticsearch.index.analysis.AnalyzerProvider;
import org.elasticsearch.index.analysis.TokenizerFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义插件的主要实现,继承Plugin实现AnalysisPlugin
 * 通过重写getTokenizers将分词器工厂放入map
 * 通过重写getAnalyzers将分析器放入map
 * @Author: jimmy
 * @Date: 2019/2/12
 */
public class PluginStart extends Plugin implements AnalysisPlugin {
    private static Logger LOGGER = LogManager.getLogger(PluginStart.class);
    public static String PLUGIN_NAME = "custom_analysis";



    public PluginStart() {
        super();
        LOGGER.info("{} installed into elasticsearch",PLUGIN_NAME);
    }

    /**
     * 分词器factory
     * 把字符串分解成单个词条或者词汇单元
     * @return
     */
    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> getTokenizers() {
        Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> extra = new HashMap<>();
        extra.put("customPluginTF", CustomTokenizerFactory::new);
        return extra;
    }

    /**
     * 分析器 有且仅有一个
     * "analyzer":"ik_smart" 就是使用的这个
     * @return
     */
    @Override
    public Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
        return Collections.singletonMap("customPlugin", CustomAnalyzerProvider::new);
    }

}
