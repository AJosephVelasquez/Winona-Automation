# Winona UI Task Assessment

This project contains automated UI tests written in **Java + Selenium + TestNG**. Included a scenario wherein age of user is not within the range.

## Prerequisites

Ensure the following are installed on your system before running the tests:

1.  **Java 11 or later**
    -   [Download Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html)

    -   After installation, verify by running:
        java -version

2.  **Maven**
    -   [Download Maven](https://maven.apache.org/download.cgi)

    -   Follow the installation guide: [Maven Installation
        Guide](https://maven.apache.org/install.html)

    -   Verify by running:
        mvn -v

## How to Run Tests

Go to your Command Prompt, and cd to the project's directory. Afterwards, you may choose to run what kind of tests

### Run Happy Path tests

mvn clean verify -PHappyPath

### Run Error Validation tests

mvn clean verify -PErrorValidation (added this just to show how the UI behaves when the user's age is not within the range)

## Test Reports

After running tests, you can find reports in the `target/surefire-reports` or `target/test-output` folder depending on your configuration.

## Project Structure

-   `src/main/java` → Helper classes and page objects.
-   `src/test/java` → Test classes, components, and data.
-   `pom.xml` → Project dependencies and Maven configurations.

## Notes

-   Make sure Chrome or the desired browser is installed for Selenium WebDriver.

## Screen Records

### Happy Path
- https://drive.google.com/file/d/1GlnWyCcjQo4YMffo_KTZk482XDb9ycJd/view?usp=sharing

### Error Validation (Invalid Age)
- https://drive.google.com/file/d/1ZVVrgiaBvW6rJepWaFHQ-BNOR780VVX5/view?usp=sharing
