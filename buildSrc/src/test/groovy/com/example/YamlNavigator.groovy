package com.example

import org.yaml.snakeyaml.Yaml

class YamlNavigator {
    Map<String, Object> yamlMap

    YamlNavigator(InputStream yamlContent) {
        Yaml yaml = new Yaml()
        this.yamlMap = yaml.load(yamlContent)
    }

    def getProperty(String property) {
        def result = yamlMap
        property.split('\\.')
                .each {
                    result = result[it]
                }
        result
    }
}