Starter project to create RESTful WS using Java, Jersey WS, Spring, Hibernate, Maven. Sample code for integrating with Hibernate/MySQL and MongoDB/NoSQL.<br /><br />
__Note:__ _The code is just a framework and does not do anything meaningful. Developers will have to write the actual functionality to make use of the framework._

#### Prerequisite packages
__Note:__ _The project has been tested on several versions of Mac OSX and Ubuntu Linux, but can work on any other platform as long as the packages mentioned in this section are available on the platform. Ensure that the user has sudo access to the host_
* __OpenJDK SDK__ (run command "sudo apt-get install openjdk-6-jdk", if not present)
* __Git__ (run command "sudo apt-get install git", if not present)
* __Maven__ (run command "sudo apt-get install maven2", if not present)
* __Curl__ (run command "sudo apt-get install curl", if not present)
* __MySQL Server__ (run command "sudo apt-get install mysql-server", if not present)
* __Vim (optional)__ (run command "sudo apt-get install vim", if not present)
* __IntelliJ Idea Community Edition (optional)__ (download IDE from the IntelliJ website)

#### Prerequisite MySQL database and tables
* Ensure that MySQL is running and has the __root__ password as __password__ (Else, modify the __hibernate.cfg.xml__ file with correct database credentials)
* Ensure that database __test__ exists (Else, create a database __test__ with the access credentials specified in __hibernate.cfg.xml__ file)
* Ensure that table __user__ exists in database __test__ (Else, run the SQL commands in __database_scripts/create_user_table.sql__ to create one)

#### Steps to compile, install and run code
Run the following commands in the given sequence:
* git clone https://github.com/swapnildipankar/java_jersey_spring_hibernate_maven.git
* cd java_jersey_spring_hibernate_maven
* mvn clean install (Depending on the connection speed, this step may take several minutes when executing this command for the first time)
* mvn tomcat7:run (The tomcat server should now be ready to accept requests on port 8400)

#### Sample test CURL calls
* _POST:_
```
	curl -i -H "Content-Type: application/json" -X POST -d \
	'{
		"username":"swapnildipankar",
		"password":"ɹɐʞuɐdıD lıudɐʍS",
		"name_first":"Swapnil",
		"name_middle":"M",
		"name_last":"Dipankar",
		"date_of_birth":14,
		"month_of_birth":10,
		"year_of_birth":1978
	}' 'http://localhost:8400/MavenHelloWorld-1.0/rest/user'
```

* _PUT:_
```
	curl -i -H "Content-Type: application/json" -X PUT -d \
	'{
		"id":"1",
		"username":"swapnildipankar",
		"password":"ɹɐʞuɐdıD lıudɐʍS",
		"name_first":"Swapnil",
		"name_middle":"M",
		"name_last":"Dipankar",
		"user_status":"ACTIVE",
		"date_of_birth":14,
		"month_of_birth":10,
		"year_of_birth":1978
	}' 'http://localhost:8400/MavenHelloWorld-1.0/rest/user/1'
```

* _GET:_ (By User ID)
```
	curl "http://localhost:8400/MavenHelloWorld-1.0/rest/user/1"
```

* _GET:_ (By UserName)
```
	curl "http://localhost:8400/MavenHelloWorld-1.0/rest/user?username=swapnildipankar"
```

* _DELETE:_
```
	curl -i -H "Content-Type: application/json" -X DELETE -d \
	'{
		"id":"1",
		"username":"swapnildipankar",
		"password":"ɹɐʞuɐdıD lıudɐʍS",
		"name_first":"Swapnil",
		"name_middle":"M",
		"name_last":"Dipankar",
		"date_of_birth":14,
		"month_of_birth":10,
		"year_of_birth":1978
	}' 'http://localhost:8400/MavenHelloWorld-1.0/rest/user/1'
```
