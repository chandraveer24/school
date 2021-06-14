1. For lombok, only dependency is not sufficient, under maven dependencies we will have all the generated dependencies from pom.xml. Right click on lombok jar, 
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
 	
 4. Pulling code from github to local machine.
 	- Download and install git if its not already installed.
 	- Create a folder where you want to pull the code from github.
 	- Right click git bash and initialize git. git init
 	- Clone the repo. git clone 'https://github.com/chandraveer24/school.git'
 	- git pull 'https://github.com/chandraveer24/school.git' (origin) master
 	
 5. If you have any issues running spring boot application, try deleting .m2 folder resides in C:/users/<user-name>/.m2 and mvn install, which runs the life cycle process again and creates new jar files.
 
 6. Download MongoDb and install in your local. It installs in program files and navigate to MonoDB folder and go to bin folder. 
 	You can see 2 files 
 		- mongo.exe (terminal screen of mongoDB, we can run/ execute queries).
 		- mongod.exe (this is where we need to start the server). We need to create a folder structure where MongoDB is installed. 
 		  if it is installed in C drive then in C drive create folder data, inside data create folder db. Now start running mongod.exe file.
 		- run command in mongod.exe file, navigate to bin folder of MongoDB (mongod --storageEngine=mmapv1), 
 		  if we run this command we don't have to open mongod.exe every time for running mongo.exe. We can see MongoDB is running in 27017 port.
 		- Now open mongo.exe navigate to bin folder of MongoDB and try following command to test MongoDB is running or not.
 			- show dbs (returns all the databases, internally MonoDB has 3 DBs) -- If this returns with some values we can make sure MongoDB is running.
 			- use myNewDB (creates a database with name myNewDB)
 			- db.myNewCollection.insert({"name":"Chandraveer"}) (creates a collection with name myNewCollection and inserts a value into the collection)
 			
 7. Download and install Studio 3T which is similar to SQLWorkbench. Provides UI for running MongoDB queries.
 	- Open Studio3T, click on connect, you can see port number 27017 is running and give the name as it is local give name as local and connect.
 	- It will create a connection and can see all the databases.
 	- Sample Queries from MongoDB
 	db -> refers current database
 	School -> Collection inside DB (same as table in SQL)
 	db.School.update(
    {
        "name":"Southern Illinois University"
    },
    {
        $set: {
            "name":"Southern Illinois University Carbondale"
        }
    }
	) 
	From collection School update where name is Southern Illinois University and set name as Southern Illinois University Carbondale.
	To update multiple documents we must use updateMany, update works as updateOne.
	db.School.find().pretty(); // retrieves all the documents from collection
	// deletes a document
	db.School.remove(
	 {
	   "name":"Southern Illinois University Carbondale"
	 }
	 )
	 // queries sub document
	 db.School.find(
    {
        "student.name":"Mounika Pasumarthi"
 
    }    
	);
	
	
    