### Car Rental Application

##### Description
The task involves creating a public interface where users can:

* search among the cars

* reserve a car by providing its details. (:warning: A car cannot be reserved twice during the same period.)

##### Tasks to Implement and Their Points
_Search Interface_

1. On the main page of the public interface, the user selects a **_-from_** and a **_-to_** date from a _daterange picker_. (20 points) +

2. This triggers a request to the server. (10 points) +

   In the response, a **list** of available cars during that period is returned, including images and daily rates. (30 points) +

_Reservation Management_

3. Clicking on a selected car opens a form where the user provides their details: (50 points) +

    * Name,

    * Email address,

    * Address,

    * Phone number,

    * Number of days to be reserved,

    * Total reservation cost (dependent on the number of reserved days!)

4. Pressing a submit button finalizes the order. (10 points)  +

_Tests_

5. Minimum 50% test coverage (30 points)

#### Admin Use-case `max. 150 points`

##### Task Description

Admin interface for minimal administration purposes.

* No need for a login interface! Admin data can be provided from a `config`, and we automatically have admin rights on the `/admin` path.

On the admin page, we want to:

* see the reservations in a list

* edit cars (add new ones, but **do not delete**; deactivate instead! :)

##### Tasks to Implement and Their Points

_Display Reservation Data_

5. Admin login (from config), with admin privileges (20 points)

6. Interface to view reservations (10 points)

7. Service to handle reservations (20 points)

_Edit Cars_

6. Edit existing cars (25 points) - without images

7. Add new cars (25 points) - without images

8. Manage image uploads for editing and adding interfaces (20 points)

9. Deactivate cars (:warning: handling existing reservations!)

_Tests_

10. Minimum 50% test coverage (30 points)

#### Bonus Tasks `max. 50 points`

11. As a bonus, create a REST API to query available cars and submit a reservation. (20 points)

12. Double bonus, use Docker plugin, create Docker containers, separate containers for the database too, (20 points)

13. All Docker containers created in point 12 should be in a common network (10 points)

### Recommended Technology Stack:

* [Spring Boot 3.1.3](https://spring.io/projects/spring-boot)

* [Spring MVC](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#spring-web)

* [Spring Security](https://spring.io/projects/spring-security)

* Database engine: PostgreSQL

* Frontend:

    * HTML5

    * Bootstrap 4.5.2

    * [Thymeleaf](https://www.thymeleaf.org/)
