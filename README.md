Archetype starter project to create RESTful WS using Java, Jersey WS, Spring, Hibernate, Maven, Liquibase. Sample code for integrating with Hibernate/MySQL and MongoDB/NoSQL.<br /><br />
__Note:__ _This is a skeletal archetype framework. Using the sample code, developers can send a sample CURL call (see section "Sample test CURL calls" below) to the running web service and see the changes propagated all the way to the databases. There are, currently, two webservice end points, /user and /purchase for demonstrating MySQL and MongoDB respectively. Developers will have to write the actual functionality to make use of the framework._

* __New:__ _Support for MongoDB_
* __Coming Up:__ _Support for Cassandra_
* __Coming Up:__ _Support for NuoDB_

#### Developers:
* __Parth Parekh__ - parthparekh at gmail dot com
* __Swapnil Dipankar__ - dswapnil at gmail dot com

#### Technologies used in the project
* __Java__
* __Jersey WS Framework__
* __Spring Framework__
* __Hibernate__
* __Maven__
* __Liquibase__
* __MySQL__
* __Mongo DB__

#### Prerequisite packages
__Note:__ _The project has been tested on several versions of Mac OSX and Ubuntu Linux, but can work on any other platform as long as the packages mentioned in this section are available on the platform. Ensure that the user has sudo access to the host_
* __OpenJDK SDK__ (run command _sudo apt-get install openjdk-6-jdk_, if not present) __Note:__ _Sun JDK can be used instead of OpenJDK without impacting the functionality of the framework_
* __Git__ (run command _sudo apt-get install git_ or _sudo apt-get install git-core_, if not present)
* __Maven__ (run command _sudo apt-get install maven2_, if not present)
* __Curl__ (run command _sudo apt-get install curl_, if not present)
* __MySQL Server__ (run command _sudo apt-get install mysql-server_, if not present)
* __MongoDB__ (run command _sudo apt-get install mongodb_, if not present)
* __Vim (optional)__ (run command _sudo apt-get install vim_, if not present)
* __IntelliJ Idea Community Edition (optional)__ (download IDE from http://www.jetbrains.com/idea/download/index.html)
* __Cocoa REST Client (optional, this is only for Mac OSX)__ (download from https://code.google.com/p/cocoa-rest-client/)

#### Prerequisite MySQL database and tables
* Ensure that MySQL is running and has the __root__ password as __password__ (Else, modify the __hibernate.cfg.xml__ file with correct database credentials)
* Ensure that database __test__ exists (Else, create a database __test__ with the access credentials specified in __hibernate.cfg.xml__ file)

#### Prerequisite MongoDB database
* Ensure that MongoDB is running (run command _mongod --master --dbpath path_to_directory_that_will_contain_database_data_)
* Ensure that database __purchase__ has user with credentials (purchase_user, purchase4user) (Else, modify the credentials in file __resources/mongodb/mongo-config.json__)

#### Steps to compile, install and run code
Run the following commands in the given sequence:
* git clone https://github.com/swapnildipankar/java_jersey_spring_hibernate_maven.git
* cd java_jersey_spring_hibernate_maven
* mvn clean install (Depending on the connection speed, this step may take several minutes when executing this command for the first time)
* mvn resources:resources liquibase:update -P database-localhost -Dliquibase.password=password (This creates the table __user__ in the database __test__)
* mvn tomcat7:run (The tomcat server should now be ready to accept requests on port 8400)

#### Sample test CURL calls (http://localhost:8400/demows/user - this uses MySQL for persistence)
* __POST__ _Request:_
```
	curl -i -H "Content-Type: application/json" -X POST -d \
	'{
		"username":"johndoe",
		"password":"ǝopuɥoɾ",
		"name_first":"John",
		"name_middle":"M",
		"name_last":"Doe",
		"date_of_birth":14,
		"month_of_birth":10,
		"year_of_birth":1978
	}' 'http://localhost:8400/demows/user'
```

* _Response:_
```
	'{
		"id": 1,
		"username": "johndoe",
		"password": "41a87d0faca541b691f11c6d51874f37b989f0cb1b0075cce599e94f82cbbdfc",
		"name_first": "John",
		"name_middle": "M",
		"name_last": "Doe",
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
		"username":"johndoe",
		"password":"ǝopuɥoɾ",
		"name_first":"John",
		"name_middle":"M",
		"name_last":"Doe",
		"user_status":"ACTIVE",
		"date_of_birth":14,
		"month_of_birth":10,
		"year_of_birth":1978
	}' 'http://localhost:8400/demows/user/1'
```

* _Response:_
```
	'{
		"id": 1,
		"username": "johndoe",
		"password": "41a87d0faca541b691f11c6d51874f37b989f0cb1b0075cce599e94f82cbbdfc",
		"name_first": "John",
		"name_middle": "M",
		"name_last": "Doe",
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
	curl 'http://localhost:8400/demows/user/1'
```

* _Response:_
```
	'{
		"id": 1,
		"username": "johndoe",
		"password": "41a87d0faca541b691f11c6d51874f37b989f0cb1b0075cce599e94f82cbbdfc",
		"name_first": "John",
		"name_middle": "M",
		"name_last": "Doe",
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
	curl 'http://localhost:8400/demows/user/username/johndoe'
```

* _Response:_
```
	'{
		"id": 1,
		"username": "johndoe",
		"password": "41a87d0faca541b691f11c6d51874f37b989f0cb1b0075cce599e94f82cbbdfc",
		"name_first": "John",
		"name_middle": "M",
		"name_last": "Doe",
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
		"username":"johndoe",
		"password":"ǝopuɥoɾ",
		"name_first":"John",
		"name_middle":"M",
		"name_last":"Doe",
		"date_of_birth":14,
		"month_of_birth":10,
		"year_of_birth":1978
	}' 'http://localhost:8400/demows/user/1'
```

* _Response:_ _[Notice that the user gets marked as 'DELETED' and is not removed from the database]_
```
	'{
		"id": 1,
		"username": "johndoe",
		"password": "41a87d0faca541b691f11c6d51874f37b989f0cb1b0075cce599e94f82cbbdfc",
		"name_first": "John",
		"name_middle": "M",
		"name_last": "Doe",
		"user_status": "DELETED",
		"user_status_code": "D",
		"date_of_birth": 14,
		"month_of_birth": 10,
		"year_of_birth": 1978,
		"created_at": 1355386501092,
		"updated_at": 1355388912852
	}'
```

#### Sample test CURL calls (http://localhost:8400/demows/purchase - this uses MongoDB for persistence)
* __POST__ _Request:_
```
    curl -i -H "Content-Type: application/json" -X POST -d \
    '{
        "billing_address": {
            "first_name" : "Travis",
            "city" : "San Franciso",
            "postal_code" : "94000",
            "street_2" : "Street 2",
            "last_name" : "John",
            "street_1" : "Street 1",
            "country_code" : "US",
            "phone_number" : "415-415-1000",
            "name" : "Travis John",
            "state" : "CA"
        },
        "shipping_address": {
            "first_name" : "Johnny",
            "city" : "San Antonio",
            "postal_code" : "32000",
            "street_2" : "Street 2",
            "last_name" : "Cash",
            "street_1" : "Street 1",
            "country_code" : "US",
            "phone_number" : "420-420-1000",
            "name" : "Johnny Cash",
            "state" : "TX"
        },
        "billing_card": {
            "card_type" : "AMERICAN_EXPRESS",
            "card_number" : "kIXI51g+t88DJjaNguPMEQ==",
            "security_code" : "1004",
            "expiration_month" : 3,
            "expiration_year" : 2020,
            "encryption_type" : "sha512"
        },
        "user_ip_address": "127.127.127.127",
        "email": "test@test.com",
        "invoice_number": "INVOICE123",
        "client_id": "CLIENT124",
        "user_id": "PERSON123",
        "order_number": "WON123",
        "create_date": "MAR-21-2013",
        "transaction": {
            "currency_code" : "USD",
            "transaction_amount" : "1099.99"
        }
    }' 'http://localhost:8400/demows/purchase'
```

* _Response:_
```
	'{
       "id" : "5159d6d9456668495a2de972",
       "order_number" : "WON123",
       "create_date" : "MAR-21-2013",
       "user_ip_address" : "127.127.127.127",
       "transaction" : {
         "currency_code" : "USD",
         "transaction_amount" : "1099.99"
       },
       "invoice_number" : "INVOICE123",
       "user_id" : "PERSON123",
       "billing_address" : {
         "first_name" : "Travis",
         "city" : "San Franciso",
         "postal_code" : "94000",
         "street_3" : null,
         "street_2" : "Street 2",
         "last_name" : "John",
         "street_1" : "Street 1",
         "country_code" : "US",
         "phone_number" : "415-415-1000",
         "name" : "Travis John",
         "state" : "CA"
       },
       "shipping_address" : {
         "first_name" : "Johnny",
         "city" : "San Antonio",
         "postal_code" : "32000",
         "street_3" : null,
         "street_2" : "Street 2",
         "last_name" : "Cash",
         "street_1" : "Street 1",
         "country_code" : "US",
         "phone_number" : "420-420-1000",
         "name" : "Johnny Cash",
         "state" : "TX"
       },
       "client_id" : "CLIENT124",
       "billing_card" : {
         "card_type" : "AMERICAN_EXPRESS",
         "card_number" : "kIXI51g+t88DJjaNguPMEQ==",
         "security_code" : "1004",
         "expiration_month" : "3",
         "expiration_year" : "2020",
         "encryption_type" : "sha512"
       },
       "email" : "test@test.com"
     }'
```
