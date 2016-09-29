# LoopMe

### Problem Statement
Running and biking is an effective form of travel from A to B and many people run and bike, more so biking, as a means from one location to another. However, many runners and bikers, like myself, run and bike not only to travel but as a means of exercise as well. When exercising, people tend to go in a loop from A to A and stop where they started. Currently, their are programs out there, like MapMyRun, that allows someone to create a loop by clicking on various streets they would like to travel on. The problem is, many runners and bikers want to go in a loop with a specific distance. Google Maps, currently, does not allow one to generate a looping route and, sure, someone could use MapMyRun to do this but having to constantly modify the route until the specific distance is achieved is tedious. This is where LoopMe come in.

LoopMe will be a web application that will allow people to input a starting location and a specified distance which will be used to generate a variety of looping routes for a user to choose from.

###Features
* Generating multiple loops for a specified distance and starting location
* Creating an account
* Setting a home start location
* Finding start location from computer network
* Exporting route information to Google Maps
* Sharing route via email and social media
* Saving routes to accounts
* Custom naming of routes

### Technologies
* Database (MySQL/Firebase and Hibernate)
  * Store users
  * Store accounts
  * Store saved routes
  * Store saved legs of routes
  * Store addresses
* Independent Research Topic
  * Bootstrap
  * Firebase (possibly)
  * Angular.js (possibly later on)
* Web Services and APIs
  * Google Maps Geocoding API
  * Google Maps Roads API
  * Google Maps Distance Matrix API
  * Google Maps Directions API
  * Google Maps Elevation API
* Logging
  * Log4J
* Unit Testing
  * JUnit Tests
  * At least 60% code coverage


### Roles
* Public
  * Input starting location
  * Input distance
  * Generate looping routes
  * Create account (Sign Up)
* User
  * Access to all features of Public role
  * Sign In / Log Out
  * View account information
    * Email (username)
    * Home location (Auto start location)
    * Account picture
  * Set account information
    * Change email (username)
    * Change account picture
    * Change password
    * Change home location
  * Delete Account (their own)
  * Save route information to account
  * View routes

* Admin
  * Access to all features of User role
  * Create, read, update, delete all data stored in database

### Project Documents
* [Time Log] (https://github.com/goonterknutso/LoopMe/tree/master/project_documents/time_log.md)
* [Project Plan] (https://github.com/goonterknutso/LoopMe/tree/master/project_documents/project_plan.md)
* [Screen Design] (https://github.com/goonterknutso/LoopMe/tree/master/project_documents/design/screens)
* [Database Design] (https://github.com/goonterknutso/LoopMe/tree/master/project_documents/design/database)
* [Code Reviews] (https://github.com/goonterknutso/LoopMe/tree/master/project_documents/code_reviews)
* [Flow Diagram] (https://github.com/goonterknutso/LoopMe.git)
