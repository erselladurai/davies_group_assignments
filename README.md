## How to

### Execute Tests in Local
#### 1. Maven Execution (Command-line or Intellij Terminal) : 
 - Open Command-line or Terminal (Intellij)
 - `mvn clean test -P AllTests`

#### 2. IntelliJ Execution :
 - Create a new ***TestNG*** Run configuration in intelliJ
 - In the ***configuration*** tab, select the ***Test Kind*** as **Suite**
 - Add the .xml from the root .`../config/davies-group-assignment-tests.xml`
 - Click on the run

### Automation Test report
Report will be generated in the path from root .../TestReport/Test-Automaton-Report.html
