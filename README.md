# Functional test
2 variable to run "-DbaseUrl" and "-Dwebdriver.chrome.driver". Sample:
> "-DbaseUrl="https://github.io" -Dwebdriver.chrome.driver=path_to\chromedriver.exe"

Note: it is possible to use chromedriver from "resources/lib" folder.

Maven sample (for reports):
> mvn clean test site -DbaseUrl="https://github.io" -Dwebdriver.chrome.driver=path_to\chromedriver.exe

Note: report are see only in FF, not in chrome