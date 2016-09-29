# Design/Code Review 3

## Project: Programming Language Translator

### Developer: Vang Lee

#### Reviewer: Gunther Knutson

#### [Project Link] (https://github.com/vlee1/Programming-Language-Translator)

|Category|Criteria|Rating/Comments|
|--------|---------|---------------|
|**Problem Statement**|Does it exist?| Y |
||Does the problem statement accurately describe project purpose?| Y |
||Is the problem statement professional? Think of prospective employers viewing this as part of the developer's portfolio.| Y |
||What is good?| Problem statement is concise and to the point.  |
||What could be improved?| You could potential add why you would like to do this project (why you're invested in it). |
|**Design Documentation**|Does it exist?| Y |
||Is the navigation/flow through the application logical and easy to use?| Y |
||Is the order in which the fields are displayed and form fields entered logical and easy to use?| Y |
||What data is missing?| N/A |
||Is there data that is not used?| N |
||What is good?| Screens are well designed and good!|
||What could be improved?| N/A |
|**Data model**|Does it exist?| Y |
||Is everything on the screens represented in the model?| Y |
||Does the model represent good database design? | Y |
||What is good?| Relations are good. |
||What could be better?| Implement what Aaron brought up in class with Inbox Folders as a type to remove Trash table. |
|**Additional design documents**| | |
|**Application structure in IntelliJ**|Does it exist?| Y |
||Is the structure correct for a Maven project?| Y |
||Are packages and classs appropriately named? | Y |
||Other comments/notes?| N/A |
|**JSPs**|Do they exist?| Y, only index.jsp |
||Is templating used (for example, header.jsp, footer.jsp, etc.)?| N |
||Is there business logic mixed in the JSPs?| N |
||CSS?| Y |
||Other comments/notes?| N/A |
|**Entities/DAOs/Controllers**|Do they exist?| Y |
|**Java code quality**|Are methods single-purpose?| Y |
||Are classes appropriately-sized classes (no monster classes)?| Y |
||Are the same lines of code repeated at all?| N |
||Do any classes perform very similar functions that could be candidates for super/subclass relationships?| N |
||Are any values hard-coded that should be in a properties file?| N |
||Are variable names descriptive?| Y |
||Are there many branches or loops that could be simplified or broken up into smaller methods?| N |
||Do the DAOs use Hibernate? No hard-coded sql!| No! |
||Other comments/notes?| Need to add in Hibernate! |
|**Logging**|Has log4J been added?| N |
||Are there logging statements in the code?| N/A |
||Are appropriate logging levels used? Info, debug, error, for example.| N/A |
||Are there any System.out.printlns in the code?| N/A |
||Other comments/notes?| Need to add in log4J |
|**Unit Tests**|Do they exist?| N |
||Do the tests pass?| N/A |
||What is the current code coverage?| N/A |
||Is each test truly a unit test or are they functional tests?| N/A |
||Other comments/notes?| Need to add in testing. |
|**Web Service/API integration**|Has a web service/api been selected? | Google Closure Compiler Service API or Ideone API |
||What web services/apis might work well with this application?| Messaging API |
|**Independent research topic**| Has a topic been selected?| Bootstrap |
||What topic/s might fit well in this application?| N/A |
