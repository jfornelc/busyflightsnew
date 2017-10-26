**Travix - Problem to be solved**

**Notes**

BusyFlights is a flights search solution that is getting flights from the CrazyAir and BusyFlight suppliers.

In this exercise I have modified the Request and Response classes by adding a constructor class and implementing an
interface with some methods, to get the supplier parameters, supplier type and to convert the suppliers to BusyFlightResponse.

I have added a Builder Pattern in ThoughJetResponse, because the custom constructor had too many parameters.

I have added some validations to check the size of some attributes in the request, and I have added a Serializer and Deserializer
for LocalDateTime and Instant objects.

I have analyzed the code by using SonarLint in Intellij to improve the quality in my code.

For the next steps would be needed:
- Add more validations for the request and the response models
- Add more integration and unit tests
- Add some comments to the code