# IES Lab03

## Setup


## Exercises
## 3.1
### a)
#### Why use REST ?
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

#### How to Run PayRollApplication.java ?
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
#### What happens to your data when the application is stopped and restarted? How could you change that behavior??

When the application gets restarted all the changes we made by sending requests to the REST API get rolled back, as proven by the fact that invoking a GET request on all employees returns the virgin, unchanged list of employees:
![All our changes were rolled back](https://i.imgur.com/MGgRa0m.png)
	The reason as to why this is using is due to the fact that everytime we run the REST API, the method in the **LoadDatabase** class gets called, which inserts the 2 first employees into our database. All in all, what's actually happening is that our DB is coupled to our current instance of the REST, so our data isn't actually stored in any meaningful DB, hence why it gets deleted. To solve this we could implement a database that's decoupled from the REST API, meaning that it's independent to it. All the REST would do would be inserting new data into that DB, which would function parallel, i.e, separate from it. Alternatively, a less elegant and viable solution would be to save all our changes to a FILE, and everytime we reload the Database (by reloading the REST), read from it to insert it's data into our current instance.
	
  ### Final Questions
 #### Create a layered architecture view (diagram), displaying the key abstractions in the solution, in particular: entities, repositories and REST controllers.
    

 #### Describe the role of the elements modeled in the previous point.
- Entities:
	- Employee.java:**RAW**

- Repositories:
	- EmployeeRepository.java:**RAW**







