
Feature: feature to test email functionality

  Scenario: Verify email is sent successfully to valid recepient
    
    Given browser is open 
		And user navigates to gmail application
		And user enter gmail credentials
    When user add recipient mail <emailrecipient>, subject <subject> and body <body>
    Then email should be sent successfully 


    Examples: 
   		| emailrecipient | subject | body  |
   		|	mayurijangam98@gmail.com | Incubyte |  Automation QA test for Incubyte |
   		| mayurijangam98@gmail.com | 124AA%%@ |  124BAA%%@ |
   		
     