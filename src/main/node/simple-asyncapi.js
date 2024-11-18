const path = require('path');
const AsyncapiGenerator = require('@asyncapi/generator');
const generator = new AsyncapiGenerator(
    '@asyncapi/java-template',
    'build/asyncapi-generated-code/simple-asyncapi' /* path.resolve(__dirname, 'example') ==> If it was to use a relative path */
    , {
        forceWrite: true,
        templateParams: {server: 'production'}
    });

generator.generateFromFile('src/main/resources/simple-asyncapi.yml')
    .then(result => console.log('Done!' + result))
    .catch(error => console.error(error));
