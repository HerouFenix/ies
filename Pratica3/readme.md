# IES Lab03

## Index
-	[Exercises](#Exercises)
	-	[3.1](#3-1)
		-	[a)](#a)
			-	[Why use REST](#why-use-rest)
			-	[How to install the lombok plugin on IntelliJ](#why-use-rest)
			-	[How to enable annotations in IntelliJ 2017](#how-to-enable-annotations-in-intellij-2017)
			-	[How to Run PayRollApplication.java](#how-to-run-payrollapplications.java)
		-	[b)](#b)
			-	[GET Requests](#get-requests)
			-	[PUT Requests](#put-requests)
			-	[POST Requests](#post-requests)
			-	[DELETE Requests](#delete-requests)
		-	[c)](#c)
			-	[What happens to your data when the application is stopped and restarted? How could you change that behavior?](#what-happens-to-your-data-when-the-application-is-stopped-and-restarted?-how-could-you-change-that-behavior?)
		-	[Final Questions](#final-questions)
			-	[Create a layered architecture view (diagram), displaying the key abstractions in the solution, in particular: entities, repositories and REST controllers]()
			-	[Describe the role of the elements modeled in the previous point]()
			-	[Be sure to provide evidence (e.g.: screenshots, JSON results view) that you have successfully used the API to insert new entries]()
			-	[Why is that the Employee entity does not have getters and setters defined? (tip: Lombok)](why-is-that-the-employee-entity-does-not-have-getters-and-setters-defined?-(tip:-lombok))
	-	[3.2](#3-1)
		-	[d)](#d)
		-	[e)](#e)
		-	[f)](#f)
		-	[g)](#g)
		-	[h)](#h)
		-	[i)](#i)
		-	[Test your application using curl or the Postman tool. Be sure to insert and list content](#test-your-application-using-curl-or-the-postman-tool.-be-sure-to-insert-and-list-content.)
		-	[j)](#j)
		-	[Final Questions](#final-questions)
			-	[Explain the annotations @Table, @Column, @Id found in the Employee entity](#explain-the-annotations-table-column-id-found-in-the-employee-entity)
			-	[Explain the use of the annotation @AutoWired](#explain-the-use-of-the-annotation-autowired)

## Exercises
## 3.1
### a)
#### Why use REST 
> Why REST? REST embraces the precepts of the web, including its architecture, benefits, and everything else. This is no surprise given its author, Roy Fielding, was involved in probably a dozen specs which govern how the web operates.
> What benefits? The web and its core protocol, HTTP, provide a stack of features:
> -   Suitable actions (`GET`, `POST`, `PUT`, `DELETE`, …​)
>  -   Caching
>  -   Redirection and forwarding
>  -   Security (encryption and authentication)
>  
>  (...)
>  Developers are able to draw upon 3rd party toolkits that implement these diverse specs and instantly have both client and server technology at their fingertips.
>  So building on top of HTTP, REST APIs provide the means to build flexible APIs that can:
>  -   Support backward compatibility
>  -   Evolvable APIs
>  -   Scaleable services
>  -   Securable services
>  -   A spectrum of stateless to stateful services
>  
>  What’s important to realize is that REST, however ubiquitous, is not a standard, _per se_, but an approach, a style, a set of _constraints_ on your architecture that can help you build web-scale systems.

#### How to install the lombok plugin on IntelliJ
  1. Click CTRL+Alt+S
  2. Navigate to **Plugins**
  3. Search for lombok and click Install
  4. Restart IntelliJ

#### How to enable annotations in IntelliJ 2017
1. Go to _Settings (CTRL+Alt+S) > Build, Execution, Deployment > Compiler > Annotation Processors_
2. Tick _Enable annotation processing_

#### How to Run PayRollApplication.java 
1. In the Project's root, go to _rest > src >  main > java > payroll > PayRollApplication_
2. Right click and hit Run
    

### b)
#### GET requests
By opening Postman and querying the page with GET requests we get returned things like:
- URL: `http://localhost:8080/employees` 
- Type: GET

![```{
    "_embedded": {
        "employeeList": [
            {
                "id": 1,
                "name": "Bilbo Baggins",
                "role": "burglar",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/employees/1"
                    },
                    "employees": {
                        "href": "http://localhost:8080/employees"
                    }
                }
            },
            {
                "id": 2,
                "name": "Frodo Baggins",
                "role": "thief",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/employees/2"
                    },
                    "employees": {
                        "href": "http://localhost:8080/employees"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/employees"
        }
    }
}```](https://i.imgur.com/Ef2NcvR.png)

- URL: `http://localhost:8080/employees/1`
- Type: GET

![```{
    "id": 1,
    "name": "Bilbo Baggins",
    "role": "burglar",
    "_links": {
        "self": {
            "href": "http://localhost:8080/employees/1"
        },
        "employees": {
            "href": "http://localhost:8080/employees"
        }
    }
}```](https://i.imgur.com/JS0p6EJ.png)



#### PUT requests
We can use PUT requests to update employee entries like so:

- URL: `http://localhost:8080/employees/1` 
- Type: PUT
- Body:  
 - Type:**RAW**
		- **JSON (application/json)**  w
	- Content: `{"id":1,"name":"DS","role":"Rey"}`

![PUT Request](https://i.imgur.com/YcKONuT.png)
And just like that we updated the employee whose ID is 1

#### POST requests
We can use POST requests to insert new entries to the Employees Table like so:
- URL: `http://localhost:8080/employees/` 
- Type: POST
- Body:
	- Type:**RAW**
		- **JSON (application/json)**  w
	- Content: `{"name":"Mendrocas","role":"Pussycólogo"}`

![POST request](https://i.imgur.com/TYKevwF.png)
#### DELETE requests
We can use DELETE requests to delete entries from the Employees Table like so:
- URL: `http://localhost:8080/employees/2` 
- Type: DELETE

![enter image description here](https://i.imgur.com/2MRKqPo.png)

And now if we repeat the GET request on all employees we can see that the employee whose ID was 2 has been deleted:

![enter image description here](https://i.imgur.com/O6Hwrp2.png)

### c)
#### What happens to your data when the application is stopped and restarted? How could you change that behavior?

When the application gets restarted all the changes we made by sending requests to the REST API get rolled back, as proven by the fact that invoking a GET request on all employees returns the virgin, unchanged list of employees:
![All our changes were rolled back](https://i.imgur.com/MGgRa0m.png)
	The reason as to why this is using is due to the fact that everytime we run the REST API, the method in the **LoadDatabase** class gets called, which inserts the 2 first employees into our database. All in all, what's actually happening is that our DB is coupled to our current instance of the REST, so our data isn't actually stored in any meaningful DB, hence why it gets deleted. To solve this we could implement a database that's decoupled from the REST API, meaning that it's independent to it. All the REST would do would be inserting new data into that DB, which would function parallel, i.e, separate from it. Alternatively, a less elegant and viable solution would be to save all our changes to a FILE, and everytime we reload the Database (by reloading the REST), read from it to insert it's data into our current instance.
	
  ### Final Questions
 #### Create a layered architecture view (diagram), displaying the key abstractions in the solution, in particular: entities, repositories and REST controllers
    
![arquitetura](https://i.imgur.com/U2XnZoE.png)

 #### Describe the role of the elements modeled in the previous point
- **Entities**:
	- _Employee.java_: 
		-  Class used to represent an employee. 
		- Contains fields like name, role and ID, and constructors.
		- Also has some SpringBoot annotations that have the following functions:
			 -   `@Data` is a Lombok annotation to create all the getters, setters, `equals`, `hash`, and `toString` methods, based on the fields.
			-   `@Entity` is a JPA annotation to make this object ready for storage in a JPA-based data store.
			-   `id`, `name`, and `role` are the attribute for our domain object, the first being marked with more JPA annotations to indicate it’s the primary key and automatically populated by the JPA provider.
			-   a custom constructor is created when we need to create a new instance, but don’t yet have an id.
	- _PayrollApplication.java_:
		- Contains both a static void main function and the @SpringBootApplication annotation, which is used to pull in SpringBoot's component scanning, autoconfiguration and property support.	
	- _LoadDatabase.java_:
		- Class loaded automatically by SpringBoot. All CommandLineRunner beans are run once the application context is loaded. This runner will request a copy of the EmployeeRepository and use it to create two entities (storing them).
		- Note the @Slf4j Lombok annotation used to atuocreate an Slf4j-based LoggerFactory (allowing us to log our Employee Instances)	

	- _EmployeeNotFoundException.java & EmployeeNotFoundAdvice.java_ and :
		- Pages used to treat an employee not found error that might be generated by any request.
		- Render a 404 error page with some advice on what went wrong

- **Repositories** (interfaces with methods supporting reading, updating, deleting, and creating records against a back end data store.):
	- _EmployeeRepository.java_:
		- Extends Spring Data JPA's JpaRepository, specifying the domain type as Employee and the id type as Long.
		- Basically used to store and provide Employee information
		- Supports:
			- Creating new Employee instances
			- Updating existing Employee instances
			- Deletion
			- Searching
	
- **Controllers**
	- _EmployeeController.java_:
		- Used to offer the manipulation of data and indicate the data returned by each of the HTTP methods - GET, POST, PUT and DELETE -
		- Basically, from a very simplified point of view, makes the mapping between the HTTP Request and the Repository method that's meant to handle said request.

 #### Be sure to provide evidence (e.g.: screenshots, JSON results view) that you have successfully used the API to insert new entries.
![enter image description here](https://i.imgur.com/Ef2NcvR.png)![enter image description here](https://i.imgur.com/JS0p6EJ.png)
![POST request](https://i.imgur.com/TYKevwF.png)![enter image description here](https://i.imgur.com/2MRKqPo.png)![All our changes were rolled back](https://i.imgur.com/MGgRa0m.png)
 #### Why is that the Employee entity does not have getters and setters defined? (tip: Lombok)
 
 The Employee entity has the `@Data` annotation. This is a Lombok annotation that's used to create all getters, setters, equals, hash and toString methods based on the entity's fields. So basically, the entity doesn't have any getters and setters defined because those are automatically and independently generated by Lombok


## 3.2
### d)
`sudo docker run --name mysql5 -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=demo -e MYSQL_USER=demo -e MYSQL_PASSWORD=password -p 3306:3306 -d mysql/mysql-server:5.7`

This will create and start a docker container running a mysql5 server on the port 3306.
It will also create a database called `demo` and a user for that db - `demo` - whose password is `password`

### e)
Follow the tutorial over at https://www.javaguides.net/2018/09/spring-boot-2-jpa-mysql-crud-example.html

This is what the SpringBoot Initialzr should look like:

![enter image description here](https://i.imgur.com/5M3x5ll.png)
### f)
Employee.java
```
package net.guides.springboot2.springboot2jpacrudexample.model;  
  
import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import javax.persistence.Table;  
  
@Entity  
@Table(name = "employees")  
  
public class Employee {  
  
    private long id;  
 private String firstName;  
 private String lastName;  
 private String emailId;  
  
 public Employee(){  
  
    }  
  
    public Employee(String firstName, String lastName, String emailId){  
        this.firstName = firstName;  
 this.lastName = lastName;  
 this.emailId = emailId;  
  }  
  
    @Id  
 @GeneratedValue(strategy = GenerationType.AUTO)  
        public long getId(){  
        return id;  
  }  
    public void setId(long id){  
        this.id = id;  
  }  
  
    @Column(name = "first_name", nullable =  false)  
    public String getFirstName(){  
        return firstName;  
  }  
    public void setFirstName(String firstName){  
        this.firstName = firstName;  
  }  
  
    @Column(name = "last_name", nullable =  false)  
    public String getLastName(){  
        return lastName;  
  }  
    public void setLastName(String lastName){  
        this.lastName = lastName;  
  }  
  
    @Column(name = "email_address", nullable =  false)  
    public String getEmailId(){  
        return emailId;  
  }  
    public void setEmailId(String emailId){  
        this.emailId = emailId;  
  }  
  
    @Override  
  public String toString() {  
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId  
  + "]";  
  }  
}
```

### g)
Employee.java
```
package net.guides.springboot2.springboot2jpacrudexample.repository;  
  
import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.stereotype.Repository;  
  
import net.guides.springboot2.springboot2jpacrudexample.model.Employee;  
  
@Repository  
public interface EmployeeRepository extends JpaRepository<Employee, Long>{  
  
}
```

### h)
EmployeeController.java
```
package net.guides.springboot2.springboot2jpacrudexample.controller;  
  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
  
import javax.validation.Valid;  
  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.http.ResponseEntity;  
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.PutMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;  
  
import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;  
import net.guides.springboot2.springboot2jpacrudexample.model.Employee;  
import net.guides.springboot2.springboot2jpacrudexample.repository.EmployeeRepository;  
import org.springframework.web.client.ResourceAccessException;  
  
@RestController  
@RequestMapping("/api/v1")  
  
public class EmployeeController {  
    @Autowired  
  private EmployeeRepository employeeRepository;  
  
  @GetMapping("/employees")  
    public List<Employee> getAllEmployees(){  
        return employeeRepository.findAll();  
  }  
  
    @GetMapping("/employees/{id}")  
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)  
        throws ResourceNotFoundException {  
        Employee employee = employeeRepository.findById(employeeId)  
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));  
 return ResponseEntity.ok().body(employee);  
  }  
  
    @PostMapping("/employees")  
    public Employee createEmployee(@Valid @RequestBody Employee employee){  
        return employeeRepository.save(employee);  
  }  
  
    @PutMapping("/employees/{id}")  
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,  
  @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {  
  
        Employee employee = employeeRepository.findById(employeeId)  
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));  
  
  employee.setEmailId((employeeDetails.getEmailId()));  
  employee.setLastName((employeeDetails.getLastName()));  
  employee.setFirstName((employeeDetails.getFirstName()));  
  
 final Employee updatedEmployee = employeeRepository.save(employee);  
  
 return ResponseEntity.ok(updatedEmployee);  
  }  
  
    @DeleteMapping("/employees/{id}")  
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)  
            throws ResourceNotFoundException {  
        Employee employee = employeeRepository.findById(employeeId)  
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));  
  
  employeeRepository.delete(employee);  
  Map<String, Boolean> response = new HashMap<>();  
  response.put("deleted", Boolean.TRUE);  
 return response;  
  }  
}
```

### i)
application.properties
```
## MySQL  
spring.datasource.url=jdbc:mysql://localhost:3306/demo  
spring.datasource.username=demo  
spring.datasource.password=password  
  
#`hibernate_sequence' doesn't exist  
spring.jpa.hibernate.use-new-id-generator-mappings=false  
  
# drop n create table, good for testing, comment this in production  
spring.jpa.hibernate.ddl-auto=create
```

Code taken from https://www.mkyong.com/spring-boot/spring-boot-spring-data-jpa-mysql-example/

### Test your application using curl or the Postman tool. Be sure to insert and list content.
![enter image description here](https://i.imgur.com/JsQeYEB.png)
### j)
EmployeeRepository.java
```
@Repository  
public interface EmployeeRepository extends JpaRepository<Employee, Long>{  
    public Employee findByEmailId(String emailId);  
}
```

EmployeeController.java
```
@GetMapping("/employees?email={email}")  
public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable(value = "email") String employeeEmail)  
        throws ResourceNotFoundException {  
    Employee employee = employeeRepository.findByEmailId(employeeEmail);  
 return ResponseEntity.ok().body(employee);  
}
```

![enter image description here](https://i.imgur.com/iCBzYBW.png)

### Final Questions
#### Explain the annotations @Table, @Colunm, @Id found in the Employee entity.
-	**@Table**
	> Specifies the primary table for the annotated entity. Additional tables may be specified using [`SecondaryTable`](https://www.objectdb.com/api/java/jpa/SecondaryTable "Annotation in javax.persistence") or [`SecondaryTables`](https://www.objectdb.com/api/java/jpa/SecondaryTables "Annotation in javax.persistence") annotation. 
	> If no `Table` annotation is specified for an entity class, the default values apply.

	-	Allows you to specify the details of the table that will be used to persist the entity in the database.
	-	So when we use `@Table(name = "employees")`, we're basically saying that the entity will be saved on the table "employees" within our MySQL database, allowing the data to persist.

-	**@Column**
	> Is used to specify the mapped column for a persistent property or field. 
	>If no `Column` annotation is specified, the default values apply.
	
	-	Allows you to access a specific column from a table, permitting you to access a specified filed instead of having to access all of them.
	-	So when we use `@Column(name = "first_name", nullable = false)`, we're accessing ONLY the column "first_name" from our "employees" table.

-	**@Id**
	> Every entity object that is stored in the database has a primary key. 
	> Once assigned, the primary key cannot be modified. It represents the entity object as long as it exists in the database.
	
	-	Allows you to tag a certain field as being the object's primary key (i.e what identifies it)
	-	So when we use `@Id  
@GeneratedValue(strategy = GenerationType.AUTO)`, we're creating an auto-generated primary key for our Employee

#### Explain the use of the annotation @AutoWired

> This annotation allows Spring to resolve and inject collaborating beans into your bean.
> The annotation can be used directly on **properties**, therefore eliminating the need for getters and setters.
> The _@Autowired_ annotation can be used on **setter methods**. 
> The _@Autowired_ annotation can also be used on **constructors**.
> Spring expects _@Autowired_ dependencies to be available when the dependent bean is being constructed. If the framework cannot resolve a bean for wiring, it will throw the below-quoted exception and prevent the Spring container from launching successfully.
> By default, Spring resolves _@Autowired_ entries by type. If more than one beans of the same type are available in the container, the framework will throw a fatal exception indicating that more than one bean is available for autowiring.
> 
Taken from https://www.baeldung.com/spring-autowire

In our project we use the @AutoWired annotation on our **EmployeController** to tag our **EmployeeRepository**'s instance, like so:
```
@Autowired  
private EmployeeRepository employeeRepository;
```
So basically what we're doing is using the @AutoWIred annotation on a property, hence eliminating the need to manually use getters and setters. SpringBoot will look for and inject _employeeRepository_ during the creation of our EmployeeController doing all of that nasty work for us.
