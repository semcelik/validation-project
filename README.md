#validation-project

Created project named as validation-project<br>
Added 3 submodules named as;

- validation-enforcer-rules: has 2 enforcer rules (both named as validationRule)
- validation-operators: has validation code of project. Designed with Strategy Design Pattern
- validation-samples: has resource files (.properties or .yaml)

Usage:
- mvn -pl validation-samples enforcer:enforce@validationRule -Pyaml -DfileName=\<args\>
- mvn -pl validation-samples enforcer:enforce@validationRule -Pproperties -DfileName=\<args\>

both parameters -Pyaml, -DfileName are mandatory
