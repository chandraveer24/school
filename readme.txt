1. for lombok only dependency is not sufficient, under maven dependencies we will have all the generated dependencies from pom.xml. Right click on lombok jar, 
run as Java application. Specify the path of ide .exe file location of IDE (C:\Users\cpasumarth\Downloads\sts-4.10.0.RELEASE\SpringToolSuite4.exe) and do install/update. Now close the IDE and start project again. 

2. For swagger add 2 dependencies from spring fox
  http://localhost:8080/v2/api-docs --> json version of swagger (this comes from swagger2)
  http://localhost:8080/swagger-ui.html#/ --> For swagger ui (this comes from swagger ui dependency)
  
 3. For pushing changes to my github account, please follow below commands.
    - In github create a repository.
 	- Navigate to the folder location which you need to push to github.
 	- right click on the folder open git bash.
 	- git init (initializes git on the selected folder)
 	- git add . (adds all the files to staging area and ready for commit)
 	- git commit -m "message" (commits changes to local repo)
 	- git remote add origin https://github.com/chandraveer24/school.git (school.git is the repository in my github. This command establishes connection between my local folder and github. 'chandraveer24' is my github account username)
 	- git push -u origin master (pushes code to github)
 	
 	Note: If you push changes before committing we get this (error: failed to push some refs to 'https://github.com/chandraveer24/school.git') error. Commit before pushing changes to github.