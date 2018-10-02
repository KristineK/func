# Search 
Priority 1
## Description 
User is able to search in product list
## Requirements
1)	Search bar is displayed at all pages

2)	Search by name regexp

3)	Search in product descriptions

4)	Search in subcategories

5)	List of products after search can be sorted and have pagination

## Acceptance criteria
Search returns correct results and work from all pages
## Highlights for testing
Correct search for short search string – ‘Iph’ return ‘Iphone’, ‘Ip’ return ‘ipod’ and ‘iphone’

## Tests
### Scenario US11-T01: Validate searchbar ir present on homepage
Execute test: testSearchBarHomepage
Expected result: search bar is displayed on homepage
Actual result: search bar is displayed on homepage
Automated: Yes

### Scenario US11-T02: Validate that short searching works as supposed 
Execute test: testSearchForIphFromPCsection
Expected result: In search results are shown items which contains string in their name "Phone"
Actual result: In search results are shown items which contains string in their name "Phone"


### Scenario US11-T04: Validate that search results return product descriptions
Execute test: testSearchDescription
Expected result: When user searches product description, items including this product description are returned
Actual result: As expected results
Automated: Yes

Note. Not user friendly that if someone wants to search something by description, he needs to first of all check the checkbox for searching in product description


### Scenario US11-T05: Validate that search in subcategories return correct results for that subcategory
Preconditions : user already is on search page
1) Input in search box String: "Bak"
2) Select from Categories dropdown box option: "Bak"
3) Check box "search in subcategories"
3) Click Search button 

Expected result: All items returned which have sub category Bak
Actual result: All items returned which have sub category Bak



### Scenario US11-T06: Validate that products can be sorted and have pagination

## Bugs
1) When user searches something and in browser moves back a page, then in searchbox searched string dose not change.
    Steps to reprouduce:
    1)Input anything in search box and click search button
    2)Input in search criteria section any string f.e."phone" and click search button which is in search criteria section.
    3)Navigate in browser one page back

    Excpected results: Search string changes to what it was in previous pages.
    Actual result: Search string changes in base url, in searchbox of uppder side of UI, and as a heading. But dose not change in search criteria search box.

    ![Bug 1.](Images/US11_Bug_1.PNG?raw=true "")

       
2) When User searches multiple times searches same string with checking and unchecking box : "Search in subcategories" , this check dose not work properly.
    Preconditions: User is on search page
    Steps to reproduce:
    1) Input String "Bak" in search box
    2) Click search and save results from search.(6 results)
    2) From Categories dropdown window select option "Bak" and check "Search in subcategories" checkbox.
    3) Click search and collect results. (3 results )
    4) Uncheck "Search in subcategories" checkbox
    5) Click search
    6) Compare results (3 results)
    
    Expected results: When checkbox "Search in subcategories" checkbox is unchecked, search results should show all results.
    Actual results: When user has previously checked "Search in subcategories" checkbox, and then unchecked it, it still shows
    results for the same subcategory.