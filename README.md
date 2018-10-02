# Automation test
2 variable to run "-DbaseUrl" and "-Dwebdriver.chrome.driver". Sample:
> "-DbaseUrl="http://demoshop24.com" -Dwebdriver.chrome.driver=path_to\chromedriver.exe"

Note: it is possible to use chromedriver from "resources/lib" folder.

Maven sample (for reports):
> mvn clean test site -DbaseUrl="http://demoshop24.com" -Dwebdriver.chrome.driver=path_to\chromedriver.exe

Note: report are see only in FF, not in chrome

# Tests and Bug
Test and bug are in the folder [userStory](../master/userStory) for each story.
