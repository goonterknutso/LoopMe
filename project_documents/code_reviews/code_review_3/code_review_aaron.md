# Design/Code Review 3

## Project: IRV

### Developer: Aaron Anderson

#### Reviewer: Gunther Knutson

|Category|Criteria|Rating/Comments|
|--------|---------|---------------|
|**Project Overview**|| |
||Which planned functionality has been met? | I cloned from the master branch, couldn't sign up on domain... From what I could tell in class, everything was working! |
|| What planned functionality has not been met? | Just extra ideas that weren't vital to the project completion|
||Describe the GitHub history and what it demonstrates about the project progress during the semester.| Very very steady completion! A lot of time has been consistently put into this and it's noticeable! |
||Describe how peer and instructor feedback/recommendations were incorporated into the project?| Mentioned abstracting the DAO but likely won't be included in final version, just an interesting idea discussed. |
||Other comments/notes?| |
|**JSPs**|| |
||Evaluate the JSPs for templating, business logic, data validation, overall look and feel.| Well templated and oranized! |
||Other comments/notes?| |
|**Java code quality**|Evaluate the code quality for the following and identify specific areas for improvement (class, method or line number) <li>single-purpose methods <li>well-structured project <li>descriptive naming of packages, classes, methods, variables <li>classes appropriately-sized  (no monster classes) <li> CPD (copy paste detection, meaning are the same lines of code repeated <li>are there candidates for super/subclass relationships, abstract classes, interfaces? <li>are any values hard-coded that should be in a properties file? <li>proper exception handling <li>proper error reporting to the user <li> code documentation ||Code meets all of these criteria. | |
|**Logging**|Evaluate the use of logging, for example:<li>appropriate use of logging statements in the code for error logging and debugging <li>logging levels used - info, debug, error <li> no occurrences of  printlns or printStackTrace() <li> logging works on Digital Ocean deploy||Logging is used throughout the project with both debug and error level logs.| |
|**Logging**|Evaluate the use of logging, for example:<li>appropriate use of logging statements in the code for error logging and debugging <li>logging levels used - info, debug, error <li> no occurrences of  printlns or printStackTrace() <li> logging works on Digital Ocean deploy||Logging is used throughout the project with both debug and error level logs.| |
|**Unit Tests**|Evaluate the unit tests, for example: <li>tests are truly a unit test rather than a high level functional test <li>test data is appropriately cleaned up or handled <li> there is full coverage of methods that perform business logic or utility functions <li>redundant code is eliminated by using set up and tear down methods, i.e., @Before, @After| Unit test pass and there is good use of @Before and @After tags. Test are good.|
||Other comments/notes?| |
|**Security**|Evaluate authentication/authorization:| Well designed security using excryption! I know there was a lot of effort but in here!|
||Is it implemented correctly and working locally as well as on Digital Ocean? | No? I tried signing up on your domian and go a 404. HTTP Status 404 - /newvoter|
||Other comments/notes?| |
|**Web Service/API integration**|Evaluate the service/api integration, for example: <li> Which service/api is implemented? <li>how is  error handling of the service implemented? For example, What happens if the service is not available?| WebService API for IRV is implemented within project. If the service is not availble the site isn't either so no error handling necessary. |
||Other comments/notes?| |
|**Independent research topic**| What is the independent research topic?| SASS |
||Is the independent research topic/technique implemented in the project?| Of course! Aaron = CSS God |
||Other comments/notes?| |
|**Deployment**| Has the application been successfully deployed to Digital Ocean or another hosting service?| I believe so? Signing up was an issue for me but the site is there and running. |
||Is the hosted application fully functioning?| Negative. |
||Other comments/notes?| |