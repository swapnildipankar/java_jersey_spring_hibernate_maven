Starter project to create RESTful WS using Java, Jersey WS, Spring, Hibernate, Maven. Sample code for integrating with Hibernate/MySQL and MongoDB/NoSQL.<br /><br />
__Note:__ _The code is just a framework and does not do anything meaningful. Developers will have to write the actual functionality to make use of the framework._

#### Prerequisite packages
__Note:__ _The project has been tested on several versions of Mac OSX and Ubuntu Linux, but can work on any other platform as long as the packages mentioned in this section are available on the platform. Ensure that the user has sudo access to the host_
* __OpenJDK SDK__ (run command "sudo apt-get install openjdk-6-jdk", if not present)
* __Maven__ (run command "sudo apt-get install maven2", if not present)
* __Curl__ (run command "sudo apt-get install curl", if not present)
* __MySQL Server__ (run command "sudo apt-get install mysql-server", if not present)
* __Vim (optional)__ (run command "sudo apt-get install vim", if not present)
* __IntelliJ Idea Community Edition (optional)__ (download IDE from the IntelliJ website)

#### Steps to compile, install and run
Run the following commands in the given sequence:
* git clone https://github.com/swapnildipankar/java_jersey_spring_hibernate_maven.git
* cd java_jersey_spring_hibernate_maven
* mvn clean install
* mvn tomcat7:run (The tomcat server should now be ready to accept requests on port 8400)

#### Sample test CURL calls
* GET:
```
	curl "http://localhost:8400/MavenHelloWorld-1.0/rest/user/1234567890"
```

* POST:
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

* PUT:
```
	curl -i -H "Content-Type: application/json" -X PUT -d \
	'{
		"id":"1234567890",
		"username":"swapnildipankar",
		"password":"ɹɐʞuɐdıD lıudɐʍS",
		"name_first":"Swapnil",
		"name_middle":"M",
		"name_last":"Dipankar",
		"date_of_birth":14,
		"month_of_birth":10,
		"year_of_birth":1978
	}' 'http://localhost:8400/MavenHelloWorld-1.0/rest/user/1234567890'
```

* DELETE:
```
	curl -i -H "Content-Type: application/json" -X DELETE -d \
	'{
		"id":"1234567890",
		"username":"swapnildipankar",
		"password":"ɹɐʞuɐdıD lıudɐʍS",
		"name_first":"Swapnil",
		"name_middle":"M",
		"name_last":"Dipankar",
		"date_of_birth":14,
		"month_of_birth":10,
		"year_of_birth":1978
	}' 'http://localhost:8400/MavenHelloWorld-1.0/rest/user/1234567890'
```
