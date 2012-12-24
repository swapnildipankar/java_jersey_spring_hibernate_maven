Starter project to create RESTful WS using Java, Jersey WS, Spring, Hibernate, Maven, Liquibase. Sample code for integrating with Hibernate/MySQL and MongoDB/NoSQL.<br /><br />
__Note:__ _This is a skeletal framework and does not do anything meaningful. Using the sample code, developers can send a sample CURL call (see section "Sample test CURL calls" below) to the running web service and see the changes propagated all the way to the MySQL database. Developers will have to write the actual functionality to make use of the framework._

#### Technologies used in the project
* __Java__
* __Jersey WS Framework__
* __Spring Framework__
* __Hibernate__
* __Maven__
* __Liquibase__
* __MySQL__
* __Mongo DB__ (pending)

#### Prerequisite packages
__Note:__ _The project has been tested on several versions of Mac OSX and Ubuntu Linux, but can work on any other platform as long as the packages mentioned in this section are available on the platform. Ensure that the user has sudo access to the host_
* __OpenJDK SDK__ (run command _sudo apt-get install openjdk-6-jdk_, if not present) __Note:__ _Sun JDK can be used instead of OpenJDK without impacting the functionality of the framework_
* __Git__ (run command _sudo apt-get install git_ or _sudo apt-get install git-core_, if not present)
* __Maven__ (run command _sudo apt-get install maven2_, if not present)
* __Curl__ (run command _sudo apt-get install curl_, if not present)
* __MySQL Server__ (run command _sudo apt-get install mysql-server_, if not present)
* __Vim (optional)__ (run command _sudo apt-get install vim_, if not present)
* __IntelliJ Idea Community Edition (optional)__ (download IDE from the IntelliJ website)

#### Prerequisite MySQL database and tables
* Ensure that MySQL is running and has the __root__ password as __password__ (Else, modify the __hibernate.cfg.xml__ file with correct database credentials)
* Ensure that database __test__ exists (Else, create a database __test__ with the access credentials specified in __hibernate.cfg.xml__ file)

#### Steps to compile, install and run code
Run the following commands in the given sequence:
* git clone https://github.com/swapnildipankar/java_jersey_spring_hibernate_maven.git
* cd java_jersey_spring_hibernate_maven
* mvn clean install (Depending on the connection speed, this step may take several minutes when executing this command for the first time)
* mvn resources:resources liquibase:update -P database-localhost -Dliquibase.password=password (This creates the table __user__ in the database __test__)
* mvn tomcat7:run (The tomcat server should now be ready to accept requests on port 8400)

#### Sample test CURL calls
* __POST__ _Request:_
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

* _Response:_
```
	'{
		"id": 1,
		"username": "swapnildipankar",
		"password": "41a87d0faca541b691f11c6d51874f37b989f0cb1b0075cce599e94f82cbbdfc",
		"name_first": "Swapnil",
		"name_middle": "M",
		"name_last": "Dipankar",
		"user_status": "PENDING",
		"user_status_code": "P",
		"date_of_birth": 14,
		"month_of_birth": 10,
		"year_of_birth": 1978,
		"created_at": 1355386501092,
		"updated_at": 1355386501092
	}'
```

* __PUT__ _Request:_
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

* _Response:_
```
	'{
		"id": 1,
		"username": "swapnildipankar",
		"password": "41a87d0faca541b691f11c6d51874f37b989f0cb1b0075cce599e94f82cbbdfc",
		"name_first": "Swapnil",
		"name_middle": "M",
		"name_last": "Dipankar",
		"user_status": "ACTIVE",
		"user_status_code": "A",
		"date_of_birth": 14,
		"month_of_birth": 10,
		"year_of_birth": 1978,
		"created_at": 1355386501092,
		"updated_at": 1355388359982
	}'
```

* __GET (By User ID)__ _Request:_
```
	curl "http://localhost:8400/MavenHelloWorld-1.0/rest/user/1"
```

* _Response:_
```
	'{
		"id": 1,
		"username": "swapnildipankar",
		"password": "41a87d0faca541b691f11c6d51874f37b989f0cb1b0075cce599e94f82cbbdfc",
		"name_first": "Swapnil",
		"name_middle": "M",
		"name_last": "Dipankar",
		"user_status": "ACTIVE",
		"user_status_code": "A",
		"date_of_birth": 14,
		"month_of_birth": 10,
		"year_of_birth": 1978,
		"created_at": 1355386501092,
		"updated_at": 1355388359982
	}'
```

* __GET (By UserName)__ _Request:_
```
	curl "http://localhost:8400/MavenHelloWorld-1.0/rest/user?username=swapnildipankar"
```

* _Response:_
```
	'{
		"id": 1,
		"username": "swapnildipankar",
		"password": "41a87d0faca541b691f11c6d51874f37b989f0cb1b0075cce599e94f82cbbdfc",
		"name_first": "Swapnil",
		"name_middle": "M",
		"name_last": "Dipankar",
		"user_status": "ACTIVE",
		"user_status_code": "A",
		"date_of_birth": 14,
		"month_of_birth": 10,
		"year_of_birth": 1978,
		"created_at": 1355386501092,
		"updated_at": 1355388359982
	}'
```

* __DELETE__ _Request:_
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

* _Response:_
```
	'{
		"id": 1,
		"username": "swapnildipankar",
		"password": "41a87d0faca541b691f11c6d51874f37b989f0cb1b0075cce599e94f82cbbdfc",
		"name_first": "Swapnil",
		"name_middle": "M",
		"name_last": "Dipankar",
		"user_status": "DELETED",
		"user_status_code": "D",
		"date_of_birth": 14,
		"month_of_birth": 10,
		"year_of_birth": 1978,
		"created_at": 1355386501092,
		"updated_at": 1355388912852
	}'
```
