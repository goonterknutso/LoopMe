# Design/Code Review 1

## Project: IRV (Instant Runoff Voting)

### Developer: Aaron Anderson

#### Reviewer: Gunther Knutson

#### [Project Link] (https://github.com/irvingmike/IRV-Project)

|Category|Criteria|Rating/Comments|
|--------|---------|---------------|
|**Problem Statement**|Does it exist?| Y |
||Does the problem statement accurately describe project purpose?| Y |
||Is the problem statement professional? Think of prospective employers viewing this as part of the developer's portfolio.| Y |
||What is good?| The overall idea is great and has applications beyond elections. |
||What could be improved?| N |
|**Design Documentation**|Does it exist?| Y |
||Is the navigation/flow through the application logical and easy to use?| Y |
||Is the order in which the fields are displayed and form fields entered logical and easy to use?| Y |
||What data is missing?| N/A |
||Is there data that is not used?| N |
||What is good?| Screens are well laid out and looking good! |
||What could be improved?| N/A |
|**Data model**|Does it exist?| Y |
||Is everything on the screens represented in the model?| Y |
||Does the model represent good database design? | Y |
||What is good?| Relations between tables make sense. No extraneous information will be stored. |
||What could be better?| N/A |
|**Additional design documents**| | |
|**Application structure in IntelliJ**|Does it exist?| Y |
||Is the structure correct for a Maven project?| Y |
||Are packages and classs appropriately named?   | Y |
||Other comments/notes?| N/A |
|**JSPs**|Do they exist?| N |
||Is templating used (for example, header.jsp, footer.jsp, etc.)?| N/A |
||Is there business logic mixed in the JSPs?| N/A |
||CSS?| N/A |
||Other comments/notes?| No front end JSPs done, lots of back end done though :)|
|**Entities/DAOs/Controllers**|Do they exist?| Entities (Y)/ DAOs (N)/ Controllers (Y)|
|**Java code quality**|Are methods single-purpose?| Y |
||Are classes appropriately-sized classes (no monster classes)?| Y |
||Are the same lines of code repeated at all?| N |
||Do any classes perform very similar functions that could be candidates for super/subclass relationships?| N |
||Are any values hard-coded that should be in a properties file?| N |
||Are variable names descriptive?| Y |
||Are there many branches or loops that could be simplified or broken up into smaller methods?| N |
||Do the DAOs use Hibernate? No hard-coded sql!| N/A |
||Other comments/notes?| Just need to create DAO's! |
|**Logging**|Has log4J been added?| Y |
||Are there logging statements in the code?| Y |
||Are appropriate logging levels used? Info, debug, error, for example.| Y |
||Are there any remveErrs in the code?| N |
||Other comments/notes?| N/A |
|**Unit Tests**|Do they exist?| Y |
||Do the tests pass?| Y |
||What is the current code coverage?| ? |
||Is each test truly a unit test or are they functional tests?| Unit tests |
||Other comments/notes?| N/A |
|**Web Service/API integration**|Has a web service/api been selected? | N |
||What web services/apis might work well with this application?| Group Project API |
|**Independent research topic**| Has a topic been selected?| Maybe |
||What topic/s might fit well in this application?| Talked researching and using SASS |
