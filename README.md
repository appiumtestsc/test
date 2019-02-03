# Test Task

For work with this project from IDE you need lombok plugin.

To run the test, you need to change the following properties in the pom.xml to the current ones:

        <deviceName>ZTE BLADE V9</deviceName>
        <udid>000000</udid>
        <platformVersion>8.1.0</platformVersion> -- Android ver.
        <remoteAddress>http://0.0.0.0:4723/wd/hub</remoteAddress> -- Appium Server addres

To get the report use:
        mvn allure:serve
