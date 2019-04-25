Feature: UserLogin
 Description: User login in the factset application
  
  @smoke
  Scenario Outline: Unsecussful login
    Given Factset application is launched
    When user navigates to Login
   And user enters email invalidemail and password invalidpassword
   Then user validates the error message errormessage1
   
   Examples:
   | invalidemail | invalidpassword | errormessage1 |
   | hari		  | pass            | Invalid username or password.|