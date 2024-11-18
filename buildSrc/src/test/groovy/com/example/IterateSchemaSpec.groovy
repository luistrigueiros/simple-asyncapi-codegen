package com.example

import org.yaml.snakeyaml.DumperOptions
import org.yaml.snakeyaml.Yaml
import spock.lang.Specification

class IterateSchemaSpec extends Specification {
    YamlNavigator yamlNavigator

    def "Should have yml doc"() {
        when:
            def schemas = yamlNavigator.'components.schemas'
        then:
            ! schemas.isEmpty()
        and:
            def yaml1 = yamlDump( schemas['Member'] )
        then:
            yaml1
    }

    def setup() {
        InputStream inputStream = this.class.getResourceAsStream('/member.asyncapi.yaml')
        yamlNavigator = new YamlNavigator(inputStream)
    }

    def yamlDump(def obj) {
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        Yaml yaml = new Yaml(options);
        return yaml.dump(obj);
    }
}