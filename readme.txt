1. for lombok only dependency is not sufficient, under maven dependencies we will have all the generated dependencies from pom.xml. Right click on lombok jar, 
run as Java application. Specify the path of ide .exe file location of IDE (C:\Users\cpasumarth\Downloads\sts-4.10.0.RELEASE\SpringToolSuite4.exe) and do install/update. Now close the IDE and start project again. 

2. For swagger add 2 dependencies from spring fox
  http://localhost:8080/v2/api-docs --> json version of swagger (this comes from swagger2)
  http://localhost:8080/swagger-ui.html#/ --> For swagger ui (this comes from swagger ui dependency)