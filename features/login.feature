Feature: Login to application

Scenario: Login to the application
  Given Launch site
  When Enter Credentials
  |standard_user|secret_sauce|
  And Visit Homepage
  And Add to cart
  And checkout
  |sayali|jam|421503|
  And logout
  Then Close Browser