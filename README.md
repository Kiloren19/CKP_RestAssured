
REST Assured Checkpoint:

This repository contains a REST Assured Checkpoint project developed by Rafael Zuñiga Vindas.

Author
Rafael Zuñiga Vindas

Project Structure:

- src
  - main
    - java
      - App.java (Empty)
    - resources
      - QuoteSchema.json (JSON schema file)
  - test
    - java
      - config
        -TestConfig.java (Empty)
      - AppTest.java (Here its were all the test are)
- target
- pom.xml (Maven configuration file)
- README.md (Project documentation)

Running the Tests:

To execute the tests, it's recommended to use NetBeans IDE for easy of setup and execution. Follow these steps:

- Clone the repository to your local machine.
- Open NetBeans IDE.
- Import the project into NetBeans.
- Once imported, navigate to the test files located in the src/test/AppTest.java
- Right-click on the test file or package you want to run.
- Choose "Run File" or "Run Test Package" from the context menu. Alternatively, you can run the tests using Maven from the command line using "mvn test"

Note
Ensure that you have Java 8 or higher installed on your system and Maven properly configured, with NetBeans the instalation of maven 
its not necessary.