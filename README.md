⚠️ Important Note Regarding API Test Results

This project demonstrates the usage of HTTP methods such as GET, POST, PUT, DELETE, and others using a mock API.

Since the backend is not a real or stateful API, certain request types (especially PUT and DELETE) do not result in actual data updates or deletions.

PUT and DELETE responses are accepted by the mock server (e.g., with status code 200 or 201),

However, the data returned afterward does not reflect any real change, and

This can cause assertions in tests to fail, even if the request was technically successful.

This behavior is expected in mock environments and does not indicate a problem in the test code.

✅ For complete and realistic testing, it is recommended to connect the test suite to a real, stateful backend or use a local mock server (such as json-server) that can simulate full CRUD behavior with persistence.


#######################################################################
# DummyJSON API Test Automation (Java + REST Assured)

This is a test automation project that performs CRUD operations on the [DummyJSON API](https://dummyjson.com/) using Java and REST Assured. The project is structured using reusable methods and POJOs for better maintainability and scalability.

## 📦 Features
- ✅ GET Request Testing
- ✅ POST Request Testing
- ✅ PUT Request Testing *(see note below)*
- ✅ PATCH Request Testing
- ✅ DELETE Request Testing
- 🔁 Reusable methods for request handling
- 🔍 Soft assertions for detailed verification

## ⚠️ Note on PUT Requests
Due to the mock nature of the DummyJSON API, PUT requests do not persist updates. Tests related to PUT are for structural demonstration and may fail if compared against a GET response post-update.

Project Structure:

Base/
- BaseTest.java
- ReUseableMethods.java

Tests/
- Positive_GET_Request_TESTS.java
- Positive_POST_Request_TESTS.java
- Positive_PUT_Request_TESTS.java
- Positive_PATCH_Request_TESTS.java
- Positive_DELETE_Request_TESTS.java

Test_Data/
- DummyExpectedTestData.java

Pojos/
- PostsPojos/
    +Posts.java
    +Post.java
    +Reactions.java
- User_Address_Pojo/
    +Address.java
    +User.java


## 🚀 How to Run
1. Clone the repo
2. Import as a Maven/Gradle project
3. Run tests using your IDE or via CLI:
   ```bash
   mvn test

🔧 Dependencies
    -Java 11+
    -REST Assured
    -TestNG
    -Gson / Jackson for POJO mapping

## 📊 Future Improvements

- ✅ **Cucumber Integration** for BDD-style testing
- 🔄 **Reporting System** (e.g., ExtentReports or Allure)

## 👨‍💻 Author

Kadirhan Sarıyılmaz - QA Engineer  
[LinkedIn](https://www.linkedin.com/in/kadirhansariyilmaz/) | [GitHub](https://github.com/kadirhanS)
