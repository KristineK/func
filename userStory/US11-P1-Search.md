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

#Tests
/// Scenario US11-T01: Validate searchbar ir present on homepage
Execute test: testSearchBarHomepage
Expected result: search bar is displayed on homepage
Actual result: search bar is displayed on homepage

/// Scenario US11-T02: Validate that "Iph" returns search results for Iphone from different homepage section
Execute test: testSearchForIphFromPCsection
Expected result: In search results are shown Iphone items
Actual result: Shows no search results for string "iph"

/// Scenario US11-T03: Validate that string "Ip" returns search results for iphone and ipod


/// Scenario US11-T04: Validate that search results return product descriptions
Execute test: testSearchDescription
Expected result: When user searches product description, items including this product description are returned
Actual result: As expected results

Note. Not user friendly that if someone wants to search something by description, he needs to first of all check the checkbox for searching in product description

/// Scenario US11-T05: Validate that search in subcategories return correct results for that subcategory



/// Scenario US11-T06: Validate that products can be sorted and have pagination

#Bugs
1) When user searches something and in browser moves back a page, then in searchbox searched string dose not change.
    Steps to reprouduce:
    1)Input anything in search box and click search button
    2)Input in search criteria section any string f.e."phone" and click search button which is in search criteria section.
    3)Navigate in browser one page back

    Excpected results: Search string changes to what it was in previous pages.
    Actual result: Search string changes in base url, in searchbox of uppder side of UI, and as a heading. But dose not change in search criteria search box.