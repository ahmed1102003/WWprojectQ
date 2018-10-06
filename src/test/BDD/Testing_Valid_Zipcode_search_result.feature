Feature: WW find location 

Scenario: Testing valid Zipcode in search result


Given User at Home page

When I Click on //*[@id="ela-menu-visitor-desktop-supplementa_find-a-studio"] button by xpath

And I Enter 10011 in the meetingSearch
 
And I Click on //*[@id="content"]/div/div/ui-view/ui-view/div/div/div/div/div[2]/div[1]/div/form/div[1]/span/button button by xpath
 
And I Click on //*[@id="ml-1180510"]/result-location/div/div[1] button by xpath


