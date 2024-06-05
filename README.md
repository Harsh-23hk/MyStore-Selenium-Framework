# My Store Selenium Data Driven Framework

Welcome to the My Store Selenium Data Driven Framework project! This project automates the testing of a sample
e-commerce website for women to buy clothes. The project leverages Selenium for browser automation and TestNG for
data-driven testing.

## Table of Contents

- [Introduction](#introduction)
- [Project Structure](#project-structure)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Configuration](#configuration)
- [Technologies Used](#technologies-used)
- [Framework Design](#framework-design)
- [Continuous Integration](#continuous-integration)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Introduction

Welcome to the My Store project automates the testing of the sample e-commerce
website [My Store](http://www.automationpractice.pl/index.php?controller=authentication&back=my-account). The automated
tests cover the registration, login, logout, adding products to the cart, and purchasing products. The responses of the
website are verified against the expected outputs.

## Project Structure

The project is organized as follows:

- **Configuration File:**
    - `config.properties`: Contains properties in key-value pairs for settings such as `URL`, `Browser`, `email`,
      and `password`.

- **Folders:**
    - `logs`: Stores log files generated during test execution.
    - `screenshots`: Stores screenshots captured during test execution.

- **Main Folder:**
    - `resources`: Contains `log4j2.properties` for logging configuration.
    - `PageObjectModel`: Holds the web elements for each page in the website.
    - `testcases`: Contains the test classes.
    - `utilities`: Contains helper classes.

- **Reports:**
    - After execution, Extent Reports generate an `.html` report with detailed test execution results.

## Features

- **Automated Testing:** Automates end-to-end testing of the My Store website.
- **Data-Driven Testing:** Uses TestNG to drive tests with multiple data sets.
- **Logging:** Logs all steps during test execution.
- **Screenshots:** Captures screenshots of test execution.
- **Reporting:** Generates detailed HTML reports post-execution.
- **Continuous Integration:** Integrates with Jenkins for automated builds and test executions.

## Installation

To install and set up the project, follow these steps:

1. **Clone the repository:**

    ```bash
    git clone https://github.com/Harsh-23hk/MyStore-Selenium-Framework.git
    cd MyStore-Selenium-Framework
    ```

2. **Install the required dependencies:**

Ensure you have Java and Maven installed. Then, install the dependencies:

```bash
mvn clean install
```

3. **Set up your configuration:**

Create a `config.properties` file in the root directory and add the necessary configuration. Refer to
the [Configuration](#configuration) section for more details.

## Usage

To execute the tests, follow these steps:

1. **Run the test suite:**

    ```bash
    mvn test
    ```

2. **View the logs:**

Check the `logs` folder for log files to monitor the test execution process.

3. **View the report:**

After execution, open the generated `.html` report located in the `reports` folder to see detailed test results.

## Configuration

The `config.properties` file should include the following key-value pairs:

```properties
URL=http://www.automationpractice.pl/index.php?controller=authentication&back=my-account
Browser=chrome
email=your-email@example.com
password=your-password
  ```

## Technologies Used

* Java
* Maven
* TestNG
* Selenium
* Extent Report
* Apache POI
* Log4j
* WebDriver Manager
* Framework Design
* Page Object Model (POM)
* Data Driven Testing

## Continuous Integration

The project integrates with Jenkins for continuous integration and automated test execution. Jenkins helps in scheduling
and managing test runs, ensuring that the tests are executed regularly and that results are monitored continuously.

## Contributing

We welcome contributions from the community! To contribute:

Fork the repository.

```
Create a new branch (git checkout -b feature/your-feature-name).
Make your changes.
Commit your changes (git commit -m 'Add some feature').
Push to the branch (git push origin feature/your-feature-name).
Create a new Pull Request.
 ```

## Contact

For any questions or feedback, please reach out to:

##### **Harsh**

#### **GitHub: Harsh-23hk**
