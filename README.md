java_jersey_spring_hibernate_maven
==================================
Starter project to create RESTful WS using Java, Jersey WS, Spring, Hibernate, Maven.
Sample code for integrating with Hibernate/MySQL and MongoDB/NoSQL.

Note: The code is just a framework and does not do anything meaningful.
Developers will have to write the actual functionality to make use of the framework.

Steps to compile, install and run
=================================
Run the following commands in the given sequence:
1. git clone https://github.com/swapnildipankar/java_jersey_spring_hibernate_maven.git
2. cd java_jersey_spring_hibernate_maven
3. mvn clean install
4. mvn tomcat7:run

Sample test CURL calls
======================
1. GET:
curl "http://localhost:8400/MavenHelloWorld-1.0/rest/user/1234567890"

2. POST:
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

3. PUT:
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

4. DELETE:
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