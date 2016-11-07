# Design/Code Review 2

## Project: Roomie

### Developer: Tim Morency

#### Reviewer: Gunther Knutson

|Category|Criteria|Analysis/Comments|
|--------|---------|---------------|
|**Running application**|| |
||Describe the application functionality that has been built and is working.| Build but getting errors in Tomcat trying to open index.jsp |
||What is good?| Looks like more JSPs have been built!|
||What could be improved?| Get it to load without errors? Maybe it's something on my end.|
|**Unit Tests**|| |
||What are the code coverage statistics?| Look like around 60%? | 
||Are @Before/@BeforeClass/@After/@AfterClass used to reduce redundant code?| Yes! | 
|**JSPs**|| |
|| Is templating used to eliminate rundandant code(for example, header.jsp, footer.jsp, etc.)| Yes! |
||What is good?| Templating is good and looks like a good start to making all the JSPs you need! |
||What could be improved?| Add more content and more JSPs |
|**Code quality**|| |
||Are methods single-purpose?| Yes |
||Are classes appropriately-sized classes (no monster classes)?| Yes |
||Are the same lines of code repeated at all?| No | 
||Do any classes perform very similar functions that could be candidates for super/subclass relationships?| No |
||Are any values hard-coded that should be in a properties file?| No |
||Are variable names descriptive?| Yes |
||Are there many branches or loops that could be simplified or broken up into smaller methods?| No |
||Do the DAOs use Hibernate? No hard-coded sql!| Yes! |
||Has log4J been added?| Yes but don't see and logs anywhere which is fine |
||Are there logging statements in the code?| |
||Are appropriate logging levels used? Info, debug, error, for example.| N/A |
||Are there any System.out.printlns in the code?| No |
||Other comments/notes?| N/A |
|**Web Service/API integration**|Which web service/api is being used? | Unsure, can't find in README |
||Is the integration built?| No |
|| If so, evaluate the integration code. What is good? What could use improvement?
|**Independent research topic**| What is the developer's independent research topic?| Unsure |
||Has the topic been implemented in the project?| No |
||If so, evaluate the implementation. What is good? What could use improvement?| |
|**Key takeaways**|List at least 3 things you learned while reviewing this project that will help you in your own project.||
|| 1.| Need to work on data persistance and storage for my own project |
|| 2.| After looking at your project, I know my templating that I have in mine is solid. |
|| 3.| I think that my entity classes could use some restructuring. |