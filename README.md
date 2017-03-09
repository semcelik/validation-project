# validation-example
1- Created plugin named as<br>
-validator<br><br>

2- Created 3 goals in validate named as; <br>
-properties<br>
-yaml<br>
-propOnCurrentDir<br><br>


mvn validator:properties -> checks syntax validation for ".properties" files in src/test/resources/properties/<br>
mvn validator:yaml -> checks syntax validation for ".yml" files in src/test/resources/yaml<br>
mvn validator:propOnCurrentDir -> checks syntax validation for ".properties" files in current directory (No Need Pom)<br><br> 


3- Created Enforcer plugin custom rule named as validationRule with 2 parameters;<br>
-DfileName= -> checks syntax validation for src/test/resources/properties/\<args><br>
-DfileNameWithPath= -> chech syntax validation for \<args> path<br>
Example: mvn enforcer:enforce@validationRule -DfileName=config.properties<br>
Example: mvn enforcer:enforce@validationRule -DfileNameWithPath=src/test/resources/properties/config.properties
