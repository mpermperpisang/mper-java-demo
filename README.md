
# 🚀 koeality.njineeer-java-demo

Automated web UI testing project using **Java**, **Selenium WebDriver**, **Cucumber**, and **Allure Report**.

---

## ✅ Prerequisites & Setup

### 1. Install JDK (Recommended: OpenJDK 17+)

#### macOS
```bash
brew install openjdk
sudo ln -sfn /opt/homebrew/opt/openjdk/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk.jdk

echo 'export PATH="/opt/homebrew/opt/openjdk/bin:$PATH"' >> ~/.bash_profile
source ~/.bash_profile

java -version
```

#### Linux (Debian/Ubuntu)
```bash
sudo apt install openjdk-17-jdk -y

echo 'export JAVA_HOME="/usr/lib/jvm/java-17-openjdk-amd64"' >> ~/.bash_profile
echo 'export PATH="$JAVA_HOME/bin:$PATH"' >> ~/.bash_profile
source ~/.bash_profile

java -version
```

#### Windows
- Download and install Temurin JDK 17 (LTS) from [Adoptium](https://adoptium.net/).
- Set `JAVA_HOME` environment variable and update `PATH`.
- Verify installation:
  ```bash
  java -version
  ```

### 2. Install ChromeDriver
- Ensure ChromeDriver version matches your Chrome browser.
- Download from [ChromeDriver Downloads](https://sites.google.com/chromium.org/driver/).
- Place `chromedriver` in your system `PATH` or specify its location in the test configuration.

---

## 🛠️ Build Project

```bash
./gradlew clean build
```

---

## 🧪 Running Tests

### Run All Tests
```bash
./gradlew test
```

### Run Tests with Specific Tags
```bash
./gradlew test -Dcucumber.options="--tags @smoke"
```

---

## 📊 Generate and View Allure Reports

### Install Allure CLI

#### macOS
```bash
brew install allure
```

#### Linux
Follow instructions on [Allure Docs](https://docs.qameta.io/allure/#_installing_a_commandline)

#### Windows
Download and install from [Allure Releases](https://github.com/allure-framework/allure2/releases)

### Generate Report
```bash
./gradlew clean test allureReport
```

### View Report
```bash
./gradlew allureServe
```
> This starts a local server and opens the report in your default browser.

---

## 📌 Notes

- Update ChromeDriver path after Chrome updates.
- Adjust JVM options or memory settings if tests fail.
- Feature files: `src/test/resources`
- Page objects & utilities: `src/main/java`
- Step definitions & runners: `src/test/java`

---

## 📚 Tools & Libraries

- Java 17+
- Selenium WebDriver 4.x
- Cucumber JVM 7.x
- JUnit 4.13+
- Allure Report 2.x
- Gradle

---

Let me know if you'd like a `Makefile` or custom Gradle tasks to streamline your workflow!
