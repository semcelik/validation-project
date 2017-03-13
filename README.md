#validation-project

Created project named as validation-project<br>
Added 4 submodules named as;

- validation-enforcer-rules: has 2 enforcer rules (both named as validationRule)
- validation-operators: has validation code of project. Designed with Strategy Design Pattern
- validation-samples: has resource files (.properties or .yaml)
- validation-integration-test: has invoker plugin's integration test

Usage:
- mvn -pl validation-samples enforcer:enforce@validationRule -Pyaml -DfileName=\<args\>
- mvn -pl validation-samples enforcer:enforce@validationRule -Pproperties -DfileName=\<args\>

-P option is mandatory (-Pyaml or -Pproperties)

- searches all files (depends on -P option) when -DfileName is not initialized
